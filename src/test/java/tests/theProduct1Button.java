package tests;

import constants.MobileAppXpath;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class theProduct1Button {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private MobileAppXpath xpath;  // MobileAppXpath nesnesi oluşturuluyor

    public theProduct1Button(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.xpath = new MobileAppXpath();  // MobileAppXpath nesnesi burada oluşturuluyor
    }

    public void clickFirstProduct() {
        MobileElement productButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(xpath.theProduct1ButtonXpath));
        productButton.click();
    }
}
