package tests;

import com.google.common.collect.ImmutableMap;
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
    private WebDriverWait wait;
    private Random random = new Random();

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
        cap.setCapability("WaitDuration","30000");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @Test(priority = 1)
    public void signUpAndPurchase() throws InterruptedException {
        // Sign Up işlemi
        SignUpConstructorOlarakKullanacagim signUp = new SignUpConstructorOlarakKullanacagim(driver, wait);
        signUp.testUserSignUp();
        signUp.testOTPVerification();

        // Kuveyt Uluslararası Havalimanı seçimi
        MobileElement searchInput = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@resource-id='text-input-outline']")));
        searchInput.click();
        searchInput.sendKeys("Kuveyt Uluslararasi");
        TimeUnit.MILLISECONDS.sleep(500);

        MobileElement firstItem = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Kuveyt Uluslararası Havalimanı, Ghazali Street, Kuwait']")));
        firstItem.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "Use This Location" butonuna tıkla
        MobileElement useThisLocationButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Use This Location']")));
        useThisLocationButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "See All" butonuna tıkla
        MobileElement seeAllButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='See All ']")));
        seeAllButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // İlk restorana tıkla
        MobileElement firstRestaurant = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='restaurant-list-restaurant-card-0']/android.view.ViewGroup[1]")));
        firstRestaurant.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // Ürün seçimi
        MobileElement firstProduct = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")));
        firstProduct.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // Radio buttonları seç
        selectRadioButton("//android.widget.Button[@content-desc='product-details-modifier-item-1-0']");
        selectRadioButton("//android.widget.Button[@content-desc='product-details-modifier-item-2-0']");
        selectRadioButton("//android.widget.Button[@content-desc='product-details-modifier-item-3-0']");
        selectRadioButton("//android.widget.Button[@content-desc='product-details-modifier-item-4-0']");

        // "Add to Cart" butonuna tıkla
        MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='product-add-to-cart-button']")));
        addToCartButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "Go to Cart" butonuna tıkla
        MobileElement goToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Go to Cart']")));
        goToCartButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "Go to Checkout" butonuna tıkla
        MobileElement goToCheckoutButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Go to checkout']")));
        goToCheckoutButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // Yeni adres ekle
        MobileElement addNewAddressButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Add New Address ']")));
        addNewAddressButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "Use This Location" butonuna tıkla
        MobileElement useLocationButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Use This Location']")));
        useLocationButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "Building Name" alanına rastgele isim gir
        MobileElement buildingNameField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Building name*']")));
        buildingNameField.click();
        buildingNameField.sendKeys(generateRandomString(10));
        driver.findElement(By.xpath("//android.widget.ScrollView")).click();
        TimeUnit.MILLISECONDS.sleep(500);

        // Sayfayı kaydır
        scrollDown();

        // "Save Address" butonuna tıkla
        MobileElement saveAddressButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Save Address']")));
        saveAddressButton.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // Sayfayı kaydır ve "Cash On Delivery" seçeneğine tıkla
        scrollDown();
        MobileElement cashOnDeliveryOption = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Cash On Delivery']")));
        cashOnDeliveryOption.click();
        TimeUnit.MILLISECONDS.sleep(500);

        // "Complete Purchase" butonuna tıkla
        MobileElement completePurchaseButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Complete Purchase']")));
        completePurchaseButton.click();
        TimeUnit.MILLISECONDS.sleep(500);
    }

    private void selectRadioButton(String xpath) throws InterruptedException {
        MobileElement radioButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath + "/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")));
        radioButton.click();
        TimeUnit.MILLISECONDS.sleep(500);
    }

    private void scrollDown() {
        driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
