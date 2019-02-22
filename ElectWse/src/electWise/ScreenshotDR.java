package electWise;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotDR {

	public static void main(String[] args) throws IOException {
		
		String[] resolutions = {
				//"1366x768",
				//"1920x1080",
				//"1024x600",
				//"1024x768",
				//"1366x768",
				//"1440x900",
				//"1680x1050",
				//"213x320",
				//"320x480",
				//"320x568",
				 //"375x667",
				 //"414x736",
				 //"384x640",
				 //"360x640",
				 //"768x1024",
				 //"640x480",
				 //"2436x1125",
				 "375x812"
				// add resolution
			};
	
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.electwise.in/");
		
		for (String resolution : resolutions) {
			String[] parts = resolution.split("x");
			
			// Screen resolution
			Dimension screenRes = new Dimension(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
			
			// Set browser resolution
			driver.manage().window().setSize(screenRes);
			
			// little pause
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				//Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			driver.navigate().refresh();
			
			// little pause
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				//Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
			}
				
			String filename = resolution;
		
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"/Snapshots/"+filename+".PNG"));
		
			
	}
		driver.quit();

}
}
