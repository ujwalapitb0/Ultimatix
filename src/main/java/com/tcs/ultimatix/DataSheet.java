package com.tcs.ultimatix;

import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
public class DataSheet extends Utilities{
	
	public static Workbook TestBook;
	public static Sheet Testplan ;
	public static Sheet TestData;
	
	
	public void ImportExcel()
	{
		
		String dataSheetPath= BaseDIR + "\\SanitySheet.xls";
		File DataSheet = new File(dataSheetPath);
		try
		{
			WorkbookSettings ws = new WorkbookSettings();
			ws.setEncoding("ISO-8859-1");
			TestBook = Workbook.getWorkbook(DataSheet, ws);
		}
		catch(BiffException ex)
		{
			System.out.println("exception is:"+ex);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:"+ e);
		}		
		
	}
	
	public void ReadSheet()
	{
		Testplan = TestBook.getSheet("Testplan");
		TestData = TestBook.getSheet("TestData");
		
	}
	
	public int ReadRunModeYes()
	{
		int countYes = 0;
		for(int j=0; j <= Testplan.getRows(); j++)
		{
			Cell cell = Testplan.getCell(1, j);
			if(cell.getContents().equalsIgnoreCase("yes"))
					countYes++;
		}
		return countYes;
		
	}
	
	

}
