package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {
WebDriver driver;
WebDriverWait wait;
WebElement username,password,loginbtn;
//constructor
public LoginPage(WebDriver driver,WebDriverWait wait)
{
	this.driver=driver;
	this.wait=wait;
	this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	this.username=this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.name("username"))
			);
	this.password=this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.name("password"))
			);
	
}
public void goTo(String url)
{
	
	this.driver.get(url);
}
public  String login(String user,String passw)
{
	
	
	
	this.username.clear();
	this.username.sendKeys(user);
	
	this.password.clear();
	this.password.sendKeys(passw);
	
	this.loginbtn=this.wait.until(
			ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))
			);
	this.loginbtn.click();
	
	String url=this.driver.getCurrentUrl();
	return url;
	
}
public void leaveClick()
{ 
	try {
		WebElement leavebtn=this.wait.until(
		ExpectedConditions.elementToBeClickable(By.linkText("Leave"))		
				);
		
		leavebtn.click();
		System.out.println("Leave is Clicked");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public  void  treaDown()
{
	this.driver.close();
}

}
