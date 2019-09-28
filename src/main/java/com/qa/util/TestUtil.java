package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

	public static ArrayList<String[]> getDataExcel(String sheetName, String loc) throws IOException {

		ArrayList<String[]> al = new ArrayList<String[]>();

		FileInputStream fis = new FileInputStream(loc);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		// System.out.println(lastRowNum);
		for (int i = 1; i <= lastRowNum; i++) {

			String FirstName = sh.getRow(i).getCell(0).getStringCellValue();
			String LastName = sh.getRow(i).getCell(1).getStringCellValue();
			String UserName = sh.getRow(i).getCell(2).getStringCellValue();
			String Password = sh.getRow(i).getCell(3).getStringCellValue();
			String Email = sh.getRow(i).getCell(4).getStringCellValue();

			al.add(new String[] { FirstName, LastName, UserName, Password, Email });
		}

		// System.out.println(al.size());

		return al;
	}

}
