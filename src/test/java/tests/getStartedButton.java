package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getStartedButton {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;  // MobileAppXpath nesnesi

    public getStartedButton(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();  // MobileAppXpath sınıfı nesnesi oluşturuluyor
    }

    public void clickGetStarted() {
        MobileElement getStartedButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.getStartedButtonXpath));
        getStartedButton.click();
    }
}
