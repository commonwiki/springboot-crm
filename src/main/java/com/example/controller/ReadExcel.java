package com.example.controller;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.ResourceUtils;

import com.example.domain.Student;

public class ReadExcel {

	public static List<Student> test(String path) throws Exception {

		// Excel文件
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(path)));

		System.out.println(wb.getNumberOfSheets());

		// Excel工作表
		HSSFSheet sheet = wb.getSheetAt(0);

		// 表头那一行
		HSSFRow titleRow = sheet.getRow(0);

		// System.out.println(sheet.getSheetName());

		int name = 0;
		int mobile = 0;
		int mail = 0;
		int sex = 0;
		int education = 0;

		for (int i = 0; i < titleRow.getLastCellNum(); i++) {

			String cell = titleRow.getCell(i).getStringCellValue();

			// System.out.println(i + " = " + cell);

			if (cell.indexOf("姓名") != -1) {
				name = i;
			}

			if (cell.indexOf("电话") != -1) {
				mobile = i;
			}

			if (cell.indexOf("邮件") != -1) {
				mail = i;
			}

			if (cell.indexOf("性别") != -1) {
				sex = i;
			}

			if (cell.indexOf("学历") != -1) {
				education = i;
			}

		}

		List<Student> list = new ArrayList<Student>();

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

			Student customer = new Student();

			customer.setName(sheet.getRow(i).getCell(name).getStringCellValue());

			customer.setMobile(sheet.getRow(i).getCell(mobile).getStringCellValue());
			customer.setMail(sheet.getRow(i).getCell(mail).getStringCellValue());
			customer.setSex(sheet.getRow(i).getCell(sex).getStringCellValue());
			customer.setEducation(sheet.getRow(i).getCell(education).getStringCellValue());

			list.add(customer);

		}

		return list;

	}

}
