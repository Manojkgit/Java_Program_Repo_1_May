package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import base.BaseTest;

public class LoginPage extends BaseTest{
	public static final Logger l=Logger.getLogger(LoginPage.class.getName());	
	@FindBy(id="email")
	WebElement emailId;
	@FindBy(id="pass")
	WebElement userPass;
	
   public LoginPage(WebDriver dr,ExtentTest test){
	   super(dr,test);
	   PageFactory.initElements(dr,this);
   }
	
   public void doLogin(String user,String pass){
	   emailId.sendKeys(user);
	   test.log(LogStatus.INFO,"Email Id entered successfully....");
	   l.info("LoginPage LoginPage .....");
	   userPass.sendKeys(pass);
	   test.log(LogStatus.INFO,"Password entered successfully....");
	   userPass.sendKeys(Keys.ENTER);
	   screen();
	   l.info("========= Screen shot Done LoginPage =======");
   }
}
