package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestingCashOnDelivery {

    private AndroidDriver<MobileElement> driver;
    private long totalTestDuration = 0;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformVersion", "15.0");
        cap.setCapability("appPackage", "com.koutfood.koutfood");
        cap.setCapability("appActivity", "com.koutfood.koutfood.MainActivity");
        cap.setCapability("skipUnlock", "true");
        cap.setCapability("noReset", "false");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        long startTime = System.currentTimeMillis();
        driver.launchApp();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        totalTestDuration += totalTime;
        System.out.println("Setup : " + (totalTime / 1000.0) + " seconds");
    }

    @Test(priority = 1)
    public void testProductOrderingWithCashOnDelivery() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            executeStep("Allow Notifications", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Allow Location (Only This Time)", () -> {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button"))).click();
                    System.out.println("Location permission granted.");
                } catch (Exception e) {
                    System.out.println("Location permission button not found. Skipping this step.");
                }
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'Get Started'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Get Started\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'Login'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"login-button\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'Login Via Email'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Login via Email\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Enter Email", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id=\"login-via-email-input\"]"))).sendKeys("dogan@test.com");
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Enter Password", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id=\"login-via-email-password-input\"]"))).sendKeys("Qwerty123...");
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'Login'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"login-via-email-login-button\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'See All'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"See All \"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'Restaurant'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Burger King\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Click 'The Product1'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Fries, Price Upon Selection\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Choose 'Large'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Large\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Add to Cart", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"product-add-to-cart-button\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Go to Cart", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Go to Cart\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Go to Checkout", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Go to checkout\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Select Cash on Delivery", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Cash On Delivery\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Complete Purchase", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Complete Purchase\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

            executeStep("Back to Home", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Back To Home\"]"))).click();
            });
            TimeUnit.SECONDS.sleep(5);

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        }

        System.out.println("Total Test Duration: " + (totalTestDuration / 1000.0) + " seconds");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void executeStep(String stepName, Runnable step) {
        long startTime = System.currentTimeMillis();
        try {
            step.run();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            totalTestDuration += duration;
            System.out.println(stepName + " - Success (" + (duration / 1000.0) + " seconds)");
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            totalTestDuration += duration;
            System.out.println(stepName + " - Failed (" + (duration / 1000.0) + " seconds)");
            throw e;
        }
    }
}
