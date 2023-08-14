package appium;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Week8Assignment4 {
	
@Test
	
	public void explicitWait() throws IOException
	{
		//Defining appium server URL
		String urlOfAppiumServer = "http://127.0.0.1:4723/";
		URL appiumServerUrl = new URL(urlOfAppiumServer);
		UiAutomator2Options options=new UiAutomator2Options();
		//Setting the device name
		options.setDeviceName("Pixel2"); 
		//Setting app location
		options.setApp("/Users/apple/eclipse-workspace/MDITTrainings/MDIT2023/appium/src/test/resources/ApiDemos-debug.apk");
		
		//Launching the app
		AndroidDriver driver=new AndroidDriver(appiumServerUrl,options);
		//Implicitly waiting for 10 seconds for tester to see the app launch
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String accessibilityXpath="//android.widget.TextView[@content-desc=\"Accessibility\"]";
		
		//Tapping the element accessibility once the element is visible
		//Explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(accessibilityXpath)))).click();


		//Quitting the driver
		driver.quit();
		
	}

}
