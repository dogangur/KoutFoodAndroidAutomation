package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class theProduct2Button {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    public theProduct2Button(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();
    }

    public void clickProduct2() {
        MobileElement product2Button = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.theProduct2ButtonXpath));
        product2Button.click();
    }
}
