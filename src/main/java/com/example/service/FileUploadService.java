package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.FileUpload;
import com.example.mapper.FileUploadMapper;

@Service
public class FileUploadService {

	@Autowired
	FileUploadMapper fileUploadMapper;

	// Retrieve file
	public FileUpload findByFilename(String filename) {
		return fileUploadMapper.findByFilename(filename);
	}

	// Upload the file
	public void insert(FileUpload fileUpload) {
		fileUploadMapper.insert(fileUpload);
	}

	public List<FileUpload> getList() {
		return fileUploadMapper.getList();
	}

	public void update(int id) {
		fileUploadMapper.update(id);
	}

}
