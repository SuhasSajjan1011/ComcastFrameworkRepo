package testcase;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Exception {

		ExcelUtility eLib = new ExcelUtility();// 02
		eLib.writeDataIntoExcel("Sheet1", 4, 5, "STATUS");

	}

}
