package com.example.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.FileUpload;
import com.example.service.FileUploadService;

@CrossOrigin
@RestController
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;

	@Value("${sys.file.savepath}")
	private String path;

	@RequestMapping("/file")
	public ModelAndView file(ModelAndView modelAndView) {

		modelAndView.setViewName("file");

		return modelAndView;
	}

	// Download a file
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<?> downloadFile(@RequestParam("filename") String filename) {

		FileUpload fileUpload = fileUploadService.findByFilename(filename);

		// No file found based on the supplied filename
		if (fileUpload == null) {
			return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
		}

		// Generate the http headers with the file properties
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "attachment; filename=" + fileUpload.getName());

		// Split the mimeType into primary and sub types
		String primaryType, subType;
		try {
			primaryType = fileUpload.getType().split("/")[0];
			subType = fileUpload.getType().split("/")[1];
		} catch (IndexOutOfBoundsException | NullPointerException ex) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		headers.setContentType(new MediaType(primaryType, subType));

		return new ResponseEntity<>(fileUpload.getFile(), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity uploadFile(MultipartHttpServletRequest request) {

		try {
			Iterator<String> itr = request.getFileNames();

			while (itr.hasNext()) {

				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);
				String mimeType = file.getContentType();
				String filename = file.getOriginalFilename();
				long size = file.getSize();

				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
				String dir = simpleDateFormat.format(date);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMHHmmssSSS");
				String disk_filename = dateFormat.format(date) + "_" + filename;

				String savePath = path + "/" + dir + "/" + disk_filename;

				File saveFile = new File(savePath);
				if (!saveFile.exists()) {
					saveFile.getParentFile().mkdirs();
				}

				file.transferTo(saveFile);

				FileUpload newFile = new FileUpload(filename, mimeType, savePath, size);

				fileUploadService.insert(newFile);

			}
		} catch (Exception e) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("{}", HttpStatus.OK);

	}

}
