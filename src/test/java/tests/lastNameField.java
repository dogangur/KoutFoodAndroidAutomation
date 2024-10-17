package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lastNameField {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    private By lastNameFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-lastname-input']");

    public lastNameField(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterLastName(String lastName) {
        try {
            MobileElement lastNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFieldXpath));
            lastNameField.sendKeys(lastName);
            System.out.println("Last name entered: " + lastName);
        } catch (Exception e) {
            System.out.println("Last name field not found: " + e.getMessage());
        }
    }
}
