package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mapper.FileUploadMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {

	@Autowired
	private FileUploadMapper mapper;

	@Test
	public void test() {

		List list = mapper.getList();

		System.out.println(list);

	}

}
