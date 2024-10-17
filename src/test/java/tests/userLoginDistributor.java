package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class userLoginDistributor {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

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
        cap.setCapability("appWaitActivity", "com.koutfood.koutfood.*");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        xpath = new MobileAppXpath();  // MobileAppXpath class'ını burada initialize ediyoruz
    }

    @Test
    public void testUserLogin() throws InterruptedException {
        // "Only This Time" butonuna tıkla
        try {
            MobileElement onlyThisTimeButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.OnlyThisTimelocationButton));
            onlyThisTimeButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Only This Time butonu bulunamadı: " + e.getMessage());
        }

        // "Get Started" butonuna tıkla
        try {
            MobileElement getStartedButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.getStartedButtonXpath));
            getStartedButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Get Started butonu bulunamadı: " + e.getMessage());
        }

        // "Login" butonuna tıkla
        try {
            MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.loginButtonXpath));
            loginButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Login butonu bulunamadı: " + e.getMessage());
        }

        // "Login via Email" butonuna tıkla
        try {
            MobileElement loginViaEmailButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.loginViaEmailButtonXpath));
            loginViaEmailButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Login via Email butonu bulunamadı: " + e.getMessage());
        }

        // Email adresi gir
        try {
            MobileElement emailTextField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.emailTextFieldXpath));
            emailTextField.sendKeys("dogan@test.com");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Email text alanı bulunamadı: " + e.getMessage());
        }

        // Şifre gir
        try {
            MobileElement passwordTextField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.passwordTextFieldXpath));
            passwordTextField.sendKeys("Sabah1903....");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Password text alanı bulunamadı: " + e.getMessage());
        }

        // "Login with Email" butonuna tıkla
        try {
            MobileElement loginWithLoginViaEmail = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.loginWithLoginViaEmailXpath));
            loginWithLoginViaEmail.click();
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Login işlemi başarıyla tamamlandı.");
        } catch (Exception e) {
            System.out.println("Login with Email butonu bulunamadı: " + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
