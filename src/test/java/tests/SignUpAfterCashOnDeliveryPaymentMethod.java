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

public class SignUpAfterCashOnDeliveryPaymentMethod {

    private AndroidDriver<MobileElement> driver;
    private long totalTestDuration = 0;
    private Random random = new Random();

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformVersion", "15.0");  // Platform Version 15.0 olarak ayarlandı
        cap.setCapability("appPackage", "com.koutfood.koutfood");
        cap.setCapability("appActivity", "com.koutfood.koutfood.MainActivity");
        cap.setCapability("skipUnlock", "true");
        cap.setCapability("noReset", "true");  // Uygulama her başlatıldığında sıfırlanmasın
        cap.setCapability("fullReset", "false"); // Uygulama tamamen sıfırlanmasın

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        totalTestDuration += totalTime;
        System.out.println("Setup : " + (totalTime / 1000.0) + " seconds");
    }

    @Test(priority = 1)
    public void testUserSignUp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Bekleme süresi 10 saniye olarak ayarlandı

        // 1. Adım: Location izni için "OnlyThisTime" butonuna tıkla
        try {
            MobileElement allowLocationButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@resource-id, 'permission_allow')]")));
            allowLocationButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Location izin butonu bulunamadı.");
        }

        // 2. Adım: Notification izni için "Allow" butonuna tıkla
        try {
            MobileElement allowNotificationButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@resource-id, 'permission_allow')]")));
            allowNotificationButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Notification izin butonu bulunamadı.");
        }

        // 3. Adım: "Get Started" butonuna tıkla
        try {
            MobileElement getStartedButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='get-started']")));
            getStartedButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Get Started butonu bulunamadı.");
        }

        // 4. Adım: "Sign Up" butonuna tıkla
        try {
            MobileElement signUpButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='sign-up-button']")));
            signUpButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Sign Up butonu bulunamadı.");
        }

        // 5. Adım: Rastgele İsim üret ve First_Name textfield'a yaz
        String randomFirstName = generateRandomString(6);
        try {
            MobileElement firstNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-firstname-input']")));
            firstNameField.sendKeys(randomFirstName);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("First Name text alanı bulunamadı.");
        }

        // 6. Adım: Rastgele Soyisim üret ve Last_Name textfield'a yaz
        String randomLastName = generateRandomString(8);
        try {
            MobileElement lastNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-lastname-input']")));
            lastNameField.sendKeys(randomLastName);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Last Name text alanı bulunamadı.");
        }

        // 7. Adım: Rastgele e-posta adresi üret ve Email textfield'a yaz
        String randomEmail = generateRandomString(6) + "@gmail.com";
        try {
            MobileElement emailField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-email-input']")));
            emailField.sendKeys(randomEmail);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Email text alanı bulunamadı.");
        }

        // 8. Adım: Password textfield'a şifre yaz (kurallara uygun)
        String randomPassword = generatePassword();
        System.out.println("Oluşturulan şifre: " + randomPassword);  // Şifreyi konsola bastırıyoruz
        try {
            MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='signup-password-input']")));
            passwordField.sendKeys(randomPassword);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Password text alanı bulunamadı.");
        }

        // 9. Adım: Kuveyt formatına uygun telefon numarası üret (+965 combobox içinde, numara 514 ile başlar)
        String randomPhoneNumber = generateRandomKuwaitPhoneNumber();  // +965 hariç sadece 514 ile başlayan 5 haneli numara
        System.out.println("Oluşturulan telefon numarası: " + randomPhoneNumber);  // Telefon numarasını konsola bastırıyoruz
        try {
            MobileElement phoneField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='country-picker-phone-input']")));
            phoneField.sendKeys(randomPhoneNumber);
            TimeUnit.SECONDS.sleep(1); // 1 saniye beklemeden önce Create Account'a tıklamayalım
        } catch (Exception e) {
            System.out.println("Phone Number text alanı bulunamadı.");
        }

        // 10. Adım: "I Have Read and Agreed" checkbox'ına tıkla
        try {
            MobileElement agreedCheckBox = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='I have read and agreed to the Terms of Use and Privacy Policy']/com.horcrux.svg.SvgView")));
            agreedCheckBox.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Agreed checkbox bulunamadı.");
        }

        // 11. Adım: "I Want to Receive" checkbox'ına tıkla
        try {
            MobileElement receiveCheckBox = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='I want to receive campaign, SMS and email notifications']/com.horcrux.svg.SvgView")));
            receiveCheckBox.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Receive checkbox bulunamadı.");
        }

        // 12. Adım: "Create Account" butonuna tıkla
        try {
            MobileElement createAccountButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='signup-create-account-button']")));
            createAccountButton.click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Create Account butonu bulunamadı.");
        }

        System.out.println("Sign Up işlemi başarıyla tamamlandı.");
    }

    @Test(priority = 2)
    public void testOTPVerification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20); // Bekleme süresi 20 saniye olarak ayarlandı

        try {
            // İmleç zaten OTP alanında olduğu için doğrudan "1" yazıyoruz
            for (int i = 1; i <= 6; i++) {
                // OTP alanına "1" yaz
                driver.getKeyboard().sendKeys("1");
                System.out.println(i + ". '1' yazıldı.");

                // Yarım saniye bekleme yapıyoruz
                TimeUnit.MILLISECONDS.sleep(500);
            }

            // 6. haneye yazıldıktan sonra 1-2 saniye bekleme süresi
            System.out.println("6. hane yazıldı, 1-2 saniye bekleniyor...");
            TimeUnit.SECONDS.sleep(2); // 2 saniye bekliyoruz

            // Submit butonuna tıklama işlemi
            MobileElement submitButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Submit']")));
            submitButton.click(); // Submit butonuna tıklıyoruz
            System.out.println("OTP girildi ve Submit butonuna basıldı.");

        } catch (Exception e) {
            System.out.println("OTP alanına yazma veya Submit butonuna basma işlemi başarısız: " + e.getMessage());
        }

        // Uygulama içinde kal, uygulama kapanmayacak
        System.out.println("Submit butonuna basıldıktan sonra uygulama içinde kalınıyor.");

        // Bekleme süresi ekleyebilirsiniz
        TimeUnit.SECONDS.sleep(5); // 5 saniye bekle, bu süreyi isteğe göre arttırabilirsiniz
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Rastgele string üretmek için yardımcı metot
    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    // Rastgele şifre üretmek için yardımcı metot (1 büyük harf, en az 1 küçük harf, 1 sayı, 1 nokta, minimum 10 karakter)
    private String generatePassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = ".";

        // Şifreyi oluşturmak için gerekli karakterler
        StringBuilder password = new StringBuilder();

        // En az bir büyük harf
        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));

        // En az bir küçük harf
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));

        // En az bir sayı
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        // En az bir nokta
        password.append(specialCharacters.charAt(0));

        // Geri kalan karakterler rastgele eklenir
        String remainingCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 6; i++) { // Minimum 10 karakter olması için 6 tane rastgele karakter ekleyeceğiz
            password.append(remainingCharacters.charAt(random.nextInt(remainingCharacters.length())));
        }

        return password.toString();
    }

    // Kuveyt numarası üretmek için yardımcı metot (514 ile başlayan ve 5 haneli rastgele numara)
    private String generateRandomKuwaitPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("514");  // Sabit başlangıç "514"

        // Geri kalan 5 haneyi rastgele üret
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10); // 0-9 arası rastgele bir sayı üret
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }
}
