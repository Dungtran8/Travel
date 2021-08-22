package com.onemount.dungtran8.common;

import static com.onemount.dungtran8.ui.HomeUI.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {
	protected WebDriver driver;

	public WebDriverTest() {
		String userDir = System.getProperty("user.dir");
		Path path = Paths.get(userDir).getParent();
		String chromedriverPath = path.toString().concat("\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void openApp(String url) throws InterruptedException {
		driver.get(url);
		TimeUnit.SECONDS.sleep(3);
		findElement(By.xpath(BUTTON_COOKIE_STOP)).click();
		TimeUnit.SECONDS.sleep(1);
	}

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public WebElement element(By by, String info) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(info);
		return element;
	}

	public WebElement findElements(int index, String xpath) {
		WebElement element = getDriver().findElements(By.xpath(xpath)).get(index);
		return element;
	}

	public String getText(String xpath, String nameElement) {
		By by = By.xpath(String.format(xpath, nameElement));
		return findElement(by).getText();
	}

	public void clickByJavaScript(String xpath) throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", findElement(By.xpath(xpath)));
		TimeUnit.SECONDS.sleep(2);
	}

}
