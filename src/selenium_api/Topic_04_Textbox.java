package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Textbox {
	WebDriver driver;
	private String newName, newDob, newAddress, newCity, newState, newPin, newMobile, newEmail, password;
	private String editAddress, editCity, editState, editPin, editMobile, editEmail, customerID;
	
	
	By nameByTextbox = By.xpath("//input[@name='name']");
	By dobByTextbox = By.xpath("//input[@name='dob']");
	By addrByTextarea = By.xpath("//textarea[@name='addr']");
	By cityByTextbox = By.xpath("//input[@name='city']");
	By stateByTextbox = By.xpath("//input[@name='state']");
	By pinByTextbox = By.xpath("//input[@name='pinno']");
	By mobileByTextbox = By.xpath("//input[@name='telephoneno']");
	By emailByTextbox = By.xpath("//input[@name='emailid']");
	By passwordByTextbox = By.xpath("//input[@name='password']");
	By submitByButton = By.xpath("//input[@name='sub']");
	
 
  @BeforeClass
  public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		newName ="Selenium Online";
		newDob ="2000-10-01";
		newAddress ="123 Address";
		newCity ="Ho Chi Minh";
		newState ="Thu Duc";
		newPin ="123456";
		newMobile ="0123456789";
		newEmail ="autotest" + Commons.randomEmail() +"@gmail.com";
		password ="123456";
			
		editAddress ="789 Edit Address";
		editCity ="Paris";
		editState ="Premier";
		editPin ="987654";
		editMobile ="0987456123";
		editEmail ="edittest" + Commons.randomEmail() +"@gmail.com";
  }
  
  @Test
  public void TC_01_NewCustomer() {
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr161493");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("harErAh");
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
	  
	  driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	  
	  driver.findElement(nameByTextbox).sendKeys(newName);
	  driver.findElement(dobByTextbox).sendKeys(newDob);
	  driver.findElement(addrByTextarea).sendKeys(newAddress);
	  driver.findElement(cityByTextbox).sendKeys(newCity);
	  driver.findElement(stateByTextbox).sendKeys(newState);
	  driver.findElement(pinByTextbox).sendKeys(newPin);
	  driver.findElement(mobileByTextbox).sendKeys(newMobile);
	  driver.findElement(emailByTextbox).sendKeys(newEmail);
	  driver.findElement(passwordByTextbox).sendKeys(password);
	  driver.findElement(submitByButton).click();
	  
	  /*Get customerID*/
	  customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	  System.out.println("Customer ID =" + customerID);
	  
	  /*Verify Input Data mathching vs Output Data*/
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), newName);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), newDob);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), newAddress);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), newCity);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), newState);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), newPin);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), newMobile);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), newEmail);
	  
	  System.out.println(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
	  
	}

  @Test
  public void TC_02_EditCustomer() {
	  
	  driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	  driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerID);
	  driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	  
	  /*Verify Customer name and Address*/
	  Assert.assertEquals(driver.findElement(nameByTextbox).getAttribute("value"), newName);
	  Assert.assertEquals(driver.findElement(addrByTextarea).getText(), newAddress);
	  
	  /*Edit Customer - Input Data*/
	  driver.findElement(addrByTextarea).clear();
	  driver.findElement(cityByTextbox).clear();
	  driver.findElement(stateByTextbox).clear();
	  driver.findElement(pinByTextbox).clear();
	  driver.findElement(mobileByTextbox).clear();
	  driver.findElement(emailByTextbox).clear();
	  driver.findElement(addrByTextarea).sendKeys(editAddress);
	  driver.findElement(cityByTextbox).sendKeys(editCity);
	  driver.findElement(stateByTextbox).sendKeys(editState);
	  driver.findElement(pinByTextbox).sendKeys(editPin);
	  driver.findElement(mobileByTextbox).sendKeys(editMobile);
	  driver.findElement(emailByTextbox).sendKeys(editEmail);
	  driver.findElement(submitByButton).click();
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editAddress);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editCity);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editState);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editPin);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editMobile);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail);
	  
	  System.out.println(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
	  System.out.println(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
	  
	}

  //Update

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}