package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import utility.Log;


public class Car2share_ReadExcelData {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	
		driver = new FirefoxDriver();
		Log.info("test beforeMethod ");
		//driver.get("http://192.168.144.128:8106");
		driver.get("http://192.168.144.128:8106/login.jsp");
		//driver.get("http://car2s.afocus.net");
		Log.info("test car2share ");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);

		driver.findElement(
				By.xpath(".//*[@id='uniqueContent']/div[2]/div[1]/a"))
				.click();

		Thread.sleep(9000);
		scrollToElement(By.id("submit"));
			Thread.sleep(3000);
		driver.findElement(
				By.id("submit"))
				.click();
		Thread.sleep(3000);
		
		
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod--->");
		//driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  /**
   * @author likaixun
   * @param element
   * 如果控件没有全部被显示，显示指定控件
   */
  public void scrollToElement(By by) {
      WebElement e =driver.findElement(by);
      Log.info("scroll view element");
      JavascriptExecutor js = (JavascriptExecutor) driver;
      // roll down and keep the element to the center of browser
      js.executeScript("arguments[0].scrollIntoView(true);", e);
  }
}
