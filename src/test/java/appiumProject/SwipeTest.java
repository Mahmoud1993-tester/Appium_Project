package appiumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class SwipeTest extends BaseTest {

	@Test 
    public void SwipeImages() throws MalformedURLException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		// Swipe Elements Code 
		
		RemoteWebElement firstImage = (RemoteWebElement) wait.until(
			    ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView)[1]")));
		
        driver.executeScript("gesture: swipe", Map.of("elementId", firstImage.getId(), 
        "percentage", 50, 
        "direction", "left"));
        
       
	}
}
