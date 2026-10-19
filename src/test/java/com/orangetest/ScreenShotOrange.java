package com.orangetest;
 import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver; 
 import org.testng.annotations.*; 
 import org.testng.asserts.SoftAssert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class ScreenShotOrange {
	WebDriver driver;
@BeforeMethod
public void start()
{
	this.driver=new ChromeDriver();
	this.driver.manage().window().maximize();
	
}
@Test
public  void loadPage() throws Exception
{
	this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	SoftAssert sft=new SoftAssert();
	this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	sft.assertEquals(this.driver.getTitle(),"OrangeHRM","status is fail");
	sft.assertAll();
	String filename="target/screenshot/orangepage1.png";
	Thread.sleep(2000);
	takeScreenShot(filename);
	
}
private  void takeScreenShot(String filename) {
	try {
		Path destination =Path.of(filename);
		Files.createDirectories(destination.getParent());
		File source=((TakesScreenshot) this.driver)
				.getScreenshotAs(OutputType.FILE);
		Files.copy(source.toPath(),destination,StandardCopyOption.REPLACE_EXISTING);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
@AfterMethod
public  void  treadown()
{
	if(this.driver!=null)
	{
		this.driver.quit();
	}
	
}
}
