package constants;

import org.openqa.selenium.By;

public class MobileAppId {
    public By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    public By locationButton = By.id("com.android.permissioncontroller:id/permission_allow_one_time_button");
    public By getStartedButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]");
    public By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]");
    //public By exploreTheMenu = By.xpath("//android.widget.TextView[@text=\"Explore the Menu\"]")
    public By loginViaEmailButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Login via Email\"]");
    public By emailTextField = By.xpath("//android.widget.EditText[@text=\"Email\"]");
    public By passwordTextField = By.xpath("//android.widget.EditText[@text=\"Password\"]");
    public By loginWithLoginViaEmail = By.xpath("(//android.view.ViewGroup[@content-desc=\"Login\"])[2]");
    public By seeAllButton = By.xpath("//android.widget.TextView[@text=\"See All \"]");
    public By restaurantButton = By.xpath("//android.widget.TextView[@text=\"Burger King\"]");
    public By theProduct1Button = By.xpath("//android.view.ViewGroup[@content-desc=\"Fries, KD 0.000\"]");
    public By theProduct2Button = By.xpath("//android.widget.TextView[@text=\"Snack Box Plus\"]");
    public By yourChoiceOf = By.xpath("//android.view.ViewGroup[@content-desc=\"Large\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    //public By byProductRadioButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Fries, KD 0.000\"]");
    //public By secondByProductRadioButton = By.xpath("//*[@resource-id='com.koutfood.koutfood:id/secondByProduct']");
    public By addToCartButton1 = By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public By addToCartButton2 = By.xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public By goToCartButton = By.xpath("//android.widget.TextView[@text=\"Go to Cart\"]");
    public By goToCheckoutButton = By.xpath("//android.widget.TextView[@text=\"Go to checkout\"]");
    public By cashOnDeliveryButton = By.xpath("//android.widget.TextView[@text=\"Cash On Delivery\"]");
    public By kNetButton = By.id("com.koutfood.koutfood:id/kNet");
    public By completePurchaseButton = By.xpath("//android.widget.TextView[@text=\"Complete Purchase\"]");
    public By bank = By.id("com.koutfood.koutfood:id/bank");
    public By kNetTestCard = By.id("com.koutfood.koutfood:id/kNetTestCart");
    public By cardNumber = By.id("com.koutfood.koutfood:id/cardNumber");
    public By clickToCloseTheKeyboard = By.id("com.koutfood.koutfood:id/closeKeyboard");
    public By monthButton = By.id("com.koutfood.koutfood:id/month");
    public By month09ThRadioButton = By.id("com.koutfood.koutfood:id/month9");
    public By yearButton = By.id("com.koutfood.koutfood:id/year");
    public By year2025RadioButton = By.id("com.koutfood.koutfood:id/year2025");
    public By cardPin = By.id("com.koutfood.koutfood:id/cartPin");
    public By submitButton = By.id("com.koutfood.koutfood:id/submit");
    public By confirmButton = By.id("com.koutfood.koutfood:id/confirm");
    public By backToHomeButton = By.xpath("//android.widget.TextView[@text=\"Back To Home\"]");
    public By deleteButton = By.xpath("(//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"])[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");
    public By startShoppingButton = By.xpath("//android.widget.TextView[@text='Start Shopping']");
    public By preciseButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
}
