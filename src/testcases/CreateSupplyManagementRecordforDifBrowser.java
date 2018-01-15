package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ExcelData;
import utility.Log;
import utility.utills;

public class CreateSupplyManagementRecordforDifBrowser {
	@BeforeTest
	public void beforeTest(){
		String browser = System.getProperty("pom.browser");
		String url = System.getProperty("pom.url");
	//	utills.openBrowser("http://172.166.100.103:85/","ie");
		utills.openBrowser(url, browser);
	}
	//WebDriver driver = new FirefoxDriver();
	@Test
	public  void CreateRecord() throws Exception {
		Log.info("-----------------------------Start----------------------------------");
		
		utills.inputValue(false,"valid_username", "username_editbox_locator");
		Log.info("username is input");
		utills.elementClick("login_button_locator");

		Log.info("-----------------------------End------------------------------------");
	}
	
	
	}
