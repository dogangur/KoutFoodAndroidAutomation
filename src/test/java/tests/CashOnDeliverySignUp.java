package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CashOnDeliverySignUp {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");  // Gerçek cihazda uygun UDID girin
        cap.setCapability("platformVersion", "15.0");
        cap.setCapability("appPackage", "com.koutfood.koutfood");
        cap.setCapability("appActivity", "com.koutfood.koutfood.MainActivity");
        cap.setCapability("skipUnlock", "true");
        cap.setCapability("noReset", "true");
        cap.setCapability("appWaitActivity", "com.koutfood.koutfood.*");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);  // Bekleme süresi 30 saniyeye çıkarıldı
        xpath = new MobileAppXpath();  // MobileAppXpath sınıfı burada initialize ediliyor
    }

    @Test
    public void signUpAndPurchase() throws InterruptedException {
        // "Add New Address" butonuna tıklama
        try {
            MobileElement addNewAddressButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.addNewAddressButtonXpath));
            addNewAddressButton.click();
            TimeUnit.SECONDS.sleep(1);  // Bekleme süresi artırıldı
        } catch (Exception e) {
            System.out.println("Add New Address butonu bulunamadı: " + e.getMessage());
        }

        // Adres ismini girme
        try {
            MobileElement buildingNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(xpath.buildingNameFieldXpath));
            buildingNameField.sendKeys("Test Building");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Building Name alanı bulunamadı: " + e.getMessage());
        }

        // "See All" butonuna tıklama
        try {
            MobileElement seeAllButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.seeAllButtonXpath));
            seeAllButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("See All butonu bulunamadı: " + e.getMessage());
        }

        // İlk restoranı seçme
        try {
            MobileElement firstRestaurantButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.restaurantButtonXpath));
            firstRestaurantButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("İlk restoran seçilemedi: " + e.getMessage());
        }

        // Ürün seçimi
        try {
            MobileElement firstProductButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.theProduct1ButtonXpath));
            firstProductButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Ürün seçimi yapılamadı: " + e.getMessage());
        }

        // Sepete ekleme
        try {
            MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.addToCartButton1Xpath));
            addToCartButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Ürün sepete eklenemedi: " + e.getMessage());
        }

        // Sepete git
        try {
            MobileElement goToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.goToCartButtonXpath));
            goToCartButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Sepete gidilemedi: " + e.getMessage());
        }

        // Ödeme ekranına git
        try {
            MobileElement goToCheckoutButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.goToCheckoutButtonXpath));
            goToCheckoutButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Ödeme ekranına gidilemedi: " + e.getMessage());
        }

        // Kapıda ödeme seçeneğini seç
        try {
            MobileElement cashOnDeliveryButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.cashOnDeliveryButtonXpath));
            cashOnDeliveryButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Kapıda ödeme seçilemedi: " + e.getMessage());
        }

        // Satın almayı tamamla
        try {
            MobileElement completePurchaseButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.completePurchaseButtonXpath));
            completePurchaseButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Satın alma tamamlanamadı: " + e.getMessage());
        }

        // Ana sayfaya dön
        try {
            MobileElement backToHomeButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.backToHomeButtonXpath));
            backToHomeButton.click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Ana sayfaya dönülemedi: " + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
