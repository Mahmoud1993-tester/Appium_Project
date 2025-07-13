package appiumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;
import java.time.Duration;

public class ScrollToElement extends BaseTest {

	@Test 
    public void LongPressGesture() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		driver.findElement(AppiumBy.accessibilityId("WebView")).click();
		
		// Wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Focus and Assertions 
		WebElement inputField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"i_am_a_textbox\"]"));
		
		// click the input field 
		inputField.click();
		
		// Assert text before focus
		String textBefore = inputField.getText();
		Assert.assertEquals(textBefore, "i has no focus");
		
		// Clear the Input before SendKeys 
		String existingText = inputField.getText();
		for (int i = 0 ; i < existingText.length() ; i++) {
			inputField.sendKeys(Keys.BACK_SPACE);
		}
		
		// Fill Input with new value
		inputField.sendKeys("Saber Here!");
		
		
        Thread.sleep(2000);
        
       
    }
}
