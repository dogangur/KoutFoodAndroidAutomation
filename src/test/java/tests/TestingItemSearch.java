package tests;

import constants.MobileAppId;
import constants.MobileAppXpath;
import helper.Helper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestingItemSearch {

    private AndroidDriver<MobileElement> driver;
    private MobileAppXpath xpath;
    private MobileAppId id;

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
        System.out.println("Setup : " + totalTime + " milliseconds");

        xpath = new MobileAppXpath();  // Xpath sınıfı örneği oluşturuluyor
        id = new MobileAppId();
    }

    @Test
    public void testItemSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            executeStep("Allow Notifications", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button"))).click();
            });

            executeStep("Allow Location (Only This Time)", () -> {
                try {
                    WebElement locationButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")));
                    if (locationButton.isDisplayed()) {
                        locationButton.click();
                        System.out.println("Location permission granted.");
                    }
                } catch (Exception e) {
                    System.out.println("Location permission button not found. Skipping this step.");
                }
            });

            executeStep("Click 'Get Started'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Get Started\"]"))).click();
            });

            executeStep("Click 'Login'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"login-button\"]"))).click();
            });

            executeStep("Click 'Login Via Email'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Login via Email\"]"))).click();
            });

            executeStep("Enter Email", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("login-via-email-input"))).sendKeys("dogan@test.com");
            });

            executeStep("Enter Password", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("login-via-email-password-input"))).sendKeys("Qwerty123...");
            });

            executeStep("Click 'Login'", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("login-via-email-login-button"))).click();
            });

            executeStep("Click on the 'Searchbox' textfield", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.koutfood.koutfood:id/searchBox"))).click();
            });

            executeStep("Search for 'Chicken'", () -> {
                driver.findElement(By.id("com.koutfood.koutfood:id/searchBox")).sendKeys("Chicken");
            });

            executeStep("Click 'X' icon to clear search", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.koutfood.koutfood:id/clearSearchBox"))).click();
            });

            executeStep("Search for 'Burger'", () -> {
                driver.findElement(By.id("com.koutfood.koutfood:id/searchBox")).sendKeys("Burger");
            });

            executeStep("Click 'X' icon to clear search", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.koutfood.koutfood:id/clearSearchBox"))).click();
            });

            executeStep("Search for 'Fries'", () -> {
                driver.findElement(By.id("com.koutfood.koutfood:id/searchBox")).sendKeys("Fries");
            });

            executeStep("Click 'X' icon to clear search", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.koutfood.koutfood:id/clearSearchBox"))).click();
            });

            executeStep("Click Home Page icon", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("com.koutfood.koutfood:id/homePageIcon"))).click();
            });

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        }
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
            System.out.println(stepName + " - Success (" + duration + " milliseconds)");
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println(stepName + " - Failed (" + duration + " milliseconds)");
            throw e;
        }
    }
}





/**
test steps;
1. AllowToNotification(Allow)
2. LocationAllow (OnlyThisTime)
3. GetStarted (GetStarted)
4. Login(Login)
5. LoginViaEmail(LoginViaEmail)
6. Email(Email Text Field)
7. Password(Password Text Field)
8. Login(Login)
9. Click on the "Searchbox" textfield
 10. Search "Chicken" item
 11. Click "X" icon
 12. Search "Burger" item
 13. Click "X" icon
 14. Search Fries
 15. Click "X" icon
 16. Click Home Page icon


public class TestingItemSearch {
}
**/