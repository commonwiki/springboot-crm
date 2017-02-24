package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.ReadExcel;
import com.example.domain.FileUpload;
import com.example.domain.Student;
import com.example.mapper.FileUploadMapper;
import com.example.mapper.StudentMapper;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private FileUploadMapper fileUploadMapper;

	public Map getList(Student student) {

		List<Student> list = studentMapper.getList(student);

		Map<String, List> map = new HashMap<String, List>();
		map.put("data", list);

		return map;
	}

	public void remove(String mobile) {
		studentMapper.remove(mobile);
	}

	public int insert(List<FileUpload> fileUploadList) throws Exception {

		int a = 0;

		for (int i = 0; i < fileUploadList.size(); i++) {

			List<Student> studentList = ReadExcel.test(fileUploadList.get(i).getPath());
			studentMapper.insert(studentList);
			a += fileUploadMapper.update(fileUploadList.get(i).getId());

		}

		return a;

	}
}
