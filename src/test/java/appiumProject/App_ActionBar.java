package appiumProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;

public class App_ActionBar extends BaseTest {

	@Test 
    public void ActionBarInput() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Activity")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Soft Input Modes\"));"));
		driver.findElement(AppiumBy.accessibilityId("Soft Input Modes")).click();
		driver.findElement(By.id("io.appium.android.apis:id/saved")).sendKeys("Saber Here!");
		
		
        
       
	}
}
