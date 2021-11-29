package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String browsername) {

		switch (browsername) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("Invalid browsername");

		}

		// WebDriverManager.chromedriver().setup();
		//
		// WebDriver driver = new ChromeDriver();
		// return driver;

	}

	// maximize
	public static void maximize() {
		driver.manage().window().maximize();

	}

	// urllaunch
	public static void urlLaunch(String url) {
		driver.get(url);
	}

	// implicitwait
	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	// quit
	public static void quit() {
		driver.quit();

	}

	// FILL TEXT BOX (sendkeys)
	public static void fillTextBox(WebElement element, String data) {
		element.sendKeys(data);

	}

	public static void btnClick(WebElement e) {
		e.click();

	}

	// getcurrentURL
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// getTitle
	public static String getTitle() {
		return driver.getTitle();

	}

	// selectbyindex
	public static void selectByIndex(WebElement e, int index) {

		Select s = new Select(e);
		s.selectByIndex(index);

	}

	// getAttribute
	public static String getAttribute(WebElement e) {
		String text = e.getAttribute("value");
		return text;

	}

	// MoveToElement
	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	// DragandDrop
	public static void dragAndDrop(WebElement s, WebElement d) {
		Actions a = new Actions(driver);
		a.dragAndDrop(s, d).perform();

	}

	// findElement
	public static WebElement findElement(String locatorname, String value) {
		WebElement e = null;
		if (locatorname.equals("id")) {
			e = driver.findElement(By.id(value));
		} else if (locatorname.equals("name")) {
			e = driver.findElement(By.name(value));
		} else if (locatorname.equals("xpath")) {
			e = driver.findElement(By.xpath(value));
		}
		return e;

	}

}
