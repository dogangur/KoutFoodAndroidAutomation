package tests;

import java.util.Random;
import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SignUpConstructorOlarakKullanacagim {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    public SignUpConstructorOlarakKullanacagim(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();
    }

    public void testUserSignUp() throws InterruptedException {
        // OnlyThisTime butonuna bas
        try {
            MobileElement onlyThisTimeButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.OnlyThisTimelocationButton));
            onlyThisTimeButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Only This Time butonu bulunamadı: " + e.getMessage());
        }

        // Get Started butonuna bas
        try {
            MobileElement getStartedButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.getStartedButtonXpath));
            getStartedButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Get Started butonu bulunamadı.");
        }

        // Sign Up butonuna bas
        try {
            MobileElement signUpButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.signUpButtonXpath));
            signUpButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Sign Up butonu bulunamadı: " + e.getMessage());
        }

        // First Name gir
        try {
            String randomFirstName = generateRandomString(6);
            MobileElement firstNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.firstNameFieldXpath));
            firstNameField.sendKeys(randomFirstName);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("First Name text alanı bulunamadı: " + e.getMessage());
        }

        // Last Name gir
        try {
            String randomLastName = generateRandomString(8);
            MobileElement lastNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.lastNameFieldXpath));
            lastNameField.sendKeys(randomLastName);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Last Name text alanı bulunamadı: " + e.getMessage());
        }

        // Email gir
        try {
            String randomEmail = generateRandomString(6) + "@gmail.com";
            MobileElement emailField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.emailFieldXpath));
            emailField.sendKeys(randomEmail);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Email text alanı bulunamadı: " + e.getMessage());
        }

        // Şifre gir
        try {
            String randomPassword = generatePassword();
            MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.passwordFieldXpath));
            passwordField.sendKeys(randomPassword);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Password text alanı bulunamadı: " + e.getMessage());
        }

        // Telefon numarası gir
        try {
            String randomPhoneNumber = generateRandomKuwaitPhoneNumber();
            MobileElement phoneField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.phoneFieldXpath));
            phoneField.sendKeys(randomPhoneNumber);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Phone Number text alanı bulunamadı: " + e.getMessage());
        }

        // CheckBox'ı seç
        try {
            MobileElement agreedCheckBox = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.agreedCheckBoxXpath));
            agreedCheckBox.click();
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Agreed checkbox bulunamadı: " + e.getMessage());
        }

        // Create Account butonuna bas
        try {
            MobileElement createAccountButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.createAccountButtonXpath));
            createAccountButton.click();
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Sign Up işlemi başarıyla tamamlandı.");
        } catch (Exception e) {
            System.out.println("Create Account butonu bulunamadı: " + e.getMessage());
        }
    }

    public void testOTPVerification() throws InterruptedException {
        try {
            // OTP alanına 6 adet 1 yaz
            for (int i = 1; i <= 6; i++) {
                driver.getKeyboard().sendKeys("1");
                TimeUnit.MILLISECONDS.sleep(500);
            }

            // Submit butonuna tıkla
            MobileElement submitButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.submitButtonXpath));
            submitButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("OTP alanı veya Submit butonu bulunamadı: " + e.getMessage());
        }
    }

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
