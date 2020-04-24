package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		for(int i=1;i<e.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			
			Thread.sleep(3000);
		}
		
		

	}

}
