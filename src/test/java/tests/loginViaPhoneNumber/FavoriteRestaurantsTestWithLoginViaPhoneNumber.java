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

public class FavoriteRestaurantsTestWithLoginViaPhoneNumber {

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

        Thread.sleep(8000);
        TouchAction scrollUpToClickOnFavoriteRestaurants = new TouchAction<>(driver)
                .press(PointOption.point(572, 190))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(668, 668))
                .release()
                .perform();

        long loginTestEndTime = System.currentTimeMillis();
        long loginTestTotalTime = loginTestEndTime - loginTestStartTime;
        System.out.println("login Total Test: " + loginTestTotalTime + " millisecond");

    }

    @Test(priority = 3)
    void FavoriteRestaurantTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long favoriteRestaurantTestStartTime = System.currentTimeMillis();

        long clickOnTheSeeAllFavoriteRestaurantsButtonStartTime = System.currentTimeMillis();
        MobileElement seeAllFavoriteRestaurantsButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.seeAllFavoriteRestaurantsButtonXpath));
        seeAllFavoriteRestaurantsButton.click();
        long seeAllFavoriteRestaurantsButtonEndTime = System.currentTimeMillis();
        long seeAllFavoriteRestaurantsButtonTotalTime = seeAllFavoriteRestaurantsButtonEndTime - clickOnTheSeeAllFavoriteRestaurantsButtonStartTime;
        System.out.println("Clicking The See All Favorite Restaurants Button: " + seeAllFavoriteRestaurantsButtonTotalTime + " millisecond");

        Thread.sleep(600);
        long closingTheSearchFieldStartTime = System.currentTimeMillis();
        MobileElement closingTheSearchField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.closingTheSearchFieldXpath));
        closingTheSearchField.click();
        long closingTheSearchFieldEndTime = System.currentTimeMillis();
        long closingTheSearchFieldTotalTime = closingTheSearchFieldEndTime - closingTheSearchFieldStartTime;
        System.out.println("Closing The Search Field: " + closingTheSearchFieldTotalTime + " millisecond");


        Thread.sleep(1000);
        TouchAction scrollUpToBurgerKing = new TouchAction<>(driver)
                .press(PointOption.point(712, 2119))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(721, 668))
                .release()
                .perform();

        long clickingBurgerKingButtonStartTime = System.currentTimeMillis();
        MobileElement burgerKingButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.burgerKingButtonXpath));
        burgerKingButton.click();
        long clickingBurgerKingButtonEndTime = System.currentTimeMillis();
        long clickingBurgerKingButtonTotalTime = clickingBurgerKingButtonEndTime - clickingBurgerKingButtonStartTime;
        System.out.println("Checking Burger King Button : " + clickingBurgerKingButtonTotalTime + " millisecond");

        Thread.sleep(4000);
        new TouchAction<>(driver)
                .press(PointOption.point(754, 2040))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(793, 1029))
                .release()
                .perform();

        long clickingCouplesFeastFavoriteButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastFavoriteButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingFavoriteButtonXpath));
        couplesFeastFavoriteButton.click();
        long clickingCouplesFeastFavoriteButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastFavoriteButtonTotalTime = clickingCouplesFeastFavoriteButtonEndTime - clickingCouplesFeastFavoriteButtonStartTime;
        System.out.println("Clicking Couples Feast Favorite Button: " + clickingCouplesFeastFavoriteButtonTotalTime + " millisecond");

        long clickingJuniorBigKingMealButtonStartTime = System.currentTimeMillis();
        MobileElement juniorBigKingMealButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingMealButtonXpath));
        juniorBigKingMealButton.click();
        long clickingJuniorBigKingMealButtonEndTime = System.currentTimeMillis();
        long clickingJuniorBigKingMealButtonTotalTime = clickingJuniorBigKingMealButtonEndTime - clickingJuniorBigKingMealButtonStartTime;
        System.out.println("Clicking Junior Big King Meal Button: " + clickingJuniorBigKingMealButtonTotalTime + " millisecond");

        long clickingGoMegaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement goMegaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.goMegaRadioButtonXpath));
        goMegaRadioButton.click();
        long clickingGoMegaButtonEndTime = System.currentTimeMillis();
        long clickingGoMegaButtonTotalTime = clickingGoMegaButtonEndTime - clickingGoMegaRadioButtonStartTime;
        System.out.println("Clicking Go Mega Radio Button: " + clickingGoMegaButtonTotalTime + " millisecond");

        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails2 = new TouchAction<>(driver)
                .press(PointOption.point(567, 1899))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(613, 1062))
                .release()
                .perform();

        long clickingOrionRingsRadioButtonStartTime = System.currentTimeMillis();
        MobileElement orionRingsRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.orionRingsRadioButtonXpath));
        orionRingsRadioButton.click();
        long checkingOrionRingsRadioButtonEndTime = System.currentTimeMillis();
        long checkingOrionRingsRadioButtonTotalTime = checkingOrionRingsRadioButtonEndTime - clickingOrionRingsRadioButtonStartTime;
        System.out.println("Clicking Orion Rings Radio Button: " + checkingOrionRingsRadioButtonTotalTime + " millisecond");

//
        long clickingCocaColaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement cocaColaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.cocaColaRadioButtonXpath));
        cocaColaRadioButton.click();
        long clickingCocaColaRadioButtonEndTime = System.currentTimeMillis();
        long clickingCocaColaRadioButtonTotalTime = clickingCocaColaRadioButtonEndTime - clickingCocaColaRadioButtonStartTime;
        System.out.println("Clicking Coca Cola Radio Button: " + clickingCocaColaRadioButtonTotalTime + " millisecond");

        long clickingAddCheeseRadioButtonStartTime = System.currentTimeMillis();
        MobileElement addCheeseRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.addCheeseRadioButtonXpath));
        addCheeseRadioButton.click();
        long clickingAddCheeseRadioButtonEndTime = System.currentTimeMillis();
        long clickingAddCheeseRadioButtonTotalTime = clickingAddCheeseRadioButtonEndTime - clickingAddCheeseRadioButtonStartTime;
        System.out.println("Clicking Add Cheese Radio Button: " + clickingAddCheeseRadioButtonTotalTime + " millisecond");

        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails3 = new TouchAction<>(driver)
                .press(PointOption.point(622, 1840))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(609, 984))
                .release()
                .perform();

        long clickingBbqSauceRadioButtonStartTime = System.currentTimeMillis();
        MobileElement bbqSauceRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.bbqSauceRadioButtonXpath));
        bbqSauceRadioButton.click();
        long clickingBbqSauceRadioButtonEndTime = System.currentTimeMillis();
        long clickingBbqSauceRadioButtonTotalTime = clickingBbqSauceRadioButtonEndTime - clickingBbqSauceRadioButtonStartTime;
        System.out.println("Clicking Bbq Sauce Radio Button: " + clickingBbqSauceRadioButtonTotalTime + " millisecond");

        long clickingPlantBasedWhopperRadioButtonStartTime = System.currentTimeMillis();
        MobileElement plantBasedWhopperRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.plantBasedWhopperRadioButtonXpath));
        plantBasedWhopperRadioButton.click();
        long clickingPlantBasedWhopperRadioButtonEndTime = System.currentTimeMillis();
        long clickingPlantBasedWhopperRadioButtonTotalTime = clickingPlantBasedWhopperRadioButtonEndTime - clickingPlantBasedWhopperRadioButtonStartTime;
        System.out.println("Clicking Plant Based Whopper Radio Button: " + clickingPlantBasedWhopperRadioButtonTotalTime + " millisecond");

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
        MobileElement trashBinButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingMealTrashBinButtonXpath));
        trashBinButton.click();
        long checkingTrashBinButtonEndTime = System.currentTimeMillis();
        long checkingTrashBinButtonTotalTime = checkingTrashBinButtonEndTime - checkingTrashBinButtonStartTime;
        System.out.println("Checking Go To Cart Button: " + checkingTrashBinButtonTotalTime + " millisecond");

        long checkingRemoveProductFromCartButtonStartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.removeProductFromCartButtonXpath));
        removeProductFromCartButton.click();
        long checkingRemoveProductFromCartButtonEndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButtonTotalTime = checkingRemoveProductFromCartButtonEndTime - checkingRemoveProductFromCartButtonStartTime;
        System.out.println("Checking Remove Product From Cart Button: " + checkingRemoveProductFromCartButtonTotalTime + " millisecond");

        long checkingTrashBinButton2StartTime = System.currentTimeMillis();
        MobileElement trashBinButton2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingMealTrashBinButtonXpath));
        trashBinButton2.click();
        long checkingTrashBinButton2EndTime = System.currentTimeMillis();
        long checkingTrashBinButton2TotalTime = checkingTrashBinButton2EndTime - checkingTrashBinButton2StartTime;
        System.out.println("Checking Go To Cart Button: " + checkingTrashBinButton2TotalTime + " millisecond");

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

        long favoriteRestaurantTestEndTime = System.currentTimeMillis();
        long favoriteRestaurantTestTotalTime = favoriteRestaurantTestEndTime - favoriteRestaurantTestStartTime;
        System.out.println("Favorite Restaurant Total Test: " + favoriteRestaurantTestTotalTime + " millisecond");
    }
/*
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        long favoriteRestaurantTestStartTime = System.currentTimeMillis();

        Thread.sleep(1000);
        long clickOnTheSeeAllFavoriteRestaurantsButtonStartTime = System.currentTimeMillis();
        MobileElement seeAllFavoriteRestaurantsButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.seeAllFavoriteRestaurantsButtonXpath));
        seeAllFavoriteRestaurantsButton.click();
        long seeAllFavoriteRestaurantsButtonEndTime = System.currentTimeMillis();
        long seeAllFavoriteRestaurantsButtonTotalTime = seeAllFavoriteRestaurantsButtonEndTime - clickOnTheSeeAllFavoriteRestaurantsButtonStartTime;
        System.out.println("Clicking The See All Favorite Restaurants Button: " + seeAllFavoriteRestaurantsButtonTotalTime + " millisecond");

        Thread.sleep(600);
        long closingTheSearchFieldStartTime = System.currentTimeMillis();
        MobileElement closingTheSearchField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.closingTheSearchFieldXpath));
        closingTheSearchField.click();
        long closingTheSearchFieldEndTime = System.currentTimeMillis();
        long closingTheSearchFieldTotalTime = closingTheSearchFieldEndTime - closingTheSearchFieldStartTime;
        System.out.println("Closing The Search Field: " + closingTheSearchFieldTotalTime + " millisecond");

        Thread.sleep(1000);
        TouchAction scrollUpToBurgerKing = new TouchAction<>(driver)
                .press(PointOption.point(815, 2589))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(815, 1131))
                .release()
                .perform();

        long clickingBurgerKingButtonStartTime = System.currentTimeMillis();
        MobileElement burgerKingButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.burgerKingButtonXpath));
        burgerKingButton.click();
        long clickingBurgerKingButtonEndTime = System.currentTimeMillis();
        long clickingBurgerKingButtonTotalTime = clickingBurgerKingButtonEndTime - clickingBurgerKingButtonStartTime;
        System.out.println("Checking Burger King Button : " + clickingBurgerKingButtonTotalTime + " millisecond");

        Thread.sleep(2000);
        new TouchAction<>(driver)
                .press(PointOption.point(927, 2718))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(879, 1313))
                .release()
                .perform();

        long clickingCouplesFeastFavoriteButtonStartTime = System.currentTimeMillis();
        MobileElement couplesFeastFavoriteButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingFavoriteButtonXpath));
        couplesFeastFavoriteButton.click();
        long clickingCouplesFeastFavoriteButtonEndTime = System.currentTimeMillis();
        long clickingCouplesFeastFavoriteButtonTotalTime = clickingCouplesFeastFavoriteButtonEndTime - clickingCouplesFeastFavoriteButtonStartTime;
        System.out.println("Clicking Couples Feast Favorite Button: " + clickingCouplesFeastFavoriteButtonTotalTime + " millisecond");

        long clickingJuniorBigKingMealButtonStartTime = System.currentTimeMillis();
        MobileElement juniorBigKingMealButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingMealButtonXpath));
        juniorBigKingMealButton.click();
        long clickingJuniorBigKingMealButtonEndTime = System.currentTimeMillis();
        long clickingJuniorBigKingMealButtonTotalTime = clickingJuniorBigKingMealButtonEndTime - clickingJuniorBigKingMealButtonStartTime;
        System.out.println("Clicking Junior Big King Meal Button: " + clickingJuniorBigKingMealButtonTotalTime + " millisecond");

        long clickingGoMegaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement goMegaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.goMegaRadioButtonXpath));
        goMegaRadioButton.click();
        long clickingGoMegaButtonEndTime = System.currentTimeMillis();
        long clickingGoMegaButtonTotalTime = clickingGoMegaButtonEndTime - clickingGoMegaRadioButtonStartTime;
        System.out.println("Clicking Go Mega Radio Button: " + clickingGoMegaButtonTotalTime + " millisecond");

        long clickingOrionRingsRadioButtonStartTime = System.currentTimeMillis();
        MobileElement orionRingsRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.orionRingsRadioButtonXpath));
        orionRingsRadioButton.click();
        long checkingOrionRingsRadioButtonEndTime = System.currentTimeMillis();
        long checkingOrionRingsRadioButtonTotalTime = checkingOrionRingsRadioButtonEndTime - clickingOrionRingsRadioButtonStartTime;
        System.out.println("Clicking Orion Rings Radio Button: " + checkingOrionRingsRadioButtonTotalTime + " millisecond");

        Thread.sleep(800);
        TouchAction scrollUpToClickOnProductDetails2 = new TouchAction<>(driver)
                .press(PointOption.point(761, 2353))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(751, 493))
                .release()
                .perform();

        long clickingCocaColaRadioButtonStartTime = System.currentTimeMillis();
        MobileElement cocaColaRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.cocaColaRadioButtonXpath));
        cocaColaRadioButton.click();
        long clickingCocaColaRadioButtonEndTime = System.currentTimeMillis();
        long clickingCocaColaRadioButtonTotalTime = clickingCocaColaRadioButtonEndTime - clickingCocaColaRadioButtonStartTime;
        System.out.println("Clicking Coca Cola Radio Button: " + clickingCocaColaRadioButtonTotalTime + " millisecond");

        long clickingAddCheeseRadioButtonStartTime = System.currentTimeMillis();
        MobileElement addCheeseRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.addCheeseRadioButtonXpath));
        addCheeseRadioButton.click();
        long clickingAddCheeseRadioButtonEndTime = System.currentTimeMillis();
        long clickingAddCheeseRadioButtonTotalTime = clickingAddCheeseRadioButtonEndTime - clickingAddCheeseRadioButtonStartTime;
        System.out.println("Clicking Add Cheese Radio Button: " + clickingAddCheeseRadioButtonTotalTime + " millisecond");

        long clickingBbqSauceRadioButtonStartTime = System.currentTimeMillis();
        MobileElement bbqSauceRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.bbqSauceRadioButtonXpath));
        bbqSauceRadioButton.click();
        long clickingBbqSauceRadioButtonEndTime = System.currentTimeMillis();
        long clickingBbqSauceRadioButtonTotalTime = clickingBbqSauceRadioButtonEndTime - clickingBbqSauceRadioButtonStartTime;
        System.out.println("Clicking Bbq Sauce Radio Button: " + clickingBbqSauceRadioButtonTotalTime + " millisecond");

        long clickingPlantBasedWhopperRadioButtonStartTime = System.currentTimeMillis();
        MobileElement plantBasedWhopperRadioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.plantBasedWhopperRadioButtonXpath));
        plantBasedWhopperRadioButton.click();
        long clickingPlantBasedWhopperRadioButtonEndTime = System.currentTimeMillis();
        long clickingPlantBasedWhopperRadioButtonTotalTime = clickingPlantBasedWhopperRadioButtonEndTime - clickingPlantBasedWhopperRadioButtonStartTime;
        System.out.println("Clicking Plant Based Whopper Radio Button: " + clickingPlantBasedWhopperRadioButtonTotalTime + " millisecond");

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
        MobileElement trashBinButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingMealTrashBinButtonXpath));
        trashBinButton.click();
        long checkingTrashBinButtonEndTime = System.currentTimeMillis();
        long checkingTrashBinButtonTotalTime = checkingTrashBinButtonEndTime - checkingTrashBinButtonStartTime;
        System.out.println("Checking Go To Cart Button: " + checkingTrashBinButtonTotalTime + " millisecond");

        long checkingRemoveProductFromCartButtonStartTime = System.currentTimeMillis();
        MobileElement removeProductFromCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.removeProductFromCartButtonXpath));
        removeProductFromCartButton.click();
        long checkingRemoveProductFromCartButtonEndTime = System.currentTimeMillis();
        long checkingRemoveProductFromCartButtonTotalTime = checkingRemoveProductFromCartButtonEndTime - checkingRemoveProductFromCartButtonStartTime;
        System.out.println("Checking Remove Product From Cart Button: " + checkingRemoveProductFromCartButtonTotalTime + " millisecond");

        long checkingTrashBinButton2StartTime = System.currentTimeMillis();
        MobileElement trashBinButton2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_appXpath.juniorBigKingMealTrashBinButtonXpath));
        trashBinButton2.click();
        long checkingTrashBinButton2EndTime = System.currentTimeMillis();
        long checkingTrashBinButton2TotalTime = checkingTrashBinButton2EndTime - checkingTrashBinButton2StartTime;
        System.out.println("Checking Go To Cart Button: " + checkingTrashBinButton2TotalTime + " millisecond");

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

        long favoriteRestaurantTestEndTime = System.currentTimeMillis();
        long favoriteRestaurantTestTotalTime = favoriteRestaurantTestEndTime - favoriteRestaurantTestStartTime;
        System.out.println("Favorite Restaurant Total Test: " + favoriteRestaurantTestTotalTime + " millisecond");
    }
    */

}
