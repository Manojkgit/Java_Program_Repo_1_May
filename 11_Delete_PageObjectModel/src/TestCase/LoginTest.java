package TestCase;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Excel.Data_TestCase;
import Pages.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {
   String TestCaseName="LoginTest";
   public static final Logger l=Logger.getLogger(LoginTest.class.getName());
   public LoginPage login;
   public String TestCase_sheetName="data";
   
   @Test(dataProvider="getData")
   public void doLoginTest(Hashtable<String,String> tb){
	   test=ext.startTest("Login Test");
	   if(tb.get("Runmode").equals("N")){
		   test.log(LogStatus.SKIP,"Because Runmode is N");
		   throw new SkipException("Because Runmode is N");
   }
	   openBro(tb.get("Browser"));
	   l.info("LoginTest Open Browser Executed...");
	   navigate("http://facebook.com");
	   System.out.println(dr.getTitle());
       login=new LoginPage(dr,test);
       //login.doLogin("manojk2829@gmail.com", "maurya@282920");
       login.doLogin(tb.get("userName"), tb.get("Password"));
       l.info("LoginTest Done...");
   }
   
   @DataProvider
   public Object[][] getData(){
	   return Data_TestCase.get_FB_testCase(xls,TestCase_sheetName, TestCaseName);
   }
   
   @AfterTest
   public void tearDown(){
	   closeBrowser(5);
	   ext.endTest(test);
       ext.flush();
   }
}
