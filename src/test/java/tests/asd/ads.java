package tests.asd;

import constants.AppXpath;
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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ads {

    private AppiumDriver<MobileElement> driver;
    private AppXpath _appXpath;
    int durationTime = 50;

    @BeforeTest
    void BeforeTest() {
        _appXpath = new AppXpath();

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

        MobileElement givePermission = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.givePermissionXpath));
        givePermission.click();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Givepermission Test: " + totalTime + " millisecond");
    }

    @Test(priority = 2)
    void LoginViaEmailTest() {

        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long loginTestStartTime = System.currentTimeMillis();


        long clickingGetStartedButtonStartTime = System.currentTimeMillis();
        MobileElement GetStartedButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.GetStartedButtonXpath));
        GetStartedButton.click();
        long clickingGetStartedButtonEndTime = System.currentTimeMillis();
        long clickingGetStartedButtonTotalTime = clickingGetStartedButtonEndTime - clickingGetStartedButtonStartTime;
        System.out.println("Clicking Get Started Button: " + clickingGetStartedButtonTotalTime + " millisecond");


        long clickingLoginButtonStartTime = System.currentTimeMillis();
        MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.loginButtonXpath));
        loginButton.click();
        long clickingLoginButtonEndTime = System.currentTimeMillis();
        long clickingLoginButtonTotalTime = clickingLoginButtonEndTime - clickingLoginButtonStartTime;
        System.out.println("Clicking the Login button:" + clickingLoginButtonTotalTime + " millisecond");

        long clickingLoginViaEmailButtonStartTime = System.currentTimeMillis();
        MobileElement emailButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.loginViaEmailButtonXpath));
        emailButton.click();
        long clickingLoginViaEmailButtonEndTime = System.currentTimeMillis();
        long clickingLoginViaEmailButtonTotalTime = clickingLoginViaEmailButtonEndTime - clickingLoginViaEmailButtonStartTime;
        System.out.println("Clicking the Login via Email button:" + clickingLoginViaEmailButtonTotalTime + " millisecond");

        long enteringTextInTheEmailTextFieldStartTime = System.currentTimeMillis();
        MobileElement emailTextField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.emailTextFieldXpath));
        emailTextField.sendKeys("EzgiAslan@gmail.com");
        long enteringTextInTheEmailTextFieldEndTime = System.currentTimeMillis();
        long enteringTextInTheEmailTextFieldTotalTime = enteringTextInTheEmailTextFieldEndTime - enteringTextInTheEmailTextFieldStartTime;
        System.out.println("Entering text in Email text field: " + enteringTextInTheEmailTextFieldTotalTime + " millisecond");

        long enteringTextInThePasswordTextFieldStartTime = System.currentTimeMillis();
        MobileElement passwordTextField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.passwordTextFieldXpath));
        passwordTextField.sendKeys("Ea1234567.??");
        long enteringTextInThePasswordTextFieldEndTime = System.currentTimeMillis();
        long enteringTextInThePasswordTextFieldTotalTime = enteringTextInThePasswordTextFieldEndTime - enteringTextInThePasswordTextFieldStartTime;
        System.out.println("Entering text in Password text field:" + enteringTextInThePasswordTextFieldTotalTime + " millisecond");

        long clickingControlEyeIconStartTime = System.currentTimeMillis();
        MobileElement ControlEyeIcon = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.controlEyeIconXpath));
        ControlEyeIcon.click();
        long clickingControlEyeIconEndTime = System.currentTimeMillis();
        long clickingControlEyeIconTotalTime = clickingControlEyeIconEndTime - clickingControlEyeIconStartTime;
        System.out.println("Clicking Control Eye Icon button:" + clickingControlEyeIconTotalTime + " millisecond");

        long clickingLoginWithLoginViaEmailStartTime = System.currentTimeMillis();
        MobileElement loginWithLoginViaEmail = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.loginWithLoginViaEmailXpath));
        loginWithLoginViaEmail.click();
        long clickingLoginWithLoginViaEmailEndTime = System.currentTimeMillis();
        long clickingLoginWithLoginViaEmailTotalTime = clickingLoginWithLoginViaEmailEndTime - clickingLoginWithLoginViaEmailStartTime;
        System.out.println("Clicking Login With Login Via Email button:" + clickingLoginWithLoginViaEmailTotalTime + " millisecond");

        long loginTestEndTime = System.currentTimeMillis();
        long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
        System.out.println("login Total Test: " + loginTestTotalTime + " millisecond");

    }

    @Test(priority = 3)
    void FilterTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long popularRestaurantTestStartTime = System.currentTimeMillis();

        long clickingFilterButtonStartTime = System.currentTimeMillis();
        MobileElement filterButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.filterButtonXpath));
        filterButton.click();
        long clickingFilterButtonEndTime = System.currentTimeMillis();
        long clickingFilterButtonTotalTime = clickingFilterButtonEndTime - clickingFilterButtonStartTime;
        System.out.println("clicking Filter Button: " + clickingFilterButtonTotalTime + " millisecond");

        long cclosingStartTime = System.currentTimeMillis();
        Thread.sleep(2000);
        MobileElement closing = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.closingTheSearchField2Xpath));
        closing.click();
        long closingEndTime = System.currentTimeMillis();
        long closingTotalTime = closingEndTime - cclosingStartTime;
        System.out.println("closing : " + closingTotalTime + " millisecond");

        long clickingArabicButtonStartTime = System.currentTimeMillis();
        Thread.sleep(2000);
        MobileElement arabicButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.arabicButtonXpath));
        arabicButton.click();
        long clickingArabicButtonEndTime = System.currentTimeMillis();
        long clickingArabicButtonTotalTime = clickingArabicButtonEndTime - clickingArabicButtonStartTime;
        System.out.println("clicking Arabic Button: " + clickingArabicButtonTotalTime + " millisecond");

        long closingTheSearchStartTime = System.currentTimeMillis();
        MobileElement closingTheSearch = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.closingTheSearchFieldXpath));
        closingTheSearch.click();
        long closingTheSearchEndTime = System.currentTimeMillis();
        long closingTheSearchTotalTime = closingTheSearchEndTime - closingTheSearchStartTime;
        System.out.println("closingTheSearch Arabic Button: " + closingTheSearchTotalTime + " millisecond");


        long clickingBackPageButtonStartTime = System.currentTimeMillis();
       Thread.sleep(2000);
        MobileElement backPageButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.backPageButtonXpath));
        backPageButton.click();
        long clickingBackPageButtonEndTime = System.currentTimeMillis();
        long clickingBackPageButtonTotalTime = clickingBackPageButtonEndTime - clickingBackPageButtonStartTime;
        System.out.println("Clicking Back Page Button: " + clickingBackPageButtonTotalTime + " millisecond");

        long clickingCouplesFeastFavoriteButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastFavoriteButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.colaButtonXpath));
        couplesFeastFavoriteButton.click();
        long clickingCouplesFeastFavoriteButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastFavoriteButtonTotalTime = clickingCouplesFeastFavoriteButtonEndTime - clickingCouplesFeastFavoriteButtonStartTime;
        System.out.println("Clicking Couples Feast Favorite Button: " + clickingCouplesFeastFavoriteButtonTotalTime + " millisecond");

        long clickingCouplesFeastButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.cocaColaButtonXpath));
        couplesFeastButton.click();
        long clickingCouplesFeastButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastButtonTotalTime = clickingCouplesFeastButtonEndTime - clickingCouplesFeastButtonStartTime;
        System.out.println("coca cola: " + clickingCouplesFeastButtonTotalTime + " millisecond");


        long clickingPanRadioButtonStartTime = System.currentTimeMillis();
        Thread.sleep(2000);
        MobileElement panRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.backPageButtonXpath));
        panRadioButton.click();
        long clickingPanRadioButtonEndTime = System.currentTimeMillis();
        long clickingPanRadioButtonTotalTime = clickingPanRadioButtonEndTime - clickingPanRadioButtonStartTime;
        System.out.println("back:  " + clickingPanRadioButtonTotalTime + " millisecond");


        long clickingUltimateCheeseRadioButtonStartTime = System.currentTimeMillis();
        Thread.sleep(2000);
        MobileElement ultimateCheeseRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.backPageButtonXpath));
        ultimateCheeseRadioButton.click();
        long checkingUltimateCheeseRadioButtonEndTime = System.currentTimeMillis();
        long checkingUltimateCheeseRadioButtonTotalTime = checkingUltimateCheeseRadioButtonEndTime - clickingUltimateCheeseRadioButtonStartTime;
        System.out.println("back: " + checkingUltimateCheeseRadioButtonTotalTime + " millisecond");

        long clickingMacaroniSaladRadioButtonStartTime = System.currentTimeMillis();
        MobileElement macaroniSaladRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.mixButtonXpath));
        macaroniSaladRadioButton.click();
        long clickingMacaroniSaladRadioButtonEndTime = System.currentTimeMillis();
        long clickingMacaroniSaladRadioButtonTotalTime = clickingMacaroniSaladRadioButtonEndTime - clickingMacaroniSaladRadioButtonStartTime;
        System.out.println("mix Button: " + clickingMacaroniSaladRadioButtonTotalTime + " millisecond");

        Thread.sleep(1000);
        TouchAction scrollUp = new TouchAction<>(driver)
                .press(PointOption.point(771, 2025))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(804, 497))
                .release()
                .perform();

        Thread.sleep(1000);
        TouchAction scrollDown = new TouchAction<>(driver)
                .press(PointOption.point(702, 619))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(718, 1875))
                .release()
                .perform();

        long clickingMirindaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement mirindaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.bkLuluHypermarketButtonXpath));
        mirindaRadioButton.click();
        long clickingMirindaRadioButtonEndTime = System.currentTimeMillis();
        long clickingMirindaRadioButtonTotalTime = clickingMirindaRadioButtonEndTime - clickingMirindaRadioButtonStartTime;
        System.out.println("lulu " + clickingMirindaRadioButtonTotalTime + " millisecond");

        long clickingSevenUpRadioButtonStartTime = System.currentTimeMillis();
        MobileElement sevenUpRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.onlyOnSpeedyBunnyButtonXpath));
        sevenUpRadioButton.click();
        long clickingSevenUpRadioButtonEndTime = System.currentTimeMillis();
        long clickingSevenUpRadioButtonTotalTime = clickingSevenUpRadioButtonEndTime - clickingSevenUpRadioButtonStartTime;
        System.out.println("only: " + clickingSevenUpRadioButtonTotalTime + " millisecond");

        Thread.sleep(500);
        long CheckingAddToCartButtonStartTime = System.currentTimeMillis();
        MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.familyAndFriendsOffersButtonXpath));
        addToCartButton.click();
        long CheckingAddToCartButtonEndTime = System.currentTimeMillis();
        long CheckingAddToCartButtonTotalTime = CheckingAddToCartButtonEndTime - CheckingAddToCartButtonStartTime;
        System.out.println("family: " + CheckingAddToCartButtonTotalTime + " millisecond");


        long checkingGoToCartButtonStartTime = System.currentTimeMillis();
        Thread.sleep(2000);
        MobileElement goToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.backPageButtonXpath));
        goToCartButton.click();
        long checkingGoToCartButtonEndTime = System.currentTimeMillis();
        long checkingGoToCartButtonTotalTime = checkingGoToCartButtonEndTime - checkingGoToCartButtonStartTime;
        System.out.println("back: " + checkingGoToCartButtonTotalTime + " millisecond");

        long checkingRemoveProductFromCartButtonStartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.clearButtonXpath));
        removeProductFromCartButton.click();
        long checkingRemoveProductFromCartButtonEndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButtonTotalTime = checkingRemoveProductFromCartButtonEndTime - checkingRemoveProductFromCartButtonStartTime;
        System.out.println("logout: " + checkingRemoveProductFromCartButtonTotalTime + " millisecond");

        long checkingTrashBinButtonStartTime = System.currentTimeMillis();
        MobileElement trashBinButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.backPageButtonXpath));
        trashBinButton.click();
        long checkingTrashBinButtonEndTime = System.currentTimeMillis();
        long checkingTrashBinButtonTotalTime = checkingTrashBinButtonEndTime - checkingTrashBinButtonStartTime;
        System.out.println("back: " + checkingTrashBinButtonTotalTime + " millisecond");

        long popularRestaurantTestEndTime = System.currentTimeMillis();
        long popularRestaurantTestTotalTime = popularRestaurantTestEndTime - popularRestaurantTestStartTime;
        System.out.println("filter Test: " + popularRestaurantTestTotalTime + " millisecond");

    }
}
