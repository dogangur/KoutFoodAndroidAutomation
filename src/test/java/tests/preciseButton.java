package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class preciseButton {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    // MobileAppXpath class'ından xpath'leri çekmek için bir örnek
    private By preciseButtonXpath = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]");

    // Constructor: Driver ve Wait nesnelerini dışarıdan alacak
    public preciseButton(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // preciseButtonXpath butonuna tıklama işlemi
    public void clickPreciseButton() {
        try {
            MobileElement preciseButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(preciseButtonXpath));
            preciseButton.click();
            System.out.println("Precise button clicked successfully.");
        } catch (Exception e) {
            System.out.println("Precise button not found: " + e.getMessage());
        }
    }
}
