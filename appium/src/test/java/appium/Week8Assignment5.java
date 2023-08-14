package appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Week8Assignment5 {
	
@Test
	
	public void takeScreenshot() throws IOException
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
		
		//Tapping the element preference
		driver.findElement(By.xpath(accessibilityXpath)).click();
		
		//Taking screenshot of the page
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("screenshot.png"));

		//Quitting the driver
		driver.quit();
		
	}
}
