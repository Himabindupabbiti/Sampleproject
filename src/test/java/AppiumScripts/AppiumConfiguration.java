package AppiumScripts;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppiumConfiguration {
    public  ProcessBuilder pb;
    public AndroidDriver driver;
    public UiAutomator2Options options;
    public Process appiumProcess;

    @BeforeClass
    public void Configure() throws InterruptedException, URISyntaxException, MalformedURLException {
        String appPath = System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk";

        // 1️⃣ Start Appium server programmatically via ProcessBuilder
         pb = new ProcessBuilder(
                "cmd.exe", "/c",
                "appium", "-p", "4723"  // <-- tell Appium to use port 4725
        );  // Make sure Appium is in your PATH

        pb.inheritIO(); // show Appium logs in console

        try {
            appiumProcess = pb.start();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start Appium server", e);
        }

        System.out.println("Starting Appium server...");
        Thread.sleep(5000); // Wait for server to start

        // 2️⃣ Setup capabilities
 options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");   // Must match adb devices
        options.setPlatformName("Android");
        options.setApp(appPath);

        // 3️⃣ Start Android driver
        driver = new AndroidDriver (
                new URI("http://127.0.0.1:4723/").toURL(), options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void longpressAction(WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));

    }
    @AfterClass
public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        ;
        if (appiumProcess != null) {
            appiumProcess.destroy();
            System.out.println("Appium server stopped.");
        }
    }
}
