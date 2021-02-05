package steps;

import java.io.IOException;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.RegistrationPage;
import util.AppLauncher;

public class RegistrationSteps {

	AndroidDriver<AndroidElement> driver;
	RegistrationPage registration;
	
	@Given("user is on the general store app registration page")
	public void user_is_on_the_general_store_app_registration_page() throws MalformedURLException {
	    driver = AppLauncher.startApp();
	}

	@When("user enters their {string}, {string}, and gender")
	public void user_enters_their_and_gender(String country, String name) throws InterruptedException {
		registration = new RegistrationPage(driver);
		registration.enterCountry(country);
		registration.enterName(name);
		registration.clickMaleRadioButton();
	}
	
	
	@When("user clicks the let's shop button")
	public void user_clicks_the_let_s_shop_button() {
	    registration.clickLetsShopButton();
	}
	@Then("user should see the products page")
	public void user_should_see_the_products_page() throws IOException {
	    registration.takesScreenShotAtTheEndOfTest();
	}

}
