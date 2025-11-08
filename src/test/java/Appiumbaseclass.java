import AppiumScripts.AppiumConfiguration;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.HttpURLConnection;
import java.net.URL;
public class Appiumbaseclass extends AppiumConfiguration {


    @Test
    public void appiumTest() throws URISyntaxException, MalformedURLException, InterruptedException {

        // Path to APK
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(0)")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
        String title=driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title,"WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Tittuwifi");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();

        System.out.println("✅ App launched successfully!");

        // 4️⃣ Your test code can go here
        Thread.sleep(3000); // Demo wait to see app launch

        // 5️⃣ Quit driver and stop Appium server

    }
}
