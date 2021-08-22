package com.onemount.dungtran8.features;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import com.onemount.dungtran8.common.WebDriverTest;
import com.onemount.dungtran8.models.Member;
import static com.onemount.dungtran8.ui.SignUpUI.*;
import static com.onemount.dungtran8.ui.HomeUI.*;

public class SignUpTest extends WebDriverTest {
	private void register(Member member) throws InterruptedException {
		findElement(By.xpath(BUTTON_SIGNUP)).click();
		TimeUnit.SECONDS.sleep(3);
		element(By.xpath(FIRSTNAME), member.getFirstName());
		element(By.xpath(LASTNAME), member.getLastName());
		element(By.xpath(PHONE), member.getPhone());
		element(By.xpath(EMAIL), member.getEmail());
		element(By.xpath(PASSWORD), member.getPassword());
		clickByJavaScript(SUBMIT_SIGNUP);
	}

	@Before
	public void openDriver() throws InterruptedException {
		openApp(URL_HOME);
	}

	@Test
	public void registerSuccess() throws InterruptedException {
		register(new Member());
	}

	@After
	public void closeDriver() throws InterruptedException {
		getDriver().quit();
	}
}
