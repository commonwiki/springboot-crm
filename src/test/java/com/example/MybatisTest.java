package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Student;
import com.example.mapper.StudentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

	@Autowired
	private StudentMapper dao;

	@Test
	public void test() {

		List list = dao.getList(new Student());

		System.out.println(list);

	}

	@Test
	public void insert() {
		List<Student> studentList = new ArrayList<Student>();

		for (int i = 0; i < 100; i++) {

			Student student = new Student();
			student.setName("user" + i);
			student.setMobile("1300000000");
			student.setMail("123@qq.com");
			student.setSex("男");
			student.setEducation("本科");

			studentList.add(student);
		}

		dao.insert(studentList);
	}
}
