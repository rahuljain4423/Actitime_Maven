package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Generic class for WebDriver Elements 
 * @author dell-
 *
 */
public class WebDriverCommonLib {
/**
 * Generic method for Implicit wait
 * @param driver
 */
public void WaitforPageLoadImplicit(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
/**
*Generic method for ExplicitWait
*@param driver
*@param title
*/
public void WaitForPageLoadExplicit(WebDriver driver,String title) {
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.titleIs(title));
}
/**
 * Generic method for custom wait 
 * @param element
 */
public void CustomWaitForElementDisplayed(WebElement element) {
	int i=0;
	while(i<100) {
		try {
			element.isDisplayed();
			break;
		}
	catch(Exception e) {
		i++;
	}
}
}
/**
 * Generic method for select the options from listbox using index
 * @param element
 * @param i
 */
public void SelectValue(WebElement element,int i) {
Select s=new Select(element);
	s.selectByIndex(i);
}
/** Generic method for select the options from listbox using visible text
 * @param element
 * @param text
 */
public void SelectValue(WebElement element,String text ) {
	Select s=new Select(element);
	s.selectByVisibleText(text);
	}
}
	
	
	



