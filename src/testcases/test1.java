package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utility.Log;

public class test1 {
	WebDriver driver;
	
	@Test
	public void testa(){
		driver = new FirefoxDriver();
		Log.info("firefox driver is open");
		driver.get("https://www.baidu.com/");
		Log.info("baidu page is open");
		driver.quit();
	}

}
