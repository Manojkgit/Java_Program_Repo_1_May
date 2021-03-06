package naveenProgram;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLink {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D://Browser_exe//ChromeDriver.exe");
        WebDriver dr = new ChromeDriver();
        
		dr.get("https://www.facebook.com/");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.findElement(By.name("email")).sendKeys("manojk2829@gmail.com");
        dr.findElement(By.name("pass")).sendKeys("maurya@282920");
        dr.findElement(By.name("pass")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> link = dr.findElements(By.tagName("a"));
        link.addAll(dr.findElements(By.tagName("img")));
        System.out.println("Total size of Link -- > " + link.size());
        
        
        List<WebElement> activeLink = new ArrayList<WebElement>();
        
        		for(int i=0;i<link.size();i++){
        			System.out.println(link.get(i).getAttribute("href"));
        			if(link.get(i).getAttribute("href")!=null && (! link.get(i).getAttribute("href").contains("javascript"))){
                		activeLink.add(link.get(i));
                	}
                }
        		System.out.println("Active link ---- > " + link.size());
   
        		 for(int j=0;j<activeLink.size();j++){
        			 HttpURLConnection con=(HttpURLConnection) new URL(activeLink.get(j).getAttribute("href")).openConnection();
        			 con.connect();
        			 String ResponseMessage=con.getResponseMessage();
        			 con.disconnect();
        			 System.out.println(activeLink.get(j).getAttribute("href") + " ----  Response message --- >  " + ResponseMessage);
        		 }
	
	}

}
