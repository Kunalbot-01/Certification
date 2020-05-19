package generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
	
	public static String[][] getData(String fileName, String sheetName)
	{
		File f = null;
		FileInputStream fin = null;
		Workbook wb = null;
		Sheet sh = null;
		try
		{
			f = new File(fileName);
			fin = new FileInputStream(f);
			wb = new XSSFWorkbook(fin);
			sh = wb.getSheet(sheetName);
			int rowNum = sh.getLastRowNum()+1;
			int colNum = sh.getRow(0).getLastCellNum();
			
			String[][] data = new String[rowNum][colNum];
			for(int i =0; i<rowNum; i++)
			{
				Row r = sh.getRow(i);
				for(int j = 0; j<colNum; j++)
				{
					Cell c = r.getCell(j);
					String value = new DataFormatter().formatCellValue(c);
					data[i][j] = value;
				}
			}
			return data;
			
			
		}
		catch(Exception e)
		{
			return null;
		}
		finally
		{
			try
			{
				sh = null;
				wb.close();
				wb= null;
				fin.close();
				fin=null;
				f=null;
				
			}
			catch(Exception e)
			{
				
			}
		}
		
		
	}

}
