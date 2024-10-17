package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class firstNameField {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    private By firstNameFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-firstname-input']");

    public firstNameField(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterFirstName(String firstName) {
        try {
            MobileElement firstNameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFieldXpath));
            firstNameField.sendKeys(firstName);
            System.out.println("First name entered: " + firstName);
        } catch (Exception e) {
            System.out.println("First name field not found: " + e.getMessage());
        }
    }
}
