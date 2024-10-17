package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addToCartButton2 {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    public addToCartButton2(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();  // MobileAppXpath nesnesi burada oluşturuluyor
    }

    public void clickAddToCart2() {
        MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.addToCartButton2Xpath));
        addToCartButton.click();
    }
}
