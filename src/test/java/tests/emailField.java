package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emailField {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    private By emailFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-email-input']");

    public emailField(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterEmail(String email) {
        try {
            MobileElement emailField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldXpath));
            emailField.sendKeys(email);
            System.out.println("Email entered: " + email);
        } catch (Exception e) {
            System.out.println("Email field not found: " + e.getMessage());
        }
    }
}
