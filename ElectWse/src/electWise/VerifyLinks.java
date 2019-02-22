package electWise;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;
 
public class VerifyLinks {
 
	@Test
	public void brokenLinks() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.electwise.in/");
				
	/*	List<WebElement> links=driver.findElements(By.tagName("a"));
		List<WebElement> imageLinks = driver.findElements(By.tagName("img"));
		
		links.addAll(imageLinks);
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			links=driver.findElements(By.tagName("a"));
			imageLinks = driver.findElements(By.tagName("img"));
			
		}*/
		
		//Thread.sleep(2000);
		//driver.get("https://www.electwise.in/");
		driver.findElement(By.xpath("//a[@class='nav-link ' and @href='/news/']")).click();
		List<WebElement> newslinks=driver.findElements(By.tagName("a"));
		List<WebElement> newsimageLinks = driver.findElements(By.tagName("img"));
		
		newslinks.addAll(newsimageLinks);
		
		System.out.println("Total links are "+newslinks.size());
		
		for(int i=0;i<newslinks.size();i++)
		{
			
			WebElement elenews= newslinks.get(i);
			
			String newsurl=elenews.getAttribute("href");
			
			verifyLinkActive(newsurl);
			
			newslinks=driver.findElements(By.tagName("a"));
			newsimageLinks = driver.findElements(By.tagName("img"));
			
			/*if(driver.findElement(By.xpath("//a[@class='page-link' and @href='?page=2']")).isEnabled()) {
				verifyLinkActive(newsurl);
				
			}*/
			
		}
		
		driver.findElement(By.xpath("(//a[(contains(text(),'Parties'))])[2]")).click();
		List<WebElement> partieslinks=driver.findElements(By.tagName("a"));
		List<WebElement> partiesimageLinks = driver.findElements(By.tagName("img"));
		
		partieslinks.addAll(partiesimageLinks);
		
		System.out.println("Total links are "+partieslinks.size());
		
		for(int i=0;i<partieslinks.size();i++)
		{
			
			WebElement eleparties= partieslinks.get(i);
			
			String partiesurl=eleparties.getAttribute("href");
			
			verifyLinkActive(partiesurl);
			
			partieslinks=driver.findElements(By.tagName("a"));
			partiesimageLinks = driver.findElements(By.tagName("img"));
			
			/*if(driver.findElement(By.xpath("//a[@class='page-link' and @href='?page=2']")).isEnabled()) {
				verifyLinkActive(newsurl);
				
			}*/
			
		}
		
/*		driver.findElement(By.xpath("(//a[(contains(text(),'Politicians'))])[2]")).click();
		List<WebElement> politicianslinks=driver.findElements(By.tagName("a"));
		List<WebElement> politiciansimageLinks = driver.findElements(By.tagName("img"));
		
		politicianslinks.addAll(politiciansimageLinks);
		
		System.out.println("Total links are "+politicianslinks.size());
		
		for(int i=0;i<politicianslinks.size();i++)
		{
			
			WebElement elepoliticians= politicianslinks.get(i);
			
			String politiciansurl=elepoliticians.getAttribute("href");
			
			verifyLinkActive(politiciansurl);
			
			politicianslinks=driver.findElements(By.tagName("a"));
			politiciansimageLinks = driver.findElements(By.tagName("img"));
			
			if(driver.findElement(By.xpath("//a[@class='page-link' and @href='?page=2']")).isEnabled()) {
				verifyLinkActive(newsurl);
				
			}
			
		}*/
		
		/*driver.findElement(By.xpath("(//a[contains(text(),'Constituencies')])[2]")).click();
		List<WebElement> Constituencieslinks=driver.findElements(By.tagName("a"));
		List<WebElement> ConstituenciesimageLinks = driver.findElements(By.tagName("img"));
		
		Constituencieslinks.addAll(ConstituenciesimageLinks);
		
		System.out.println("Total links are "+Constituencieslinks.size());
		
		for(int i=0;i<Constituencieslinks.size();i++)
		{
			
			WebElement eleconstituencies= Constituencieslinks.get(i);
			
			String constituenciesurl=eleconstituencies.getAttribute("href");
			
			verifyLinkActive(constituenciesurl);
			
			Constituencieslinks=driver.findElements(By.tagName("a"));
			ConstituenciesimageLinks = driver.findElements(By.tagName("img"));
			
			if(driver.findElement(By.xpath("//a[@class='page-link' and @href='?page=2']")).isEnabled()) {
				verifyLinkActive(newsurl);
				
			}
			
		}*/
				
		driver.close();
		
	}

	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
	
	
	 
 
}