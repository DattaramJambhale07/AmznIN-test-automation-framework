package utilityclasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReader {

	public String un1;
	public String pwd1;
	
	public String un2;
	public String pwd2;
	
	public void FetchingdatafromSheet() throws EncryptedDocumentException, IOException
	{

			FileInputStream f1 = new FileInputStream("C:\\Users\\Akshay Jambhale\\eclipse-workspace\\Project_1\\DataSorceforP1\\LoginCredentials.xlsx");
			Workbook wb = WorkbookFactory.create(f1);
			
			un1 = wb.getSheet("Login_cred").getRow(0).getCell(0).getStringCellValue();
			pwd1 = wb.getSheet("Login_cred").getRow(0).getCell(1).getStringCellValue();
			
			un2 = wb.getSheet("Login_cred").getRow(1).getCell(0).getStringCellValue();
			pwd2 = wb.getSheet("Login_cred").getRow(1).getCell(1).getStringCellValue();
			
	}
	
}
