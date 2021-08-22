package com.onemount.dungtran8.features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.onemount.dungtran8.common.WebDriverTest;
import com.onemount.dungtran8.models.User;
import static com.onemount.dungtran8.ui.HomeUI.*;
import static com.onemount.dungtran8.ui.LoginUI.*;

public class Login extends WebDriverTest {

	public void login(User user) throws InterruptedException {
		findElement(By.xpath(BUTTON_LOGIN)).click();
		TimeUnit.SECONDS.sleep(3);
		element(By.xpath(EMAIL_LOGIN), user.getUsername());
		element(By.xpath(PWD_LOGIN), user.getPassword());
		findElement(By.xpath(SUBMIT_LOGIN)).click();
		TimeUnit.SECONDS.sleep(3);
	}

}
