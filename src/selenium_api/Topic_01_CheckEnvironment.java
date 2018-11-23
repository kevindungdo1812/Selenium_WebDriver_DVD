package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_01_CheckEnvironment {
	WebDriver driver;
	
 
  @BeforeClass
  public void beforeClass() {
	// Chrome
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				// Firefox
				/*driver = new FirefoxDriver();
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
			
			// Update
  }
  
  @Test
  public void TC_01_CheckTitle() {
	  String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Google");
	}


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}