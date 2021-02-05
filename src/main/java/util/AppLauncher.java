package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppLauncher extends BasePage {

	public static AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> startApp() throws MalformedURLException{
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		File file = new File("app\\General-Store.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "GalaxyRonnie");
		capabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		driver = new AndroidDriver<AndroidElement>(url,capabilities);
		return driver;
	}
}
