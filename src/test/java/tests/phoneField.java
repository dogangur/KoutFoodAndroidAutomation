package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class phoneField {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    private By phoneFieldXpath = By.xpath("//android.widget.EditText[@resource-id='country-picker-phone-input']");

    public phoneField(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterPhoneNumber(String phoneNumber) {
        try {
            MobileElement phoneField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFieldXpath));
            phoneField.sendKeys(phoneNumber);
            System.out.println("Phone number entered: " + phoneNumber);
        } catch (Exception e) {
            System.out.println("Phone field not found: " + e.getMessage());
        }
    }
}
