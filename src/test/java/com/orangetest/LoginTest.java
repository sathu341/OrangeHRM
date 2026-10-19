package com.orangetest;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import pages.LoginPage;

import org.testng.Assert;
public class LoginTest {
WebDriver driver;
WebDriverWait wait;
LoginPage log;

@Test(priority=0)
public  void startTest()
{
	this.driver=new ChromeDriver();
	this.driver.manage().window().maximize();
	this.wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	this.log=new LoginPage(this.driver,this.wait);
	//this.log.goTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	
}
@Test(priority=1)
public void loginTester()
{
	  
	String currentUrl=this.log.login("Admin","admin123");
	Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
}
@Test(priority=2)
public void leaveAssignTest() throws InterruptedException
{
	//this.log.goTo("https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave");
	this.log.leaveClick();
	WebElement assignleave=this.wait.until(
			ExpectedConditions.elementToBeClickable(By.linkText("Assign Leave"))
			);
	assignleave.click();
	WebElement empname=this.wait.until(
	  ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Type for hints...']"))		
			);
	empname.clear();
	empname.sendKeys("John Doe");
	WebElement suggestion = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='option']")));
	   suggestion.click();
    //Leave Type dropdown
    By leaveType = By.xpath(
            "//label[text()='Leave Type']/../following-sibling::div" +
            "//div[contains(@class,'oxd-select-text')]");

    wait.until(ExpectedConditions.elementToBeClickable(leaveType)).click();

    // Select first available leave type
    By firstLeaveOption = By.xpath(
            "//div[@role='listbox']//div[@role='option'][1]");

    wait.until(ExpectedConditions.elementToBeClickable(
            firstLeaveOption)).click();

    // From Date
    By fromDate = By.xpath(
            "//label[text()='From Date']/../following-sibling::div//input");

    WebElement from = wait.until(
            ExpectedConditions.visibilityOfElementLocated(fromDate));

    from.sendKeys(Keys.CONTROL, "a");
    from.sendKeys("2026-10-05");
    from.sendKeys(Keys.TAB);

    // To Date
    By toDate = By.xpath(
            "//label[text()='To Date']/../following-sibling::div//input");

    WebElement to = wait.until(
            ExpectedConditions.visibilityOfElementLocated(toDate));

    to.sendKeys(Keys.CONTROL, "a");
    to.sendKeys("2026-10-06");
    to.sendKeys(Keys.TAB);

    // Click Assign
    By assignButton = By.xpath(
            "//button[normalize-space()='Assign']");

    wait.until(ExpectedConditions.elementToBeClickable(
            assignButton)).click();

    // Wait for the response
//    wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.cssSelector(".oxd-toast")));

    // Verify that a notification appeared
//    Assert.assertTrue(
//            driver.findElement(By.cssSelector(".oxd-toast")).isDisplayed(),
//            "Assign leave notification was not displayed");
	
}
@Test(priority=3)
public void closingTest()
{
	this.log.treaDown();
}

}
