package appium;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Week8Assignment7 {
	
@Test
	
	public void contextChange() throws IOException
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
		
		//Tap on Preference
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		// Tapping on Preference Dependencies
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		//Check/Tap on Wifi option
		driver.findElement(By.id("android:id/checkbox")).click();
		
		String wifiSettingXpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView";

		// Navigating to WiFi setting menus
		driver.findElement(By.xpath(wifiSettingXpath)).click();
		
		
		//Storing all context in 'contexts'
		Set<String> contexts = driver.getContextHandles();
		
		//printing all the contexts availables
		System.out.println("Available contexts are: "+contexts);
		
		//Checking if there is a context named 'WEBVIEW', if found switching to WEBVIEW context
		for (String context : contexts) {
		    if (context.contains("WEBVIEW")) {
		        driver.context(context);
		        break;
		    }
		}
		
		//Quitting the driver
		driver.quit();
		
	}

}
