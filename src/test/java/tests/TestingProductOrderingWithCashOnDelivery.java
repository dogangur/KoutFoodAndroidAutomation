package tests;

import constants.MobileAppXpath;
import helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.MobileAppServices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestingProductOrderingWithCashOnDelivery {

    public AppiumDriver<MobileElement> driver;
    private MobileAppXpath _Mobile_appXpath;
    private MobileAppServices _mobileAppServices;
    int durationTime = 20;

    private class TestStepDuration {
        String stepName;
        long duration;

        TestStepDuration(String stepName, long duration) {
            this.stepName = stepName;
            this.duration = duration;
        }

        String getGrade() {
            double seconds = Double.parseDouble(Helper.ConvertMillisecondToSecond(duration));
            if (seconds <= 2) return "A";
            else if (seconds <= 3) return "B";
            else if (seconds <= 5) return "C";
            else if (seconds <= 7) return "D";
            else if (seconds <= 10) return "E";
            else return "F";
        }
    }

    List<TestStepDuration> durations = new ArrayList<>();

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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
            TimeUnit.SECONDS.sleep(5);

            WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.preciseButtonXpath));

            if (permissionButton != null && permissionButton.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(permissionButton));
                _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.preciseButtonXpath, "Precise Location Permission", durationTime);
            } else {
                throw new Exception("Permission button is not visible or clickable.");
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            durations.add(new TestStepDuration("Allow Permission", duration));
            System.out.println("GivePermissionTest Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

        } catch (Exception e) {
            System.out.println("Permission Test Failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void LoginTest() {
        long loginTestStartTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, 30); // Bekleme süresini 30 saniyeye çıkarın

        try {
            long startTime = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(5);
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.locationButton, "Allow Permission", durationTime);
            TimeUnit.SECONDS.sleep(5);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            durations.add(new TestStepDuration("Allow Permission", duration));
            System.out.println("Allow Permission Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            TimeUnit.SECONDS.sleep(5);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.getStartedButtonXpath, "Get Started", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Get Started", duration));
            System.out.println("Get Started Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            TimeUnit.SECONDS.sleep(5);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginButtonXpath, "Login", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Login", duration));
            System.out.println("Login Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.loginViaEmailButtonXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginViaEmailButtonXpath, "Login Via Email", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Login Via Email", duration));
            System.out.println("Login Via Email Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.emailTextFieldXpath));
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.emailTextFieldXpath, "dogan@test.com", "Email", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Email", duration));
            System.out.println("Email Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.passwordTextFieldXpath));
            _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.passwordTextFieldXpath, "Qwerty123...", "Password", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Password", duration));
            System.out.println("Password Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            wait.until(ExpectedConditions.visibilityOfElementLocated(_Mobile_appXpath.loginWithLoginViaEmailXpath));
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginWithLoginViaEmailXpath, "Login With Via Email", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Login With Via Email", duration));
            System.out.println("Login With Via Email Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            long loginTestEndTime = System.currentTimeMillis();
            long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
            durations.add(new TestStepDuration("Login Total Test", loginTestTotalTime));
            System.out.println("Login Total Test: " + Helper.ConvertMillisecondToSecond(loginTestTotalTime) + " seconds");
        } catch (Exception e) {
            System.out.println("Login Test Failed: " + e.getMessage());
            e.printStackTrace(); // Hatanın kaynağını tam olarak görmek için
        }
    }


    @Test(priority = 3)
    public void ProductOrderingTest() throws InterruptedException {
        long productOrderingTestStartTime = System.currentTimeMillis();

        try {
            long startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.seeAllButtonXpath, "The See All", durationTime);
            long endTime = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(2);
            long duration = endTime - startTime;
            durations.add(new TestStepDuration("The See All", duration));
            System.out.println("The See All Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");
            TimeUnit.SECONDS.sleep(2);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.restaurantButtonXpath, "Restaurant", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Restaurant", duration));
            System.out.println("Restaurant Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");
            TimeUnit.SECONDS.sleep(1);

            _mobileAppServices.ScrollUp(driver, 700, 2169, 691, 1249);

            startTime = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(1);
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.theProduct1ButtonXpath, "The Product1", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("The Product1", duration));
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The Product1 Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(1);
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.yourChoiceOfXpath, "Large", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Your Choice Of", duration));
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Your Choice Of Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.addToCartButton1Xpath, "Add To Cart1", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Add To Cart1", duration));
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Add To Cart1 Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            TimeUnit.SECONDS.sleep(3);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCartButtonXpath, "Go To Cart", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Go To Cart", duration));
            System.out.println("Go To Cart Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCheckoutButtonXpath, "Go TO Checkout", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Go TO Checkout", duration));
            System.out.println("Go TO Checkout Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.cashOnDeliveryButtonXpath, "Cash On Delivery", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Cash On Delivery", duration));
            System.out.println("Cash On Delivery Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            TimeUnit.SECONDS.sleep(1);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.completePurchaseButtonXpath, "Complete Purchase", durationTime);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Complete Purchase", duration));
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Complete Purchase Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            TimeUnit.SECONDS.sleep(7);

            startTime = System.currentTimeMillis();
            _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.backToHomeButtonXpath, "Back To Home", durationTime);
            endTime = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(1);
            duration = endTime - startTime;
            durations.add(new TestStepDuration("Back To Home", duration));
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Back To Home Duration: " + Helper.ConvertMillisecondToSecond(duration) + " seconds");

            long productOrderingTestEndTime = System.currentTimeMillis();
            long productOrderingTestTotalTime = productOrderingTestEndTime - productOrderingTestStartTime;
            durations.add(new TestStepDuration("Product Ordering Total Test", productOrderingTestTotalTime));
            System.out.println("Product Ordering Total Test: " + Helper.ConvertMillisecondToSecond(productOrderingTestTotalTime) + " seconds");

            printDurations();
        } catch (Exception e) {
            System.out.println("Product Ordering Test Failed: " + e.getMessage());
        }
    }

    private void printDurations() {
        System.out.println("\n\nTEST CASE NAME\t\tUSE CASE STEPS\t\tDuration (seconds)\tGrade");
        System.out.println("--------------------------------------------------------------");
        for (TestStepDuration duration : durations) {
            System.out.printf("%-20s\t%-30s\t%-10.2f\t%-5s\n", "Test Case", duration.stepName, Double.parseDouble(Helper.ConvertMillisecondToSecond(duration.duration)), duration.getGrade());
        }
    }
}
