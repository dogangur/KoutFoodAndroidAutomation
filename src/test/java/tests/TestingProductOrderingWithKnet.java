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

public class TestingProductOrderingWithKnet {

    public AppiumDriver<MobileElement> driver;
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
            cap.setCapability("platformVersion", "13.0");
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
        WebDriverWait wait = new WebDriverWait(driver, durationTime);

        try {
            long startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.preciseButtonXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.preciseButtonXpath, "Precise Location Permission", durationTime);
            long endTime = System.currentTimeMillis();
            System.out.println("GivePermissionTest Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");
        } catch (Exception e) {
            System.out.println("Permission Test Failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void LoginTest() {
        long loginTestStartTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, durationTime);

        try {
            long startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.locationButton, "Allow Permission", durationTime);
            long endTime = System.currentTimeMillis();
            System.out.println("Allow Permission Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.getStartedButtonXpath, " Get Started ", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Get Started Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginButtonXpath, " Login ", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Login Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.loginViaEmailButtonXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginViaEmailButtonXpath, " Login Via Email ", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Login Via Email Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.emailTextFieldXpath));
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.emailTextFieldXpath, "dogan@test.com", " Email ", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Email Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.passwordTextFieldXpath));
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.passwordTextFieldXpath, "Qwerty123...", " Password ", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Password Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.loginWithLoginViaEmailXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginWithLoginViaEmailXpath, " Login With Via Email ", durationTime);
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
    public void ProductOrderingTest() throws InterruptedException {
        long productOrderingTestStartTime = System.currentTimeMillis();

        try {
            long startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.seeAllButtonXpath, "The See All", durationTime);
            long endTime = System.currentTimeMillis();
            System.out.println("The See All Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.ScrollUp(driver, 740, 1769, 752, 1339);
            endTime = System.currentTimeMillis();
            System.out.println("ScrollUp1 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.restaurantButtonXpath, "Restaurant", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Restaurant Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.ScrollUp(driver, 700, 2169, 691, 1249);
            endTime = System.currentTimeMillis();
            System.out.println("ScrollUp2 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.theProduct1ButtonXpath, "The Product1", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("The Product1 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.yourChoiceOfXpath, "Large", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Your Choice Of Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.ScrollUp(driver, 567, 1899, 613, 1062);
            endTime = System.currentTimeMillis();
            System.out.println("ScrollUp3 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            //_mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.byProductRadioButtonXpath, " By Product Radio ", durationTime);
            //_mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.secondByProductRadioButtonXpath, " Second By Product Radio ", durationTime);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.addToCartButton1Xpath, "Add To Cart1", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Add To Cart1 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCartButtonXpath, "Go To Cart", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Go To Cart Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCheckoutButtonXpath, "Go To Checkout", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Go To Checkout Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.kNetButtonXpath, "K-Net", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("K-Net Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.completePurchaseButtonXpath, "Complete Purchase", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Complete Purchase Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.bankXpath, "Bank", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Bank Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.ScrollUp(driver, 567, 1927, 595, 1062);
            endTime = System.currentTimeMillis();
            System.out.println("ScrollUp4 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.kNetTestCardXpath, "K-net test card Radio", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("K-net test card Radio Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindTextFieldAndEnterNumber(driver, _Mobile_appXpath.cardNumberXpath, "Card Number", "0000000001", durationTime); //1111111110
            endTime = System.currentTimeMillis();
            System.out.println("Card Number Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.clickToCloseTheKeyboardXpath, "Close The Keyboard", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Close The Keyboard Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.monthButtonXpath, "Month", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Month Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.month09ThRadioButtonXpath, "9th Month", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("9th Month Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.yearButtonXpath, "Year", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Year Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.year2025RadioButtonXpath, "Year 2025", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Year 2025 Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.cardPinXpath, "Pin", "1234", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Pin Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.submitButtonXpath, "Submit", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Submit Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.confirmButtonXpath, "Confirm", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Confirm Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.backToHomeButtonXpath, "Back To Home", durationTime);
            endTime = System.currentTimeMillis();
            System.out.println("Back To Home Duration: " + Helper.ConvertMillisecondToSecond(endTime - startTime) + " seconds");

            long productOrderingTestEndTime = System.currentTimeMillis();
            long productOrderingTestTotalTime = productOrderingTestEndTime - productOrderingTestStartTime;
            System.out.println("Product Ordering Total Test: " + Helper.ConvertMillisecondToSecond(productOrderingTestTotalTime) + " seconds");
        } catch (Exception e) {
            System.out.println("Product Ordering Test Failed: " + e.getMessage());
        }
    }
}
