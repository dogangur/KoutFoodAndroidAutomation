package services;

import constants.MobileAppXpath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MobileAppServices {
    private MobileAppXpath _Mobile_appXpath;

    public MobileAppServices() {
        _Mobile_appXpath = new MobileAppXpath();
    }

    private static WebDriverWait getWebDriverWait(AppiumDriver<MobileElement> driver, int durationTime) {
        return new WebDriverWait(driver, durationTime);
    }

    public void FindButtonElementAndClick(AppiumDriver<MobileElement> driver, By elementId, String processExpression, int durationTime) {
        WebDriverWait wait = getWebDriverWait(driver, durationTime);
        long clickingButtonStartTime = System.currentTimeMillis();
        MobileElement button = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(elementId));
        button.click();
        long clickingButtonEndTime = System.currentTimeMillis();
        long clickingButtonTotalTime = clickingButtonEndTime - clickingButtonStartTime;
        System.out.println("Clicking the" + processExpression + "Button:" + clickingButtonTotalTime + " millisecond");
    }

    public void FindTextFieldElementAndWrite(AppiumDriver<MobileElement> driver, By elementId, String text, String processExpression, int durationTime) {
        WebDriverWait wait = getWebDriverWait(driver, durationTime);
        long enteringTextFieldStartTime = System.currentTimeMillis();
        MobileElement textField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(elementId));
        textField.sendKeys(text);
        long enteringTextFieldEndTime = System.currentTimeMillis();
        long enteringTextFieldTotalTime = enteringTextFieldEndTime - enteringTextFieldStartTime;
        System.out.println("Entering text in "+ processExpression + "text field: " + enteringTextFieldTotalTime + " millisecond");
    }

    public void FindTextFieldAndEnterPhoneNumber(AppiumDriver<MobileElement> driver, By elementId, String processExpression, int durationTime ){

        WebDriverWait wait = getWebDriverWait(driver, durationTime);
        long clickingPhoneNumberTextFieldStartTime = System.currentTimeMillis();
        MobileElement phoneNumberTextField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_Mobile_appXpath.phoneNumberTextFieldXpath));
        phoneNumberTextField.click();
       // Telefon numarası tuşlamalarını simüle etmek için KeyEvent kullanma
        String phoneNumber = "1234512368";
        for (char digit : phoneNumber.toCharArray()) {
            String digitStr = Character.toString(digit);
            driver.getKeyboard().sendKeys(digitStr); // Her rakamı ayrı ayrı gönder
        }
        long clickingPhoneNumberTextFieldEndTime = System.currentTimeMillis();
        long clickingPhoneNumberTextFieldTotalTime = clickingPhoneNumberTextFieldEndTime - clickingPhoneNumberTextFieldStartTime;
        System.out.println("Clicking"+ processExpression +"Text Field:" + clickingPhoneNumberTextFieldTotalTime + " millisecond");
}


}
