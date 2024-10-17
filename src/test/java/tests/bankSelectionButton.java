package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bankSelectionButton {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;  // MobileAppXpath nesnesi

    public bankSelectionButton(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();  // MobileAppXpath nesnesi oluşturuluyor
    }

    public void selectBank() {
        MobileElement bankButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.bankXpath));
        bankButton.click();
    }
}
