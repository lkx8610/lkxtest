package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class utills {
public static WebDriver driver;	
	
/**
 * This method implements how to switch windows	
 * @author xjjiang
 * @param cwindow
 */
public static void switchWindows(String cwindow){
		
		Set<String> Ahandles = driver.getWindowHandles();
		Iterator<String> Ait = Ahandles.iterator();
		while(Ait.hasNext()){
			String crWindowString = Ait.next();
			System.out.println("next = " + crWindowString);
			if(cwindow==crWindowString){
				continue;
			}
			driver.switchTo().window(crWindowString); 
		}
	}
/**
 * This method implemenets how to get the specified test data based on the column name(key).
 * @param key
 * @return
 */
public static String getTestData(String key){
	ExcelData.setPath(Contants.path+Contants.filename, Contants.sheetname);
	int rowNum = ExcelData.getRowContains(key, Contants.keycolumn);
	String cellValue = ExcelData.getCellData(rowNum, Contants.column);
	return cellValue;
	
}

public static String getCSVTestData(String key){
	String vlaue = null;
	for(String[] row:ExcelData.getTestDataFromObjectsFile()){
		if(row[0].equalsIgnoreCase(key)){
			vlaue = row[1];

		}
	}
	return vlaue;
}
/**
 * This method implements how to get a By type locator.
 * @param key
 * @return
 */
public static By getLocator(String key){
	By locat = null;
	String locatorType = null;
	String locator = null;
	for(String[] row:ExcelData.getLocatorsFromObjectsFile()){
		if(row[0].equalsIgnoreCase(key)){
			locatorType = row[1];
			locator=row[2];
			break;
		}
	}
	System.out.println(locatorType +" ~~ "+ locator);
	switch(locatorType){
	case "id":
		locat =By.id(locator);
		break;
	case "name":
		locat = By.name(locator);
		break;
	case "xpath":
	    locat = By.xpath(locator);
	    break;
	case "linkText":
		locat = By.linkText(locator);
		break;
	default:
		Log.warn("Can not find the locator type. locator type is: "+locatorType);
		break;
	}
	
	return locat;
}
/**
 * This method implements how to get an element based on the key value.
 * @param key
 * @return
 */
public static WebElement getElement(String key){
	
	WebElement element ;
	
	By locator =getLocator(key);
	element = driver.findElement(locator);
	if(!element.isDisplayed()){
		Log.error("Can not find the element: " +element);
	}
	return element;
	
	
}
/**
 * This method implements that input test data based on two parameters.
 * @param value
 * @param locator
 */
public static void inputValue(String value,String locator){
	String inputData ="";
	inputData = utills.getTestData(value) ;
	if(inputData!=null){
			getElement(locator).clear();
			getElement(locator).sendKeys(inputData);
			Log.info("test data: "+inputData + " is input.");
	}
}
/**
 * This method implements that input test data for a field and 
 * determine whether the test data need to be got from testdata 
 * file through the flag.
 * @param flag
 * @param value
 * @param locator
 */
public static void inputValue(boolean flag,String value,String locator){
	String inputData ="";
	if(flag){
		inputData = value;
		if(inputData!=null){
			getElement(locator).clear();
			getElement(locator).sendKeys(inputData);
			Log.info("test data: "+inputData + " is input.");
		}
	}else{
	
		inputData = utills.getTestData(value) ;
		if(inputData!=null){
			getElement(locator).clear();
			getElement(locator).sendKeys(inputData);
			Log.info("test data: "+inputData + " is input.");
		 }
	}
}
public static void openBrowser(String url,String browser){
	switch(browser){
	case "firefox":
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 FirefoxProfile profile=new FirefoxProfile();
		  //显示浏览器的混合活动内容，http和https？？
		  profile.setPreference("security.mixed.content.block_active_content", false);
		  profile.setPreference("security.mixed.content.block_display_content", true);
		  profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver();
		
		break;
	case "ie":
		DesiredCapabilities  ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.ie.driver", Contants.path+Contants.ieDriverServer);
		driver = new InternetExplorerDriver();
		break;
	default:
		Log.warn("Can not find the browser type. and the browser type is: "+browser);
		break;
	}
	Log.info("Browser type is "+browser);
	driver.get(url);
	Log.info(url+" is open");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

public static void waitforJSLoad()throws Exception {
	
	(new WebDriverWait(driver, 80)).until(new ExpectedCondition<Boolean>() {
		  @Override 
    	  public Boolean apply(WebDriver dr) {
			  try {				
				  	Boolean value = ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete");
				  	 return value;
				 } catch (Exception e) {
					 return Boolean.FALSE;
					}
    	   }
    }); 
}
public static void elementClick(String locator) throws Exception{
	WebElement element ;
	element = getElement(locator);
	element.click();
	Log.info(element+" is clicked.");
	waitforJSLoad();	
}

public static void switchFrame(String id){
	driver.switchTo().frame(id);
	
}

public static void selectValue(String value,String locator,String flag){
	WebElement element = getElement(locator);
	Select select = new Select(element);
	String dataValue =getTestData(value);
	if(flag.equalsIgnoreCase("byvalue")){
		
		select.selectByValue(dataValue);
	}else{
		select.selectByVisibleText(dataValue);
	}
	Log.info(dataValue +" is selected.");
}

public static void assertText(String value,String locator){
	String actualValue = "";
	String expectedValue = "";
	actualValue=getElement(locator).getText();
	expectedValue = getTestData(value);
	
	Assert.assertEquals(actualValue,expectedValue,"Assert is Fail with Actual data is ["+actualValue+"] And Expected Result is ["+expectedValue+"].");
	
	
}
public static void assertText(String value,String locator,String sTestCaseName){
	String actualValue = "";
	String expectedValue = "";
	try{
		
	actualValue=getElement(locator).getText();
	expectedValue = getTestData(value);
	
	Assert.assertEquals(actualValue,expectedValue,"Assert is Fail with Actual data is ["+actualValue+"] And Expected Result is ["+expectedValue+"].");
	}catch(AssertionError e){
		Log.error(e.getMessage());
		takeScreenshot(sTestCaseName);
		Assert.assertFalse(true);
	}
}
public static void assertRadioButton(String locator,String sTestCaseName){
	boolean actualValue = false;
	WebElement element = getElement(locator);
	try{
	actualValue =getElement(locator).isSelected();
	
	Assert.assertTrue(actualValue, "Assert is Fail with "+ element+" is not checked.");
	
	}catch(AssertionError e){
		Log.error(e.getMessage());
		takeScreenshot(sTestCaseName);
		Assert.assertFalse(true);
	}
}

public static void takeScreenshot(String sTestCaseName) {

	DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh_mm_ss");
	Date date = new Date();
	
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(file, new File(Contants.snapshotPath
						+ sTestCaseName +"/"+sTestCaseName+ " # " + dateformat.format(date)
						+ ".png"));


	} catch (Exception e) {
		Log.error("Package Utility|| class Utills|| Method takeScreenshot || issue in Taking Screenshot");
	}

}
public static void takeScreenshotCheckPoint(String testCaseName, boolean flag, String checkPointNum) throws Exception {
	Log.info("[takeScreenshotCheckPoint]: " + checkPointNum);
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String picName = "";

	try {
		if (flag) {
			picName = Contants.snapshotPath + testCaseName + "/" + testCaseName + "_" + checkPointNum + "_pass.png";
			FileUtils.copyFile(file, new File(picName));
		} else {
			picName = Contants.snapshotPath + testCaseName + "/" + testCaseName + "_" + checkPointNum + "_fail.png";
			FileUtils.copyFile(file, new File(picName));
		}

	} catch (Exception e) {
		Log.error("[takeScreenshotCheckPoint]: Package Utility|| class Utills|| Method takeScreenshot || issue in Taking Screenshot");
		throw e;
	}

}
}
