package services;

import constants.MobileAppXpath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class MobileAppServices {
    private MobileAppXpath _Mobile_appXpath;

    public MobileAppServices() {
        _Mobile_appXpath = new MobileAppXpath();
    }

    private static WebDriverWait getWebDriverWait(AppiumDriver<MobileElement> driver, int durationTime) {
        return new WebDriverWait(driver, durationTime);
    }

    public void GivePermissionTest(AppiumDriver<MobileElement> driver, int durationTime) {

        Wait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(durationTime))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        long startTime = System.currentTimeMillis();
        MobileElement allowButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Button")));
        allowButton.click();
        MobileElement givePermission = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(_Mobile_appXpath.givePermissionXpath));
        givePermission.click();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Givepermission Test: " + totalTime + " millisecond");
    }
    public void ScrollUp(AppiumDriver<MobileElement> driver, int pressXOffset,int pressYOffset, int moveToXOffset, int moveToYOffset) throws InterruptedException {

    Thread.sleep(1000);

    TouchAction scrollUp = new TouchAction<>(driver)
            .press(PointOption.point(pressXOffset, pressYOffset))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
            .moveTo(PointOption.point(moveToXOffset, moveToYOffset))
            .release()
            .perform();
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

    public void FindTextFieldAndEnterNumber(AppiumDriver<MobileElement> driver, By elementId, String processExpression, String number, int durationTime ){

        WebDriverWait wait = getWebDriverWait(driver, durationTime);
        long clickingPhoneNumberTextFieldStartTime = System.currentTimeMillis();
        MobileElement phoneNumberTextField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(elementId));
        phoneNumberTextField.click();
       // Telefon numarası tuşlamalarını simüle etmek için KeyEvent kullanma
        String enterNumber = number;
        for (char digit : enterNumber.toCharArray()) {
            String digitStr = Character.toString(digit);
            driver.getKeyboard().sendKeys(digitStr); // Her rakamı ayrı ayrı gönder
        }
        long clickingPhoneNumberTextFieldEndTime = System.currentTimeMillis();
        long clickingPhoneNumberTextFieldTotalTime = clickingPhoneNumberTextFieldEndTime - clickingPhoneNumberTextFieldStartTime;
        System.out.println("Clicking"+ processExpression +"Text Field:" + clickingPhoneNumberTextFieldTotalTime + " millisecond");
}


}
