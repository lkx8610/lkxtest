package testcases;



import org.apache.http.util.Asserts;
import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import utility.Log;



public class Car2share_coupon {
	WebDriver driver;
	
	@Test(dataProvider = "dp")
	public void acoupon(Integer n, String s) throws Exception {
		System.out.println("优惠券密码---》"+s);
		driver.findElement(By.xpath(".//*[@id='code']")).clear();
		driver.findElement(By.xpath(".//*[@id='code']")).sendKeys(s);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[3]/div[1]/input[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='alertOkBtn']")).click();
		Thread.sleep(3000);
	   
	}
		
	@Test
	public void coupon() throws Exception {
//		System.out.println("优惠券密码---》"+s);
//		driver.findElement(By.xpath(".//*[@id='code']")).clear();
//		driver.findElement(By.xpath(".//*[@id='code']")).sendKeys(s);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[3]/div[1]/input[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath(".//*[@id='alertOkBtn']")).click();
//		Thread.sleep(3000);
		 //返回首页
		driver.findElement(
				By.xpath(".//*[@id='wrapper']/div/div[1]/a[2]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath(".//*[@id='wrapper']/div/div[2]/div[1]/div[4]/div/div[1]/div/div[2]/ul/li[1]/a/img"))
				.click();

		Thread.sleep(3000);
		//选择城市
				driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/a[2]")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(".//*[@id='wrapper']/div/ul/li[1]/a")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.id("startSite_a")).click();
				Thread.sleep(3000);
				//WebElement source=driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[1]/div[1]/div"));
			driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[1]/div[3]/div")).click();
//				driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[1]/div[3]/div")).;
			//	Actions action=new Actions(driver);
//				action.dragAndDrop(source, target).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div[2]/div")).click();
			
				Thread.sleep(3000);
		//下一步		
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
		Thread.sleep(4000);
		//立即取车
		driver.findElement(By.id("getCarBtn")).click();
		Thread.sleep(5000);
		//开启车门
		driver.findElement(By.className("btn1")).click();
		Thread.sleep(15000);
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
         String name=null;
         String coupon=null;
		driver = new FirefoxDriver();
		Log.info("test beforeMethod ");
		//driver.get("http://192.168.144.128:8106");
		driver.get("http://192.168.144.128:8106/welcome/index.jhtml");
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
		Thread.sleep(4000);
		driver.findElement(By.id("open-button")).click();
		Thread.sleep(3000);
		
		name=driver.findElement(By.xpath(".//*[@id='memberDetail_a']/div[2]/span")).getText();
		Assert.assertEquals("李凯迅", name);
		System.out.println("name--->"+name);
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement webelement=driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/nav/div[2]/a[1]"));
		//action.contextClick(webelement).build().perform();
		action.click(webelement).build().perform();
		Thread.sleep(3000);
		coupon=driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/h4")).getText();
		Assert.assertEquals("优惠券", coupon);
		System.out.println("coupon--->"+coupon);
		Thread.sleep(3000);
		
		
	}
	 @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a232423afdf3a" },
	      new Object[] { 2, "b213214213213" },
	    };
	  }
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod--->");
		driver.quit();
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
