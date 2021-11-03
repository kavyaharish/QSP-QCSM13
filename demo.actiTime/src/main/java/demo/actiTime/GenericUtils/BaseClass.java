package demo.actiTime.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.internal.PropertyUtils;

public class BaseClass {
  WebDriver driver=null;
  PropertyUtils putils=new PropertyUtils();
  @BeforeSuite
  public void configBS() {
	  //database connection,extent report,loggers
  }
  @BeforeTest
  public void configBT() {
	  //parallel testing codes
  }
  @BeforeClass
  public void configBC() {
	  //open the browser
	  String browsername=putils.getPropertyData();
			  String url=putils.getPropertyDat();
			  if(browsername.equals("firefox")) {
				  System.setProperty("webdriver.chrome.driver","")
			  driver=new ChromeDriver();
			  }
			  else if
			  {
				  throw new SessionNotCreatedException("browser is not supported");
			  }
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get(url);
  }
  @BeforeMethod
  public void configBM() {
	  LoginPage loginpage=new LoginPage(driver);
    String username=putils.getPropertyData("");
    String password=putils.getPropertyData("");
    System.out.println(username);
    System.out.println(password);
    loginpage.login(username,password);
  }
  @AfterMethod
  public void configAM() {
	  HomePage homepage=new HomePage(driver);
	  homepage.logout();
  }
  @AfterClass
  public void configAC() {
	  //close the browser
	  driver.quit();
  }
  @AfterTest
  public void configAT() {
	  //close all the parallel connection
  }
  @AfterSuite
  public void configAS() {
	  //close database connection
  }
}
