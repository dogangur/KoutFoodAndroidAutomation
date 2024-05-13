package tests;

import constants.MobileAppXpath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.MobileAppServices;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestingDeleteAProductAddedToCart {

    private AppiumDriver<MobileElement> driver;
    private MobileAppXpath _Mobile_appXpath;
    private MobileAppServices _mobileAppServices;
    int durationTime = 50;

    @BeforeTest
    void BeforeTest() {
        _Mobile_appXpath = new MobileAppXpath();

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("appium:deviceName", "samsung SM-A23SF");
            cap.setCapability("appium:platformName", "Android");
            cap.setCapability("appium:uuid", "R68TC01QGZZ");
            cap.setCapability("appium:platformVersion", "13.0");
            cap.setCapability("appium:appPackage", "com.koutfood.koutfood");
            cap.setCapability("appium:appActivity", "com.koutfood.koutfood.MainActivity");
            cap.setCapability("appium:skipUnlock", "true");
            cap.setCapability("appium:noReset", "false");


            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            long startTime = System.currentTimeMillis();
            driver.launchApp();
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Setup : " + totalTime + " millisecond");

        } catch (MalformedURLException mx) {
            System.out.println("Malformed URL Exception");
        }
    }

    @Test(priority = 1)
    void GivepermissionTest() {

        Wait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(durationTime))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        long startTime = System.currentTimeMillis();

        MobileElement givePermission = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_Mobile_appXpath.givePermissionXpath));
        givePermission.click();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Givepermission Test: " + totalTime + " millisecond");
    }

    @Test(priority = 2)
    void LoginViaEmailTest() {

        long loginTestStartTime = System.currentTimeMillis();


        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.getStartedButtonXpath,"Get Started ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginButtonXpath, "Login ",durationTime);

////   TELEFON NUMARASI İLE GİRİŞ
//        _mobileServices.FindButtonElementAndClick(driver,_appXpath.countryPhoneCodeButtonXpath,durationTime);
//        _mobileServices.FindButtonElementAndClick(driver, _appXpath.egyptPhoneCodeXpath,durationTime);
//        _mobileServices.FindTextFieldAndEnterPhoneNumber(driver,_appXpath.phoneNumberTextFieldXpath,"Phone Number", durationTime);

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginViaEmailButtonXpath,"Login Via Email ",durationTime);
        _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.emailTextFieldXpath,"EzgiAslan@gmail.com", "Email ", durationTime);
        _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.passwordTextFieldXpath,"Ea1234567.??", "Password ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginWithLoginViaEmailXpath,"Login With Via Email ", durationTime);

        long loginTestEndTime = System.currentTimeMillis();
        long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
        System.out.println("Login Total Test: " + loginTestTotalTime + " millisecond");
    }


    @Test(priority = 3)
    void DeleteAProductAddedToCartTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, durationTime);

        long ProductOrderingTestStartTime = System.currentTimeMillis();

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.seeAllButtonXpath, "The See All ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.restaurantButtonXpath, "Restaurant ", durationTime);

        Thread.sleep(1000);

        new TouchAction<>(driver)
                .press(PointOption.point(700, 2169))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(691, 1249))
                .release()
                .perform();

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.theProductButtonXpath, "The Product ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.familyMealButtonXpath, "Family Meal Radio ", durationTime);

        Thread.sleep(800);

        TouchAction scrollUpToClickOnProductDetails = new TouchAction<>(driver)
                .press(PointOption.point(567, 1899))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(613, 1062))
                .release()
                .perform();

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.byProductRadioButtonXpath, "By Product Radio ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.secondByProductRadioButtonXpath, "Second By Product Radio ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.addToCartButtonXpath, "Add To Card ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCartButtonXpath, "Go To Cart ", durationTime);


        Thread.sleep(800);

        TouchAction scrollUpToClickOnProduct = new TouchAction<>(driver)
                .press(PointOption.point(990, 890))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(619, 883))
                .release()
                .perform();
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.deleteButtonXpath, " Delete ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.startShoppingButtonXpath,"Start Shopping Button", durationTime);

        // _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.trashBinIconXpath," trash " , durationTime);
        // _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.removeProductFromCartButtonXpath, "Remove Product From Cart", durationTime);
        //_mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.startShoppingButtonXpath,"Start Shopping Button", durationTime);

        long ProductOrderingTestEndTime = System.currentTimeMillis();
        long ProductOrderingTestTotalTime = ProductOrderingTestEndTime - ProductOrderingTestStartTime;
        System.out.println("Product Ordering Total Test: " + ProductOrderingTestTotalTime + " millisecond");
    }
}
