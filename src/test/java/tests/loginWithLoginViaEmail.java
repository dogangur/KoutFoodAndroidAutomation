package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginWithLoginViaEmail {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    public loginWithLoginViaEmail(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();
    }

    public void clickLoginWithEmail() {
        MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.loginWithLoginViaEmailXpath));
        loginButton.click();
    }
}
