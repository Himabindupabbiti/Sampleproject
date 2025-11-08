package AppiumScripts;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Map;

public class LongPress extends AppiumConfiguration {

    @Test
    public <MobileElement> void appiumLongpress() throws URISyntaxException, MalformedURLException, InterruptedException {

        // Navigate to "People Names"
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement peopleNames = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath("//android.widget.TextView[@text='People Names']")
                )
        );
        longpressAction(peopleNames);
        System.out.println("Long press performed on 'People Names'");
       /* String menutext=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")).getText();
        Assert.assertEquals(menutext,"Sample menu");*/
        Assert.assertTrue(driver.findElement
                (AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]"))
                .isDisplayed());
        System.out.println("passed'");

    }
}
