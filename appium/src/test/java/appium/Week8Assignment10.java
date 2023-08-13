package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Week8Assignment10 {
	
	@Test
	
	public void findOrientation() throws MalformedURLException
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
		
		
		//Finding orientations
		ScreenOrientation orientation = driver.getOrientation();
		
		System.out.println("Orientation of this device is:  "+orientation);

		//Quitting the driver
		driver.quit();
		
	}

}
