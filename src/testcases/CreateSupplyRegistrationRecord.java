package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateSupplyRegistrationRecord {
	@Test
	public static void CreateRecord() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://172.166.100.103:85/");
		//登录78OA
		driver.findElement(By.xpath(".//*[@id='account']/div/input")).sendKeys("Admin");
		driver.findElement(By.xpath(".//*[@id='password']/div/input")).sendKeys("");
		driver.findElement(By.id("submit")).click();
		
		// click 行政办公标签
		driver.findElement(By.xpath(".//*[@id='r1']/ul/li[5]/table/tbody/tr/td[2]")).click();
		// click 办公用品菜单
		driver.findElement(By.xpath(".//*[@id='m09']/ul/li[1]/div[1]")).click();
		// click 办公用品登记选项
		driver.findElement(By.xpath(".//*[@id='m09']/ul/li[1]/div[2]/ul/li[3]/span")).click();
		// switch to frame with id context
		driver.switchTo().frame("context");
		// click 新增登记 button
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/span[1]")).click();
		// click 采购入库 radio button
		driver.findElement(By.id("_3_")).click();
		// select 拍纸本 from drop down list for 办公用品
		WebElement element = driver.findElement(By.id("_8_"));
		Select select = new Select(element);
		select.selectByValue("26");
		// 清楚数据
		driver.findElement(By.xpath(".//*[@id='_10_']/div/div[3]/div[1]/div[2]/div/div/input")).clear();
		// input 5 for 数量
		driver.findElement(By.xpath(".//*[@id='_10_']/div/div[3]/div[1]/div[2]/div/div/input")).sendKeys("5");
		// 清楚数据
		driver.findElement(By.xpath(".//*[@id='price']/div[1]/div[2]/div/div/input")).clear();
		// input 10 for 单价
		driver.findElement(By.xpath(".//*[@id='price']/div[1]/div[2]/div/div/input")).sendKeys("10");
		// input comments for 登记备注
		driver.findElement(By.xpath(".//*[@id='_10_']/div/div[6]/div[1]/div[2]/div/div/textarea")).sendKeys("采购纸质用品");
		// click 保存 button
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/span[1]")).click();	
		// verify 登记数量
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='_15_']/tr[1]/td[3]/span[3]")).getText(), "登记数量：5（本）");
		// verify 价格
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='_15_']/tr[1]/td[3]/span[4]")).getText(), "采购价格：10.00（元）");
		// switch to default window
		driver.switchTo().defaultContent();
		// logout 
		driver.findElement(By.xpath(".//*[@id='r3']/span[4]"));
		//关闭浏览器
		driver.quit();
	}

}
