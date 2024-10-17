package constants;

import org.openqa.selenium.By;

public class MobileAppXpath {
    public By OnlyThisTimelocationButton = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]");
    public By signUpButtonXpath = By.xpath("//android.widget.Button[@content-desc=\"sign-up-button\"]");
    public By getStartedButtonXpath = By.xpath("//android.widget.Button[@content-desc='get-started']");  // Eklenen Xpath
    public By loginButtonXpath = By.xpath("//android.widget.Button[@content-desc=\"login-button\"]");
    public By exploreTheMenu = By.xpath("//android.widget.TextView[@text=\"Explore the Menu\"]");
    public By loginViaEmailButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Login via Email\"]");
    public By emailTextFieldXpath = By.xpath("//android.widget.EditText[@text=\"Email\"]");
    public By passwordTextFieldXpath = By.xpath("//android.widget.EditText[@text=\"Password\"]");
    public By loginWithLoginViaEmailXpath = By.xpath("(//android.view.ViewGroup[@content-desc=\"Login\"])[2]");
    public By seeAllButtonXpath = By.xpath("//android.widget.TextView[@text=\"See All \"]");  // Eklenen Xpath
    public By restaurantButtonXpath = By.xpath("//android.widget.TextView[@text=\"Burger King\"]");
    public By theProduct1ButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Fries, KD 0.000\"]");
    public By theProduct2ButtonXpath = By.xpath("//android.widget.TextView[@text=\"Snack Box Plus\"]");
    public By yourChoiceOfXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Large\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    public By addToCartButton1Xpath = By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public By addToCartButton2Xpath = By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public By goToCartButtonXpath = By.xpath("//android.widget.TextView[@text=\"Go to Cart\"]");  // Eklenen Xpath
    public By goToCheckoutButtonXpath = By.xpath("//android.widget.TextView[@text=\"Go to checkout\"]");  // Eklenen Xpath
    public By cashOnDeliveryButtonXpath = By.xpath("//android.widget.TextView[@text=\"Cash On Delivery\"]");  // Eklenen Xpath
    public By kNetButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/kNet']");
    public By completePurchaseButtonXpath = By.xpath("//android.widget.TextView[@text=\"Complete Purchase\"]");  // Eklenen Xpath
    public By bankXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/bank']");
    public By kNetTestCardXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/kNetTestCart']");
    public By cardNumberXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/cardNumber']");
    public By clickToCloseTheKeyboardXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/closeKeyboard']");
    public By monthButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/month']");
    public By month09ThRadioButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/month9']");
    public By yearButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/year']");
    public By year2025RadioButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/year2025']");
    public By cardPinXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/cartPin']");
    public By submitButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/submit']");  // Eklenen Xpath
    public By confirmButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/confirm']");
    public By backToHomeButtonXpath = By.xpath("//android.widget.TextView[@text=\"Back To Home\"]");
    public By deleteButtonXpath = By.xpath("(//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"])[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
    public By startShoppingButtonXpath = By.xpath("//android.widget.TextView[@text='Start Shopping']");
    public By firstNameFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-firstname-input']");  // Eklenen Xpath
    public By lastNameFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-lastname-input']");  // Eklenen Xpath
    public By emailFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-email-input']");  // Eklenen Xpath
    public By passwordFieldXpath = By.xpath("//android.widget.EditText[@resource-id='signup-password-input']");  // Eklenen Xpath
    public By phoneFieldXpath = By.xpath("//android.widget.EditText[@resource-id='country-picker-phone-input']");  // Eklenen Xpath
    public By agreedCheckBoxXpath = By.xpath("//android.view.ViewGroup[@content-desc='I have read and agreed to the Terms of Use and Privacy Policy']/com.horcrux.svg.SvgView");  // Eklenen Xpath
    public By createAccountButtonXpath = By.xpath("//android.widget.Button[@content-desc='signup-create-account-button']");  // Eklenen Xpath
    public By addNewAddressButtonXpath = By.xpath("//android.widget.TextView[@text='Add New Address ']");  // Eklenen Xpath
    public By buildingNameFieldXpath = By.xpath("//android.widget.EditText[@text='Building name*']");  // Eklenen Xpath
}
