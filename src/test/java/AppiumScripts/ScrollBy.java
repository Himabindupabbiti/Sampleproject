package AppiumScripts;

import io.appium.java_client.AppiumBy;

public class ScrollBy extends AppiumConfiguration{
    public void Scrollgesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())scrollIntoView(text(\"WebView\"))"));
        Thread.sleep(2000);
    }
    }

