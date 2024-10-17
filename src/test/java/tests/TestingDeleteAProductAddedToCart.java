package tests;

import constants.MobileAppXpath;
import helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.MobileAppServices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestingDeleteAProductAddedToCart {

    private AppiumDriver<MobileElement> driver;
    private MobileAppXpath _Mobile_appXpath;
    private MobileAppServices _mobileAppServices;
    int durationTime = 50;

    @BeforeTest
    public void setUp() {
        _Mobile_appXpath = new MobileAppXpath();
        _mobileAppServices = new MobileAppServices();

        try {
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
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            long startTime = System.currentTimeMillis();
            driver.launchApp();
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Setup : " + totalTime + " milliseconds");
        } catch (MalformedURLException mx) {
            System.out.println("Malformed URL Exception: " + mx.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void GivePermissionTest() {
        if (driver == null) {
            throw new IllegalStateException("Driver initialization failed.");
        }

        long startTime = System.currentTimeMillis();
        _mobileAppServices.GivePermissionTest(driver, durationTime);
        long endTime = System.currentTimeMillis();
        System.out.println("GivePermissionTest Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");
    }

    @Test(priority = 2)
    public void LoginTest() {
        if (driver == null) {
            throw new IllegalStateException("Driver initialization failed.");
        }

        long loginTestStartTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, durationTime);

        try {
            long startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.locationButton, "Allow Permission", durationTime);
            long endTime = System.currentTimeMillis();
            System.out.println("Allow Permission Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.getStartedButtonXpath, "Get Started", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Get Started Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginButtonXpath, "Login", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Login Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.loginViaEmailButtonXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginViaEmailButtonXpath, "Login Via Email", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Login Via Email Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.emailTextFieldXpath));
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.emailTextFieldXpath, "dogan@test.com", "Email", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Email Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.passwordTextFieldXpath));
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.passwordTextFieldXpath, "Qwerty123...", "Password", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Password Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.loginWithLoginViaEmailXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginWithLoginViaEmailXpath, "Login With Via Email", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Login With Via Email Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            long loginTestEndTime = System.currentTimeMillis();
            long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
            System.out.println("Login Total Test: " + Helper.ConvertMillisecondToSecond(loginTestTotalTime) + " seconds");
        } catch (Exception e) {
            System.out.println("Login Test Failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void DeleteAProductAddedToCartTest() throws InterruptedException {
        if (driver == null) {
            throw new IllegalStateException("Driver initialization failed.");
        }

        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long productOrderingTestStartTime = System.currentTimeMillis();

        try {
            long startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.seeAllButtonXpath, "The See All", durationTime);
            long endTime = System.currentTimeMillis();
            System.out.println("The See All Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.restaurantButtonXpath, "Restaurant", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Restaurant Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            //_mobileAppServices.ScrollUp(driver, 700, 2169, 691, 1249);
            TimeUnit.SECONDS.sleep(3);
            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.theProduct2ButtonXpath, "The Product2", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("The Product2 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            TimeUnit.SECONDS.sleep(3);
            //_mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.yourChoiceOfXpath, "Large", durationTime);
            //_mobileAppServices.ScrollUp(driver, 567, 1899, 613, 1062);
            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.addToCartButton2Xpath, "Add To Cart2", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Add To Cart2 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCartButtonXpath, "Go To Cart", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Go To Cart Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            // Kaydırarak sepetten ürün silme
            //_mobileAppServices.SwipeElement(driver, 800, 600, 200, 600); // Örnek kaydırma koordinatları
            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.deleteButtonXpath, "Delete", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Delete Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.startShoppingButtonXpath, "Start Shopping", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Start Shopping Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            long productOrderingTestEndTime = System.currentTimeMillis();
            long productOrderingTestTotalTime = productOrderingTestEndTime - productOrderingTestStartTime;
            System.out.println("Product Ordering Total Test: " + Helper.ConvertMillisecondToSecond(productOrderingTestTotalTime) + " seconds");
        } catch (Exception e) {
            System.out.println("Product Ordering Test Failed: " + e.getMessage());
        }
    }
}
