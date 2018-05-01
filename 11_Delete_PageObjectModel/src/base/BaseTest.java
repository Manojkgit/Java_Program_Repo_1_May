package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extent.Extent_Delete;
import extent.Xls_Reader;

public class BaseTest {
	public WebDriver dr;
	
	public ExtentReports ext=Extent_Delete.getReport();
	public ExtentTest test;
	public Xls_Reader xls;
	public static final Logger l=Logger.getLogger(BaseTest.class.getName());
	public BaseTest(){
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//property//log4j.properties");
		xls=new Xls_Reader("C:\\Users\\ti01045\\Desktop\\TestData.xlsx");
	}
	public BaseTest(WebDriver dr,ExtentTest test){
		this.dr=dr;
		this.test=test;
		
	}
	
	
	public void openBro(String b){
		if(b.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://Browser_exe//chromedriver.exe");
			dr=new ChromeDriver();
			test.log(LogStatus.INFO,"Browser Open Successfully..." + b);
			l.info("Start Browser ---- > " + b);
		}else{
			dr=new FirefoxDriver();
			test.log(LogStatus.INFO,"Browser Open Successfully..." + b);
			l.info("Start Browser ---- > " + b);
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().deleteAllCookies();
		l.info("Browser Maximiz ---- > " + b);
		test.log(LogStatus.PASS,"Browser maximize Successfully..." + b);
	}

	public void wait(int sec){
		try{
			Thread.sleep(sec*1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void closeBrowser(int sec){
		try{
			Thread.sleep(sec*1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		test.log(LogStatus.PASS,"Test Pass Successfully...");
		dr.quit();
		l.info("===== Browser Close Success ===== " + toString());
	}
	
	public void navigate(String url){
		dr.navigate().to(url);
	}
	
	public void screen(){
		Date d=new Date();
		String FN=d.toString().replace(" ", "_").replace(":", " ")+".jpg";
		
			File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			try{
			   	 FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//report//"+FN));
			}catch(Exception e){
			System.out.println(e.getMessage());
		}
			test.log(LogStatus.INFO,"Take Screenshot -- >   " + test.addScreenCapture(System.getProperty("user.dir")+"//report//"+FN));
			l.info(" === Screen Shot capture === ");
	}
}
