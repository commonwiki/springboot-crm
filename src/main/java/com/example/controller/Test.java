package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.domain.Student;

public class Test {

	public static void main(String[] args) {

		Student customer = new Student();

		customer.setName("wcw");
		customer.setMobile("13430883881");
		customer.setMail("447686844@qq.com");
		customer.setSex("男");

		// 用户组对象转JSON串
		String jsonString = JSON.toJSONString(customer);
		System.out.println("jsonString:" + jsonString);

		// JSON串转用户组对象
		Student group2 = JSON.parseObject(jsonString, Student.class);
		System.out.println("group2:" + group2);

	}
}
