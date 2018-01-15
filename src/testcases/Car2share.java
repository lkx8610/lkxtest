package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Log;



public class Car2share {
	WebDriver driver;

	@Test
	public void f() throws Exception {
	
		Thread.sleep(3000);
		driver.findElement(
				By.xpath(".//*[@id='wrapper']/div/div[2]/div[1]/div[4]/div/div[1]/div/div[2]/ul/li[1]/a/img"))
				.click();
      
		Thread.sleep(3000);
		driver.findElement(By.id("chooseCar")).click();
		Thread.sleep(3000);
		//立即下单
		driver.findElement(By.id("success")).click();
		Thread.sleep(3000);
//		String currentWindow = driver.getWindowHandle();
//		System.out.println("current = " + currentWindow);
//
//		utills.driver=driver;
//		utills.switchWindows(currentWindow);
		//约车成功对话框确认按钮
		driver.findElement(By.id("alertOkBtn")).click();
		Thread.sleep(3000);
		//立即取车
		driver.findElement(By.id("getCarBtn")).click();
		Thread.sleep(3000);
		//开启车门
		driver.findElement(By.className("btn1")).click();
		Thread.sleep(6000);
		//选择框
		//driver.findElement(By.className("checkbox inline-block")).click();
		//立即还车
		driver.findElement(By.xpath(".//*[@id='uniqueContent']/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='uniqueContent']/ul/li[2]/div/div")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//*[@id='uniqueContent']/ul/li[3]/div/div")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//*[@id='uniqueContent']/ul/li[4]/div/div")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//*[@id='uniqueContent']/ul/li[5]/div/div")).click();
		Thread.sleep(3000);	
		//还车
		driver.findElement(By.xpath(".//*[@id='returnBtn']")).click();
		Thread.sleep(3000);	
		//确定
        driver.findElement(By.id("alertOkBtn")).click();
        Thread.sleep(3000);	
		//去支付
        driver.findElement(By.xpath(".//*[@id='wrapper']/div[1]/a")).click();
        Thread.sleep(3000);	
        driver.findElement(By.id("submit_a")).click();
        Thread.sleep(3000);	
        driver.findElement(By.xpath(".//*[@id='wrapper']/div/a")).click();
        Thread.sleep(3000);	
  
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {

		driver = new FirefoxDriver();
		Log.info("test beforeMethod ");
		driver.get("http://192.168.144.128:8106");
		//driver.get("http://car2s.afocus.net");
		Log.info("test car2share ");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);

		driver.findElement(
				By.xpath(".//*[@id='wrapper']/div/div[2]/div[1]/div[3]/div/div/span/a"))
				.click();

		Thread.sleep(3000);
		driver.findElement(By.id("loginId")).sendKeys("18601245439");
		Thread.sleep(3000);
		driver.findElement(By.id("sendPcode")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("pcode")).sendKeys("000003");
		Thread.sleep(3000);
		driver.findElement(By.id("login")).click();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}

}
