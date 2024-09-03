package services;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MobileAppServices {

    public void GivePermissionTest(AppiumDriver<MobileElement> driver, int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        try {
            if (ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).apply(driver) != null) {
                FindButtonElementAndClick(driver, By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), "Precise Location Permission", durationTime);
            }
        } catch (Exception e) {
            System.out.println("Permission Test Failed: " + e.getMessage());
        }
    }

    public void FindButtonElementAndClick(AppiumDriver<MobileElement> driver, By by, String elementName, int durationTime) {
        MobileElement element = (MobileElement) driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        System.out.println(elementName + " clicked.");
    }

    public void FindTextFieldElementAndWrite(AppiumDriver<MobileElement> driver, By by, String text, String elementName, int durationTime) {
        MobileElement element = (MobileElement) driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        System.out.println(text + " written in " + elementName + ".");
    }

    public void FindTextFieldAndEnterNumber(AppiumDriver<MobileElement> driver, By by, String description, String value, int durationTime) {
        MobileElement element = driver.findElement(by);
        element.sendKeys(value);
    }

    public void ScrollUp(AppiumDriver<MobileElement> driver, int startX, int startY, int endX, int endY) {
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void SwipeElement(AppiumDriver<MobileElement> driver, int startX, int startY, int endX, int endY) {
        TouchAction<?> action = new TouchAction<>(driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
        System.out.println("Element swiped from (" + startX + ", " + startY + ") to (" + endX + ", " + endY + ")");
    }
}
