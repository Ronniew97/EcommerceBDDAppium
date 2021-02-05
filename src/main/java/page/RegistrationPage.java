package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.BasePage;

public class RegistrationPage extends BasePage{

	AndroidDriver<AndroidElement> driver;
	
	public RegistrationPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='General Store']") AndroidElement GENERAL_STORE_HEADER;
	@AndroidFindBy(xpath = "//android.widget.Spinner[@index='1']") AndroidElement COUNTRY_DROPDOWN;
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']") AndroidElement NAME_TEXTBOX;
	@AndroidFindBy(uiAutomator = "text(\"Male\")") AndroidElement MALE_RADIO_BUTTON;
	@AndroidFindBy(uiAutomator = "text(\"Female\")") AndroidElement FEMALE_RADIO_BUTTON;
	@AndroidFindBy(xpath = "//android.widget.Button[@index='6']") AndroidElement LETS_SHOP_BUTTON;
	@AndroidFindBy(uiAutomator = "text(\"Products\")") AndroidElement PRODUCTS_HEADER;
	
	public void enterCountry(String country) throws InterruptedException {
		explicitWait(driver, 4, GENERAL_STORE_HEADER);
		COUNTRY_DROPDOWN.click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())."
				+ "scrollIntoView(new UiSelector().text(\""+country+"\"))")).click();
	}
	
	public void enterName(String name) {
		NAME_TEXTBOX.sendKeys(name);
	}
	
	public void clickMaleRadioButton() {
		MALE_RADIO_BUTTON.click();
	}
	
	public void clickFemaleRadioButton() {
		FEMALE_RADIO_BUTTON.click();
	}
	
	public void clickLetsShopButton() {
		LETS_SHOP_BUTTON.click();
	}
	
	public void takesScreenShotAtTheEndOfTest() throws IOException {
		explicitWait(driver,3, PRODUCTS_HEADER);
		TakesScreenshot ts = (TakesScreenshot)(driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshots//registrationtest"+System.currentTimeMillis()+".png"));
	}
}
