package com.onemount.dungtran8.features;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import com.onemount.dungtran8.models.User;
import static com.onemount.dungtran8.ui.HomeUI.*;
import static com.onemount.dungtran8.ui.BookingFlightUI.*;

import java.util.concurrent.TimeUnit;

public class BookingFlightTest extends Login {

	private void searchFlights() throws InterruptedException {
		findElement(By.xpath(BUTTON_FLIGHTS)).click();
		element(By.xpath(FLYING_FROM_INPUT), INFOR_FLYING_FROM);
		element(By.xpath(DESTINATION_INPUT), INFOR_DESTINATION);
		element(By.xpath(DATE_INPUT), INFO_DATE);
		TimeUnit.SECONDS.sleep(1);
		findElement(By.xpath(BUTTON_FLIGHTS_SEARCH)).click();
	}

	private void bookAFlight() throws InterruptedException {
		findElements(0, RESULT_FLIGHTS).click();
		TimeUnit.SECONDS.sleep(3);
		clickByJavaScript(BANK_TRANSFER);
		clickByJavaScript(CONFIRM_BOOKING);
	}

	@Before
	public void openDriver() throws InterruptedException {
		openApp(URL_HOME);
	}

	@Test
	public void bookAFlightSuccess() throws InterruptedException {
		findElement(By.xpath(BUTTON_LOGIN)).click();
		TimeUnit.SECONDS.sleep(3);
		login(new User());
		TimeUnit.SECONDS.sleep(2);
		searchFlights();
		bookAFlight();
		TimeUnit.SECONDS.sleep(3);

	}

	@After
	public void closeDriver() throws InterruptedException {
		getDriver().quit();
	}
}
