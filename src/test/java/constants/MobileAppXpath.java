package constants;

import org.openqa.selenium.By;

public class MobileAppXpath {
    public By preciseButtonXpath = By.id("com.android.permissioncontroller:id/permission_allow_button");
    public By locationButton = By.id("com.android.permissioncontroller:id/permission_allow_one_time_button");
    public By getStartedButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]");
    public By loginButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]");
    //public By exploreTheMenu = By.xpath("//android.widget.TextView[@text=\"Explore the Menu\"]")
    public By loginViaEmailButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Login via Email\"]");
    public By emailTextFieldXpath = By.xpath("//android.widget.EditText[@text=\"Email\"]");
    public By passwordTextFieldXpath = By.xpath("//android.widget.EditText[@text=\"Password\"]");
    public By loginWithLoginViaEmailXpath = By.xpath("(//android.view.ViewGroup[@content-desc=\"Login\"])[2]");
    public By seeAllButtonXpath = By.xpath("//android.widget.TextView[@text=\"See All \"]");
    public By restaurantButtonXpath = By.xpath("//android.widget.TextView[@text=\"Burger King\"]");
    public By theProduct1ButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Fries, KD 0.000\"]");
    public By theProduct2ButtonXpath = By.xpath("//android.widget.TextView[@text=\"Snack Box Plus\"]");
    public By yourChoiceOfXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Large\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    //public By byProductRadioButtonXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Fries, KD 0.000\"]");
    //public By secondByProductRadioButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/secondByProduct']");
    public By addToCartButton1Xpath = By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public By addToCartButton2Xpath = By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public By goToCartButtonXpath = By.xpath("//android.widget.TextView[@text=\"Go to Cart\"]");
    public By goToCheckoutButtonXpath = By.xpath("//android.widget.TextView[@text=\"Go to checkout\"]");
    public By cashOnDeliveryButtonXpath = By.xpath("//android.widget.TextView[@text=\"Cash On Delivery\"]");
    public By kNetButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/kNet']");
    public By completePurchaseButtonXpath = By.xpath("//android.widget.TextView[@text=\"Complete Purchase\"]");
    public By bankXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/bank']");
    public By kNetTestCardXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/kNetTestCart']");
    public By cardNumberXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/cardNumber']");
    public By clickToCloseTheKeyboardXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/closeKeyboard']");
    public By monthButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/month']");
    public By month09ThRadioButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/month9']");
    public By yearButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/year']");
    public By year2025RadioButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/year2025']");
    public By cardPinXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/cartPin']");
    public By submitButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/submit']");
    public By confirmButtonXpath = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/confirm']");
    public By backToHomeButtonXpath = By.xpath("//android.widget.TextView[@text=\"Back To Home\"]");
    public By deleteButtonXpath = By.xpath("(//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"])[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
    public By startShoppingButtonXpath = By.xpath("//android.widget.TextView[@text='Start Shopping']");


}
