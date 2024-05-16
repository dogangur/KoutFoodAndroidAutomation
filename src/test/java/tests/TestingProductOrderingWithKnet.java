package tests;

import constants.MobileAppXpath;
import helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    void BeforeTest() {
        _Mobile_appXpath = new MobileAppXpath();
        _mobileAppServices = new MobileAppServices();

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("appium:deviceName", "samsung SM-A23SF");
            cap.setCapability("appium:platformName", "Android");
            cap.setCapability("appium:uuid", "R68TC01QGZZ");
            cap.setCapability("appium:platformVersion", "14.0");
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
        _mobileAppServices.GivePermissionTest(driver,durationTime);
    }

    @Test(priority = 2)
    void LoginTest() {

        long loginTestStartTime = System.currentTimeMillis();

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.getStartedButtonXpath," Get Started ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginButtonXpath, " Login ",durationTime);

////   TELEFON NUMARASI İLE GİRİŞ
//        _mobileServices.FindButtonElementAndClick(driver,_appXpath.countryPhoneCodeButtonXpath,durationTime);
//        _mobileServices.FindButtonElementAndClick(driver, _appXpath.egyptPhoneCodeXpath,durationTime);
//        _mobileServices.FindTextFieldAndEnterPhoneNumber(driver,_appXpath.phoneNumberTextFieldXpath,"Phone Number", durationTime);

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginViaEmailButtonXpath," Login Via Email ",durationTime);
        _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.emailTextFieldXpath,"EzgiAslan@gmail.com", " Email ", durationTime);
        _mobileAppServices.FindTextFieldElementAndWrite(driver, _Mobile_appXpath.passwordTextFieldXpath,"Ea1234567.??", " Password ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.loginWithLoginViaEmailXpath," Login With Via Email ", durationTime);

        long loginTestEndTime = System.currentTimeMillis();
        long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
        System.out.println("Login Total Test: " + Helper.ConvertMillisecondToSecond(loginTestTotalTime) + " second");
    }

    @Test(priority = 3)
    void ProductOrderingTest() throws InterruptedException {

        long productOrderingTestStartTime = System.currentTimeMillis();

        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.seeAllButtonXpath," The See All ",durationTime);
        _mobileAppServices.ScrollUp(driver,740,1769,752,1339);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.restaurantButtonXpath," Restaurant ", durationTime);
        _mobileAppServices.ScrollUp(driver, 700,2169,691,1249);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.theProductButtonXpath," The Product ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.familyMealButtonXpath," Family Meal Radio ", durationTime);
        _mobileAppServices.ScrollUp(driver, 567, 1899, 613, 1062);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.byProductRadioButtonXpath," By Product Radio ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.secondByProductRadioButtonXpath," Second By Product Radio ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.addToCartButtonXpath," Add To Card ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCartButtonXpath," Go To Cart ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.goToCheckoutButtonXpath," Go To Checkout ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.kNetButtonXpath," K-Net ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.completePurchaseButtonXpath," Complete Purchase ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.bankXpath," Bank ",durationTime);
        _mobileAppServices.ScrollUp(driver,567,1927,595,1062);
        _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.kNetTestCartXpath," K-net test cart Radio",durationTime);
        _mobileAppServices.FindTextFieldAndEnterNumber(driver,_Mobile_appXpath.cardNumberXpath," Cart Number","0000000001", durationTime); //1111111110
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.clickToCloseTheKeyboardXpath," Close The Keyboard", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.monthButtonXpath," Month ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.month09ThRadioButtonXpath," 9th Month ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.yearButtonXpath," Year ",durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.year2025RadioButtonXpath, " Year 2025 " ,durationTime);
        _mobileAppServices.FindTextFieldElementAndWrite(driver,_Mobile_appXpath.cartPinXpath," Pin " , "1234", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.submitButtonXpath," Submit ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver,_Mobile_appXpath.confirmButtonXpath," Confirm ", durationTime);
        _mobileAppServices.FindButtonElementAndClick(driver, _Mobile_appXpath.backToHomeButtonXpath," Back To Home ", durationTime);

        long productOrderingTestEndTime = System.currentTimeMillis();
        long productOrderingTestTotalTime = productOrderingTestEndTime - productOrderingTestStartTime;
        System.out.println("Product Ordering Total Test: " + Helper.ConvertMillisecondToSecond(productOrderingTestTotalTime) + " second");
    }
}
