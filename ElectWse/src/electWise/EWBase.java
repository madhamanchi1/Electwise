package electWise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.org.omg.CORBA.ExceptionDescription;

import jdk.nashorn.internal.ir.CatchNode;

//import com.sun.xml.internal.ws.policy.AssertionSet;

public class EWBase {
	
	
	@Test
	public void Ew_AboutUs() throws IOException, Exception
	
	{
	//	System.setProperty("webdriver.ie.driver", "D:\\selenium\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		// TODO Auto-generated method stub
		//WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.electwise.in/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'About Us')]"));
		element.click();
		//Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//h3[contains(text(),'About Us')]"));
		String checks = element1.getText();
		System.out.println(checks);
		Assert.assertEquals(checks, "About Us");
		driver.close();		

	}	

}


