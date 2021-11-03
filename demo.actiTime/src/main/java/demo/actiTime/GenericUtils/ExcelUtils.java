package demo.actiTime.GenericUtils;

import java.io.FileInputStream;

public class ExcelUtils {
	

	public String getStringData(String filepath,String sheetname,int rowno,int columnno) {
	try {
		
		FileInputStream file = new FileInputStream(sheetname);
		Workbook workbook=WorkbookFactory.create(file);
	    return workbook.getSheet(sheetname).getRow(rowno).getCell(columnno).getString();
	}catch (Exception e) {
		e.printStackTrace();
	}

}
