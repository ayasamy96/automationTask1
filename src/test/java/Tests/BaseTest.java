package Tests;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import automationTask1.HomePage;

public class BaseTest {

	public static WebDriver driver;
	public static HomePage homePageObj;
	public static Properties prop;

	public  BaseTest() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\data.properties");
		prop.load(fis);
	}


	@BeforeClass
	public void SetUp () {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.navigate().to(prop.getProperty("AmazonURL"));
		homePageObj = new HomePage(driver);
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
