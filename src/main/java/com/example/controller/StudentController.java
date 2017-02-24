package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.FileUpload;
import com.example.domain.Student;
import com.example.service.FileUploadService;
import com.example.service.StudentService;
import com.example.validate.AjaxResponse;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping("/student")
	public String student() {
		return "student";
	}

	@RequestMapping("/students")
	@ResponseBody
	public Object students(Student student) {

		return service.getList(student);

	}

	@RequestMapping("/student/remove/{mobile}")
	@ResponseBody
	public AjaxResponse remove(@PathVariable("mobile") String mobile) {

		service.remove(mobile);
		AjaxResponse ajaxResponse = new AjaxResponse();

		return ajaxResponse;

	}

	@RequestMapping("/files")
	@ResponseBody
	public Object files() throws Exception {

		List<FileUpload> list = fileUploadService.getList();

		int i = service.insert(list);

		if (i > 0) {
			return new AjaxResponse(true, "你有份" + i + "文件已操作成功");
		} else {
			return new AjaxResponse(false, "没有可操作的文件");
		}

	}
}
