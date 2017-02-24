package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Student;

public interface StudentMapper {

	public List<Student> getList(Student student);

	public void insert(List<Student> studentList);

	public void remove(@Param("mobile") String mobile);
}
