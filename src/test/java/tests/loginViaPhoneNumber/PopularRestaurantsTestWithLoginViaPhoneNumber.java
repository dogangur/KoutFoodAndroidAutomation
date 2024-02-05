package tests.loginViaPhoneNumber;

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

public class PopularRestaurantsTestWithLoginViaPhoneNumber {

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
    void LoginViaEmailTest() throws InterruptedException {

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

        long enteringTextInThePasswordTextFieldStartTime = System.currentTimeMillis();
        MobileElement aa = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.alankoduXpath));
        aa.click();
        long enteringTextInThePasswordTextFieldEndTime = System.currentTimeMillis();
        long enteringTextInThePasswordTextFieldTotalTime = enteringTextInThePasswordTextFieldEndTime - enteringTextInThePasswordTextFieldStartTime;
        System.out.println("alan kodu:" + enteringTextInThePasswordTextFieldTotalTime + " millisecond");

        long clickingControlEyeIconStartTime = System.currentTimeMillis();
        MobileElement bb = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.egyptCodeXpath));
        bb.click();
        long clickingControlEyeIconEndTime = System.currentTimeMillis();
        long clickingControlEyeIconTotalTime = clickingControlEyeIconEndTime - clickingControlEyeIconStartTime;
        System.out.println("egypt code" + clickingControlEyeIconTotalTime + " millisecond");

        long clickingPhoneNumberTextFieldStartTime = System.currentTimeMillis();
        MobileElement phoneNumberTextField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.phoneNumberTextFieldXpath));
        phoneNumberTextField.click();
// Telefon numarası tuşlamalarını simüle etmek için KeyEvent kullanma
        String phoneNumber = "1234512368";
        for (char digit : phoneNumber.toCharArray()) {
            String digitStr = Character.toString(digit);
            driver.getKeyboard().sendKeys(digitStr); // Her rakamı ayrı ayrı gönder
        }

        long clickingPhoneNumberTextFieldEndTime = System.currentTimeMillis();
        long clickingPhoneNumberTextFieldTotalTime = clickingPhoneNumberTextFieldEndTime - clickingPhoneNumberTextFieldStartTime;
        System.out.println("Clicking Phone Number Text Field:" + clickingPhoneNumberTextFieldTotalTime + " millisecond");

        long clickingLoginWithLoginViaEmailStartTime = System.currentTimeMillis();
        MobileElement loginWithLoginViaEmail = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.loginWithLoginViaEmailXpath));
        loginWithLoginViaEmail.click();
        long clickingLoginWithLoginViaEmailEndTime = System.currentTimeMillis();
        long clickingLoginWithLoginViaEmailTotalTime = clickingLoginWithLoginViaEmailEndTime - clickingLoginWithLoginViaEmailStartTime;
        System.out.println("Clicking Login With Login Via Email button:" + clickingLoginWithLoginViaEmailTotalTime + " millisecond");

        long verificationStartTime = System.currentTimeMillis();
        Thread.sleep(4000);
        MobileElement verificationCodeIndex = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.verificationCodeIndexXpath));
        verificationCodeIndex.click();

        Thread.sleep(1000);
        String verificationCode = "1234";
        for (char digit : verificationCode.toCharArray()) {
            String digitStr = Character.toString(digit);
            driver.getKeyboard().sendKeys(digitStr); // Her rakamı ayrı ayrı gönder
        }

        long verificationEndTime = System.currentTimeMillis();
        long verificationTotalTime = verificationEndTime - verificationStartTime;
        System.out.println("verification: " + verificationTotalTime + " millisecond");

        long clickingSubmitButtonStartTime = System.currentTimeMillis();
        MobileElement clickingSubmitButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.submitButtonXpath));
        clickingSubmitButton.click();
        long clickingClickingSubmitButtonEndTime = System.currentTimeMillis();
        long clickingClickingSubmitButtonTotalTime = clickingClickingSubmitButtonEndTime - clickingSubmitButtonStartTime;
        System.out.println("Clicking Submit Button" + clickingClickingSubmitButtonTotalTime + " millisecond");



        long loginTestEndTime = System.currentTimeMillis();
        long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
        System.out.println("login Total Test: " + loginTestTotalTime + " millisecond");

    }

    @Test(priority = 3)
    void PopularRestaurantTest() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long popularRestaurantTestStartTime = System.currentTimeMillis();

        //Thread.sleep(500);
        long clickingSeeAllButtonStartTime = System.currentTimeMillis();//düzelt
        MobileElement seeAllButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.seeAllPopularRestaurantsButtonXpath));
        seeAllButton.click();
        long clickingSeeAllButtonEndTime = System.currentTimeMillis();
        long clickingSeeAllButtonTotalTime = clickingSeeAllButtonEndTime - clickingSeeAllButtonStartTime;
        System.out.println("Checking See All Button: " + clickingSeeAllButtonTotalTime + " millisecond");

        Thread.sleep(600);
        long closingTheSearchFieldStartTime = System.currentTimeMillis();
        MobileElement closingTheSearchField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.closingTheSearchFieldXpath));
        closingTheSearchField.click();
        long closingTheSearchFieldEndTime = System.currentTimeMillis();
        long closingTheSearchFieldTotalTime = closingTheSearchFieldEndTime - closingTheSearchFieldStartTime;
        System.out.println("Closing The Search Field: " + closingTheSearchFieldTotalTime + " millisecond");

        Thread.sleep(1000);
        TouchAction scrollUpToPopularRestaurants = new TouchAction<>(driver)
                .press(PointOption.point(740, 2008))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(781, 993))
                .release()
                .perform();

        Thread.sleep(500);
        long clickingPhJahraButtonStartTime = System.currentTimeMillis();
        MobileElement phJahraButtonButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.phJahraButtonXpath));
        phJahraButtonButton.click();
        long clickingPhJahraButtonEndTime = System.currentTimeMillis();
        long clickingPhJahraButtonTotalTime = clickingPhJahraButtonEndTime - clickingPhJahraButtonStartTime;
        System.out.println("Checking PhJahra Button: " + clickingPhJahraButtonTotalTime + " millisecond");
        //
        Thread.sleep(4000);
        TouchAction scrollUpToClickOnPhJahra = new TouchAction<>(driver)
                .press(PointOption.point(600, 2027))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(614, 1080))
                .release()
                .perform();

        long clickingCouplesFeastFavoriteButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastFavoriteButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastFavoriteButtonXpath));
        couplesFeastFavoriteButton.click();
        long clickingCouplesFeastFavoriteButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastFavoriteButtonTotalTime = clickingCouplesFeastFavoriteButtonEndTime - clickingCouplesFeastFavoriteButtonStartTime;
        System.out.println("Clicking Couples Feast Favorite Button: " + clickingCouplesFeastFavoriteButtonTotalTime + " millisecond");

        long clickingCouplesFeastButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastButtonXpath));
        couplesFeastButton.click();
        long clickingCouplesFeastButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastButtonTotalTime = clickingCouplesFeastButtonEndTime - clickingCouplesFeastButtonStartTime;
        System.out.println("Clicking Couples Feast Button: " + clickingCouplesFeastButtonTotalTime + " millisecond");
//
        Thread.sleep(1000);
        TouchAction scrollUpToClickOnProductDetails = new TouchAction<>(driver)
                .press(PointOption.point(501, 1670))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(547, 888))
                .release()
                .perform();

        long clickingPanRadioButtonStartTime = System.currentTimeMillis();
        MobileElement panRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.panRadioButtonXpath));
        panRadioButton.click();
        long clickingPanRadioButtonEndTime = System.currentTimeMillis();
        long clickingPanRadioButtonTotalTime = clickingPanRadioButtonEndTime - clickingPanRadioButtonStartTime;
        System.out.println("Clicking Pan Radio Button: " + clickingPanRadioButtonTotalTime + " millisecond");

        long clickingUltimateCheeseRadioButtonStartTime = System.currentTimeMillis();
        MobileElement ultimateCheeseRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.ultimateCheeseRadioButtonXpath));
        ultimateCheeseRadioButton.click();
        long checkingUltimateCheeseRadioButtonEndTime = System.currentTimeMillis();
        long checkingUltimateCheeseRadioButtonTotalTime = checkingUltimateCheeseRadioButtonEndTime - clickingUltimateCheeseRadioButtonStartTime;
        System.out.println("Clicking Ultimate Cheese Radio Button: " + checkingUltimateCheeseRadioButtonTotalTime + " millisecond");

        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails2 = new TouchAction<>(driver)
                .press(PointOption.point(671, 1760))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(671, 882))
                .release()
                .perform();

        long clickingMacaroniSaladRadioButtonStartTime = System.currentTimeMillis();
        MobileElement macaroniSaladRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.macaroniSaladRadioButtonXpath));
        macaroniSaladRadioButton.click();
        long clickingMacaroniSaladRadioButtonEndTime = System.currentTimeMillis();
        long clickingMacaroniSaladRadioButtonTotalTime = clickingMacaroniSaladRadioButtonEndTime - clickingMacaroniSaladRadioButtonStartTime;
        System.out.println("Clicking Macaroni Salad Radio Button: " + clickingMacaroniSaladRadioButtonTotalTime + " millisecond");

        long clickingMirindaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement mirindaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.mirindaRadioButtonXapth));
        mirindaRadioButton.click();
        long clickingMirindaRadioButtonEndTime = System.currentTimeMillis();
        long clickingMirindaRadioButtonTotalTime = clickingMirindaRadioButtonEndTime - clickingMirindaRadioButtonStartTime;
        System.out.println("Clicking Mirinda Radio Button: " + clickingMirindaRadioButtonTotalTime + " millisecond");
/*
        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails3 = new TouchAction<>(driver)
                .press(PointOption.point(512, 1431))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(509, 615))
                .release()
                .perform();
        */
        long clickingSevenUpRadioButtonStartTime = System.currentTimeMillis();
        MobileElement sevenUpRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.sevenUpRadioButtonXapth));
        sevenUpRadioButton.click();
        long clickingSevenUpRadioButtonEndTime = System.currentTimeMillis();
        long clickingSevenUpRadioButtonTotalTime = clickingSevenUpRadioButtonEndTime - clickingSevenUpRadioButtonStartTime;
        System.out.println("Clicking Seven Up Radio Button: " + clickingSevenUpRadioButtonTotalTime + " millisecond");

        Thread.sleep(500);
        long CheckingAddToCartButtonStartTime = System.currentTimeMillis();
        MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.addToCartButtonXpath));
        addToCartButton.click();
        long CheckingAddToCartButtonEndTime = System.currentTimeMillis();
        long CheckingAddToCartButtonTotalTime = CheckingAddToCartButtonEndTime - CheckingAddToCartButtonStartTime;
        System.out.println("Checking Add To Cart Button: " + CheckingAddToCartButtonTotalTime + " millisecond");

        long checkingGoToCartButtonStartTime = System.currentTimeMillis();
        MobileElement goToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.goToCartButtonXpath));
        goToCartButton.click();
        long checkingGoToCartButtonEndTime = System.currentTimeMillis();
        long checkingGoToCartButtonTotalTime = checkingGoToCartButtonEndTime - checkingGoToCartButtonStartTime;
        System.out.println("Checking Go To Cart Button: " + checkingGoToCartButtonTotalTime + " millisecond");

        long checkingTrashBinButtonStartTime = System.currentTimeMillis();
        MobileElement trashBinButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastTrashBinButtonXpath));
        trashBinButton.click();
        long checkingTrashBinButtonEndTime = System.currentTimeMillis();
        long checkingTrashBinButtonTotalTime = checkingTrashBinButtonEndTime - checkingTrashBinButtonStartTime;
        System.out.println("Checking Trash Bin Button: " + checkingTrashBinButtonTotalTime + " millisecond");

        long checkingRemoveProductFromCartButtonStartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.removeProductFromCartButtonXpath));
        removeProductFromCartButton.click();
        long checkingRemoveProductFromCartButtonEndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButtonTotalTime = checkingRemoveProductFromCartButtonEndTime - checkingRemoveProductFromCartButtonStartTime;
        System.out.println("Checking Remove Product From Cart Button: " + checkingRemoveProductFromCartButtonTotalTime + " millisecond");

        long checkingTrashBinButton2StartTime = System.currentTimeMillis();
        MobileElement trashBinButton2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastTrashBinButtonXpath));
        trashBinButton2.click();
        long checkingTrashBinButton2EndTime = System.currentTimeMillis();
        long checkingTrashBinButton2TotalTime = checkingTrashBinButton2EndTime - checkingTrashBinButton2StartTime;
        System.out.println("Checking Trash Bin Button" + checkingTrashBinButton2TotalTime + " millisecond");

        long checkingRemoveProductFromCartButton2StartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.removeProductFromCartButtonXpath));
        removeProductFromCartButton2.click();
        long checkingRemoveProductFromCartButton2EndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButton2TotalTime = checkingRemoveProductFromCartButton2EndTime - checkingRemoveProductFromCartButton2StartTime;
        System.out.println("Checking Remove Product From Cart Button: " + checkingRemoveProductFromCartButton2TotalTime + " millisecond");

        long checkingStartShoppingButtonStartTime = System.currentTimeMillis();
        MobileElement startShoppingButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.startShoppingButtonXpath));
        startShoppingButton.click();
        long checkingStartShoppingButtonEndTime = System.currentTimeMillis();
        long checkingStartShoppingButtonTotalTime = checkingStartShoppingButtonEndTime - checkingStartShoppingButtonStartTime;
        System.out.println("Checking Start Shopping Button: " + checkingStartShoppingButtonTotalTime + " millisecond");

        long popularRestaurantTestEndTime = System.currentTimeMillis();
        long popularRestaurantTestTotalTime = popularRestaurantTestEndTime - popularRestaurantTestStartTime;
        System.out.println("Popular Restaurant Test: " + popularRestaurantTestTotalTime + " millisecond"); }
/*
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long popularRestaurantTestStartTime = System.currentTimeMillis();

        long clickingSeeAllButtonStartTime = System.currentTimeMillis();//düzelt
        MobileElement seeAllButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.seeAllPopularRestaurantsButtonXpath));
        seeAllButton.click();
        long clickingSeeAllButtonEndTime = System.currentTimeMillis();
        long clickingSeeAllButtonTotalTime = clickingSeeAllButtonEndTime - clickingSeeAllButtonStartTime;
        System.out.println("Checking See All Button: " + clickingSeeAllButtonTotalTime + " millisecond");

        Thread.sleep(600);
        long closingTheSearchFieldStartTime = System.currentTimeMillis();
        MobileElement closingTheSearchField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.closingTheSearchFieldXpath));
        closingTheSearchField.click();
        long closingTheSearchFieldEndTime = System.currentTimeMillis();
        long closingTheSearchFieldTotalTime = closingTheSearchFieldEndTime - closingTheSearchFieldStartTime;
        System.out.println("Closing The Search Field: " + closingTheSearchFieldTotalTime + " millisecond");

        Thread.sleep(1000);
        TouchAction scrollUpToPopularRestaurants = new TouchAction<>(driver)
                .press(PointOption.point(527, 1695))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(538, 637))
                .release()
                .perform();

        Thread.sleep(500);
        long clickingPhJahraButtonStartTime = System.currentTimeMillis();
        MobileElement phJahraButtonButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.phJahraButtonXpath));
        phJahraButtonButton.click();
        long clickingPhJahraButtonEndTime = System.currentTimeMillis();
        long clickingPhJahraButtonTotalTime = clickingPhJahraButtonEndTime - clickingPhJahraButtonStartTime;
        System.out.println("Checking PhJahra Button: " + clickingPhJahraButtonTotalTime + " millisecond");

        Thread.sleep(1000);
        TouchAction scrollUpToClickOnPhJahra = new TouchAction<>(driver)
                .press(PointOption.point(895, 2664))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(847, 1614))
                .release()
                .perform();

        long clickingCouplesFeastFavoriteButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastFavoriteButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastFavoriteButtonXpath));
        couplesFeastFavoriteButton.click();
        long clickingCouplesFeastFavoriteButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastFavoriteButtonTotalTime = clickingCouplesFeastFavoriteButtonEndTime - clickingCouplesFeastFavoriteButtonStartTime;
        System.out.println("Clicking Couples Feast Favorite Button: " + clickingCouplesFeastFavoriteButtonTotalTime + " millisecond");

        long clickingCouplesFeastButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastButtonXpath));
        couplesFeastButton.click();
        long clickingCouplesFeastButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastButtonTotalTime = clickingCouplesFeastButtonEndTime - clickingCouplesFeastButtonStartTime;
        System.out.println("Clicking Couples Feast Button: " + clickingCouplesFeastButtonTotalTime + " millisecond");

        Thread.sleep(1000);
        TouchAction scrollUpToClickOnProductDetails = new TouchAction<>(driver)
                .press(PointOption.point(551, 1485))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(571, 771))
                .release()
                .perform();

        long clickingPanRadioButtonStartTime = System.currentTimeMillis();
        MobileElement panRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.panRadioButtonXpath));
        panRadioButton.click();
        long clickingPanRadioButtonEndTime = System.currentTimeMillis();
        long clickingPanRadioButtonTotalTime = clickingPanRadioButtonEndTime - clickingPanRadioButtonStartTime;
        System.out.println("Clicking Pan Radio Button: " + clickingPanRadioButtonTotalTime + " millisecond");

        long clickingUltimateCheeseRadioButtonStartTime = System.currentTimeMillis();
        MobileElement ultimateCheeseRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.ultimateCheeseRadioButtonXpath));
        ultimateCheeseRadioButton.click();
        long checkingUltimateCheeseRadioButtonEndTime = System.currentTimeMillis();
        long checkingUltimateCheeseRadioButtonTotalTime = checkingUltimateCheeseRadioButtonEndTime - clickingUltimateCheeseRadioButtonStartTime;
        System.out.println("Clicking Ultimate Cheese Radio Button: " + checkingUltimateCheeseRadioButtonTotalTime + " millisecond");

        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails2 = new TouchAction<>(driver)
                .press(PointOption.point(551, 1485))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(571, 771))
                .release()
                .perform();

        long clickingMacaroniSaladRadioButtonStartTime = System.currentTimeMillis();
        MobileElement macaroniSaladRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.macaroniSaladRadioButtonXpath));
        macaroniSaladRadioButton.click();
        long clickingMacaroniSaladRadioButtonEndTime = System.currentTimeMillis();
        long clickingMacaroniSaladRadioButtonTotalTime = clickingMacaroniSaladRadioButtonEndTime - clickingMacaroniSaladRadioButtonStartTime;
        System.out.println("Clicking Macaroni Salad Radio Button: " + clickingMacaroniSaladRadioButtonTotalTime + " millisecond");

        long clickingMirindaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement mirindaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.mirindaRadioButtonXapth));
        mirindaRadioButton.click();
        long clickingMirindaRadioButtonEndTime = System.currentTimeMillis();
        long clickingMirindaRadioButtonTotalTime = clickingMirindaRadioButtonEndTime - clickingMirindaRadioButtonStartTime;
        System.out.println("Clicking Mirinda Radio Button: " + clickingMirindaRadioButtonTotalTime + " millisecond");

        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails3 = new TouchAction<>(driver)
                .press(PointOption.point(512, 1431))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(509, 615))
                .release()
                .perform();

        long clickingSevenUpRadioButtonStartTime = System.currentTimeMillis();
        MobileElement sevenUpRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.sevenUpRadioButtonXapth));
        sevenUpRadioButton.click();
        long clickingSevenUpRadioButtonEndTime = System.currentTimeMillis();
        long clickingSevenUpRadioButtonTotalTime = clickingSevenUpRadioButtonEndTime - clickingSevenUpRadioButtonStartTime;
        System.out.println("Clicking Seven Up Radio Button: " + clickingSevenUpRadioButtonTotalTime + " millisecond");

        Thread.sleep(500);
        long CheckingAddToCartButtonStartTime = System.currentTimeMillis();
        MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.addToCartButtonXpath));
        addToCartButton.click();
        long CheckingAddToCartButtonEndTime = System.currentTimeMillis();
        long CheckingAddToCartButtonTotalTime = CheckingAddToCartButtonEndTime - CheckingAddToCartButtonStartTime;
        System.out.println("Checking Add To Cart Button: " + CheckingAddToCartButtonTotalTime + " millisecond");

        long checkingGoToCartButtonStartTime = System.currentTimeMillis();
        MobileElement goToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.goToCartButtonXpath));
        goToCartButton.click();
        long checkingGoToCartButtonEndTime = System.currentTimeMillis();
        long checkingGoToCartButtonTotalTime = checkingGoToCartButtonEndTime - checkingGoToCartButtonStartTime;
        System.out.println("Checking Go To Cart Button: " + checkingGoToCartButtonTotalTime + " millisecond");

        long checkingTrashBinButtonStartTime = System.currentTimeMillis();
        MobileElement trashBinButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastTrashBinButtonXpath));
        trashBinButton.click();
        long checkingTrashBinButtonEndTime = System.currentTimeMillis();
        long checkingTrashBinButtonTotalTime = checkingTrashBinButtonEndTime - checkingTrashBinButtonStartTime;
        System.out.println("Checking Trash Bin Button: " + checkingTrashBinButtonTotalTime + " millisecond");

        long checkingRemoveProductFromCartButtonStartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.removeProductFromCartButtonXpath));
        removeProductFromCartButton.click();
        long checkingRemoveProductFromCartButtonEndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButtonTotalTime = checkingRemoveProductFromCartButtonEndTime - checkingRemoveProductFromCartButtonStartTime;
        System.out.println("Checking Remove Product From Cart Button: " + checkingRemoveProductFromCartButtonTotalTime + " millisecond");

        long checkingTrashBinButton2StartTime = System.currentTimeMillis();
        MobileElement trashBinButton2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.couplesFeastTrashBinButtonXpath));
        trashBinButton2.click();
        long checkingTrashBinButton2EndTime = System.currentTimeMillis();
        long checkingTrashBinButton2TotalTime = checkingTrashBinButton2EndTime - checkingTrashBinButton2StartTime;
        System.out.println("Checking Trash Bin Button" + checkingTrashBinButton2TotalTime + " millisecond");

        long checkingRemoveProductFromCartButton2StartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.removeProductFromCartButtonXpath));
        removeProductFromCartButton2.click();
        long checkingRemoveProductFromCartButton2EndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButton2TotalTime = checkingRemoveProductFromCartButton2EndTime - checkingRemoveProductFromCartButton2StartTime;
        System.out.println("Checking Remove Product From Cart Button: " + checkingRemoveProductFromCartButton2TotalTime + " millisecond");

        long checkingStartShoppingButtonStartTime = System.currentTimeMillis();
        MobileElement startShoppingButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.startShoppingButtonXpath));
        startShoppingButton.click();
        long checkingStartShoppingButtonEndTime = System.currentTimeMillis();
        long checkingStartShoppingButtonTotalTime = checkingStartShoppingButtonEndTime - checkingStartShoppingButtonStartTime;
        System.out.println("Checking Start Shopping Button: " + checkingStartShoppingButtonTotalTime + " millisecond");

        long popularRestaurantTestEndTime = System.currentTimeMillis();
        long popularRestaurantTestTotalTime = popularRestaurantTestEndTime - popularRestaurantTestStartTime;
        System.out.println("Popular Restaurant Test: " + popularRestaurantTestTotalTime + " millisecond"); }
 */
    }
