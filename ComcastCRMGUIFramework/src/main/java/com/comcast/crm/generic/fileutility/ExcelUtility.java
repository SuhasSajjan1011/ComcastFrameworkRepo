package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String SheetName,int rowNum,int cellNum) throws Exception
	{
		
		FileInputStream fis=new FileInputStream("./testData/Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	public void writeDataIntoExcel(String Sheet,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/Book2.xlsx");
		
        Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(Sheet).getRow(rowNum).createCell(cellNum);	
		
		FileOutputStream fos= new FileOutputStream("./testData/Book2.xlsx");
		wb.write(fos);
	}
	public int getRowCount(String Sheet) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(Sheet).getLastRowNum();
		return rowCount;	
	}
	
	 

}
