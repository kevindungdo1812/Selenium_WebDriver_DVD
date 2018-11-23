package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_WebElement_WebBrowser {
	WebDriver driver;
		By emailByTextbox = By.xpath("//input[@id='mail']");
		By ageUnder18ByRadio = By.xpath("//input[@id='under_18']");
		By educationByTextarea = By.xpath("//textarea[@id='edu']");
		By jobRole01BySelect = By.xpath("//select[@id='job1']");
		By interestsDevelopmentByCheckbox = By.xpath("//input[@id='development']");
		By silder01ByRange = By.xpath("//input[@id='slider-1']");
		By buttonIsEnabledByButton = By.xpath("//button[@id='button-enabled']");
		
		By passwordByTextbox = By.xpath("//input[@id='password']");
		By ageIsDisabledByRadio = By.xpath("//input[@id='radio-disabled']");
		By biographyByTextarea = By.xpath("//textarea[@id='bio']");
		By jobRole02BySelect = By.xpath("//select[@id='job2']");
		By interestsIsDisabledByCheckbox = By.xpath("//input[@id='check-disbaled']");
		By silder02ByRange = By.xpath("//input[@id='slider-2']");
		By buttonIsDisabledByButton = By.xpath("//button[@id='button-disabled']");
		
	
 
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
	  @Test
	  public void TC_01_ElementIsDispled() {
		  if (isControlDisplayed(emailByTextbox)) {
			  driver.findElement(emailByTextbox).sendKeys("Automation Testing");
		  }
		  	  
		  if (isControlDisplayed(educationByTextarea)) {
			  driver.findElement(educationByTextarea).sendKeys("Automation Testing");
		  }
		  
		  if (isControlDisplayed(ageUnder18ByRadio)) {
			  driver.findElement(ageUnder18ByRadio).click();
		  }
		 
		}
	  @Test
	  public void TC_02_ElementEnableDisable() {
		  
		  //Enabled
			  Assert.assertTrue(isControlEnabled(emailByTextbox));
			  Assert.assertTrue(isControlEnabled(educationByTextarea));
			  Assert.assertTrue(isControlEnabled(ageUnder18ByRadio));
			  Assert.assertTrue(isControlEnabled(jobRole01BySelect));
			  Assert.assertTrue(isControlEnabled(interestsDevelopmentByCheckbox));
			  Assert.assertTrue(isControlEnabled(silder01ByRange));
			  Assert.assertTrue(isControlEnabled(buttonIsEnabledByButton));
			  
			  //Disabled
			  Assert.assertFalse(isControlEnabled(passwordByTextbox));
			  Assert.assertFalse(isControlEnabled(ageIsDisabledByRadio));
			  Assert.assertFalse(isControlEnabled(biographyByTextarea));
			  Assert.assertFalse(isControlEnabled(jobRole02BySelect));
			  Assert.assertFalse(isControlEnabled(interestsIsDisabledByCheckbox));
			  Assert.assertFalse(isControlEnabled(silder02ByRange));
			  Assert.assertFalse(isControlEnabled(buttonIsDisabledByButton));  	  
		 
		}
	 @Test
	  public void TC_03_ElementIsSelectedOnPage() {
		  
		 // Click selected
		  driver.findElement(ageUnder18ByRadio).click();
		  driver.findElement(interestsDevelopmentByCheckbox).click();
		  
		  Assert.assertTrue(isControlSelected(ageUnder18ByRadio));
		  Assert.assertTrue(isControlSelected(interestsDevelopmentByCheckbox));
		  
		  //Click unselected development
		  driver.findElement(interestsDevelopmentByCheckbox).click();
		  Assert.assertFalse(isControlSelected(interestsDevelopmentByCheckbox));
		  
		  //Chọn lại 1 lần nữa
		  if(!isControlSelected(interestsDevelopmentByCheckbox)) {
			  driver.findElement(interestsDevelopmentByCheckbox).click();
			  Assert.assertTrue(isControlSelected(interestsDevelopmentByCheckbox));
		  }
		 
		}
	  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
	  public boolean isControlDisplayed(By by) {
		  WebElement element = driver.findElement(by);
		  if (element.isDisplayed()) {
			  System.out.println("Element [" + by +"] is displayed!");
			  return true;
		  }
		  else {
			  System.out.println("Element [" + by +"] is not displayed!");
			  return false;
		  }
		  
	  }
	  public boolean isControlSelected(By by) {
		  WebElement element = driver.findElement(by);
		  if (element.isSelected()) {
			  System.out.println("Element [" + by +"] is selected!");
			  return true;
		  }
		  else {
			  System.out.println("Element [" + by +"] is not selected!");
			  return false;
		  }
		  
	  }
	  public boolean isControlEnabled(By by) {
		  WebElement element = driver.findElement(by);
		  if (element.isEnabled()) {
			  System.out.println("Element [" + by +"] is enabled!");
			  return true;
		  }
		  else {
			  System.out.println("Element [" + by +"] is disabled!");
			  return false;
		  }
		  
  }

}
