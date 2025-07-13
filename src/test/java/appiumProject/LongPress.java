package appiumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;
import java.util.Map;

public class LongPress extends BaseTest {

	@Test 
    public void LongPressGesture() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		// Long Press ( Gesture )
		RemoteWebElement longPress = (RemoteWebElement) driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        driver.executeScript("gesture: longPress", Map.of("elementId", longPress.getId(), "pressure", 0.5, "duration", 800));

        // Check the dropDown menu appearing
        String dropDownTitle = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(dropDownTitle, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());        
        Thread.sleep(2000);

        
       
    }
}
