package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\loginData.xlsx"; //path of the excel file in tastData folder
		
		ExcelUtility util = new ExcelUtility(path);
		
		int rowCount = util.getRowCount("Sheet1");       //5
		int colCount = util.getCellCount("Sheet1", 1);   //3
		
		String[][] str = new String[rowCount][colCount]; //created 2D array to store data 
		
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				String s = util.getCellData("Sheet1", i, j);
				str[i-1][j] = s;
			}
		}
		
		return str;
	}

}
