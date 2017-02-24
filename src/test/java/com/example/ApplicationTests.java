package com.example;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.example.domain.Student;
import com.example.domain.WebDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	// 读取单个单元格
	@Test
	public void testRead() throws Exception {
		// Excel文件
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));

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

			String cell = sheet.getRow(i).getCell(i).getStringCellValue();
			// System.out.println(cell);
			Student customer = new Student();

			customer.setName(sheet.getRow(i).getCell(name).getStringCellValue());

			customer.setMobile(sheet.getRow(i).getCell(mobile).getStringCellValue());
			customer.setMail(sheet.getRow(i).getCell(mail).getStringCellValue());
			customer.setSex(sheet.getRow(i).getCell(sex).getStringCellValue());
			customer.setEducation(sheet.getRow(i).getCell(education).getStringCellValue());

			list.add(customer);

		}

		System.out.println(list);

	}

	// 读取到列表
	@Test
	public void testReadList() throws Exception {
		List<WebDto> list = new ArrayList<WebDto>();

		HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));

		HSSFSheet sheet = book.getSheetAt(0);

		for (int i = 2; i < sheet.getLastRowNum() + 1; i++) {
			HSSFRow row = sheet.getRow(i);
			String name = row.getCell(0).getStringCellValue(); // 名称
			String url = row.getCell(1).getStringCellValue(); // url
			String username = row.getCell(2).getStringCellValue();
			String password = row.getCell(3).getStringCellValue();
			// Integer readCount = (int) row.getCell(4).getNumericCellValue();

			// System.out.println(name);

			// list.add(new WebDto(name, url, username, password, readCount));
		}

		System.out.println("共有 " + list.size() + " 条数据：");

		// for (WebDto wd : list) {
		// System.out.println(wd);
		// }
	}
}
