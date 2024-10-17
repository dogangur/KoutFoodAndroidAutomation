package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signUpButton {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    public signUpButton(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();
    }

    public void clickSignUp() {
        MobileElement signUpButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.signUpButtonXpath));
        signUpButton.click();
    }
}
