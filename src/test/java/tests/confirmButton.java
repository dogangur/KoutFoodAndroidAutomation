package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class confirmButton {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;  // MobileAppXpath nesnesi

    public confirmButton(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();  // MobileAppXpath nesnesi oluşturuluyor
    }

    public void clickConfirm() {
        MobileElement confirmButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.confirmButtonXpath));
        confirmButton.click();
    }
}
