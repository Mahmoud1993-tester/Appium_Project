package appiumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class DragAndDrop extends BaseTest {

	@Test 
    public void LongPressGesture() throws MalformedURLException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	    
	    // Drag and Drop Code 
	    RemoteWebElement source = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("io.appium.android.apis:id/drag_dot_1")));
	    RemoteWebElement destination = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("io.appium.android.apis:id/drag_dot_2")));

	    driver.executeScript("gesture: dragAndDrop", Map.of("sourceId", source.getId(), "destinationId", destination.getId()));
        
	    // Assertion that Drag and Drop Done
	    String resultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	    Assert.assertEquals(resultText, "Dropped!");
       
	}
}
