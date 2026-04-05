package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions actions;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
	}
	
	public WebElement waitForVisibilityLocated(By element)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public WebElement waitForVisibility(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
