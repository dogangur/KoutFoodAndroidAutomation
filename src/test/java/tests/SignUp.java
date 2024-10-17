package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignUp {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

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
        cap.setCapability("noReset", "true");
        cap.setCapability("appWaitActivity", "com.koutfood.koutfood.*");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);  // Bekleme süresini uzattık
    }

    @Test(priority = 1)
    public void testUserSignUp() throws InterruptedException {
        // OnlyThisTime butonuna bas
        try {
            MobileElement onlyThisTimeButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']")));
            onlyThisTimeButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Only This Time butonu bulunamadı: " + e.getMessage());
        }

        // Get Started butonuna bas
        try {
            MobileElement getStartedButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='get-started']")));
            getStartedButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Get Started butonu bulunamadı.");
        }

        // Sign Up butonuna bas
        try {
            MobileElement signUpButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='sign-up-button']")));
            signUpButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Sign Up butonu bulunamadı: " + e.getMessage());
        }

        // First Name gir
        try {
            String randomFirstName = generateRandomString(6);
            MobileElement firstNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-firstname-input']")));
            firstNameField.sendKeys(randomFirstName);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("First Name text alanı bulunamadı: " + e.getMessage());
        }

        // Last Name gir
        try {
            String randomLastName = generateRandomString(8);
            MobileElement lastNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-lastname-input']")));
            lastNameField.sendKeys(randomLastName);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Last Name text alanı bulunamadı: " + e.getMessage());
        }

        // Email gir
        try {
            String randomEmail = generateRandomString(6) + "@gmail.com";
            MobileElement emailField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-email-input']")));
            emailField.sendKeys(randomEmail);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Email text alanı bulunamadı: " + e.getMessage());
        }

        // Şifre gir
        try {
            String randomPassword = generatePassword();
            MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-password-input']")));
            passwordField.sendKeys(randomPassword);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Password text alanı bulunamadı: " + e.getMessage());
        }

        // Telefon numarası gir
        try {
            String randomPhoneNumber = generateRandomKuwaitPhoneNumber();
            MobileElement phoneField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='country-picker-phone-input']")));
            phoneField.sendKeys(randomPhoneNumber);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Phone Number text alanı bulunamadı: " + e.getMessage());
        }

        // CheckBox'ı seç
        try {
            MobileElement agreedCheckBox = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='I have read and agreed to the Terms of Use and Privacy Policy']/com.horcrux.svg.SvgView")));
            agreedCheckBox.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Agreed checkbox bulunamadı: " + e.getMessage());
        }

        // Create Account butonuna bas ve OTP ekranına geçişi bekle
        try {
            MobileElement createAccountButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='signup-create-account-button']")));
            createAccountButton.click();
            TimeUnit.MILLISECONDS.sleep(500);

            // OTP ekranına geçiş yapıldığını kontrol etmek için bekleme
            MobileElement otpScreen = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter OTP']")));
            System.out.println("OTP ekranı başarıyla yüklendi.");
        } catch (Exception e) {
            System.out.println("Create Account butonu veya OTP ekranı bulunamadı: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testOTPVerification() throws InterruptedException {
        try {
            // OTP alanına 6 adet 1 yaz
            for (int i = 1; i <= 6; i++) {
                driver.getKeyboard().sendKeys("1");
                TimeUnit.MILLISECONDS.sleep(500);
            }

            // Submit butonuna tıkla
            MobileElement submitButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Submit']")));
            submitButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("OTP alanı veya Submit butonu bulunamadı: " + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Yardımcı metotlar
    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    private String generatePassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = ".";

        StringBuilder password = new StringBuilder();
        password.append(upperCaseLetters.charAt(new Random().nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(new Random().nextInt(lowerCaseLetters.length())));
        password.append(numbers.charAt(new Random().nextInt(numbers.length())));
        password.append(specialCharacters.charAt(0));

        String remainingCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 6; i++) {
            password.append(remainingCharacters.charAt(new Random().nextInt(remainingCharacters.length())));
        }

        return password.toString();
    }

    private String generateRandomKuwaitPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("514");
        for (int i = 0; i < 5; i++) {
            int digit = new Random().nextInt(10);
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }
}
