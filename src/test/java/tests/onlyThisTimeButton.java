package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class onlyThisTimeButton {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;

    public onlyThisTimeButton(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();
    }

    public void clickOnlyThisTime() {
        MobileElement onlyThisTimeButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.OnlyThisTimelocationButton));
        onlyThisTimeButton.click();
    }
}
