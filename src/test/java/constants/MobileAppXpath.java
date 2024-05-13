package constants;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public final class MobileAppXpath {

//Login
    public final By givePermissionXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]");
    public final By getStartedButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]");
    public final By loginButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Login\"]");
    public final By loginViaEmailButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Login via Email\"]");
    public final By emailTextFieldXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[18]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
    public final By passwordTextFieldXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[18]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
    public final By loginWithLoginViaEmailXpath = xpath("(//android.view.ViewGroup[@content-desc=\"Login\"])[2]");


//Restaurant
    public final By seeAllButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"See All \"]/android.widget.TextView");
     public final By restaurantButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Burger King, \uE660, 5, ETA 20 - 30 min, \uF180, min KD 0.000\"]/android.view.ViewGroup[1]/android.widget.TextView[1]");

//Cart
    public final By addToCartButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Add to Cart, KD 6.000\"]/android.widget.TextView");
    public final By goToCartButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Go to Cart, KD 4.700\"]/android.widget.TextView");
    public final By goToCheckoutButtonXpath=xpath("(//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"])[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    public final By completePurchaseButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Complete Purchase\"]");
    public final By cashOnDeliveryButtonXpath= xpath("//android.view.ViewGroup[@content-desc=\"\uDB80\uDD14, Cash On Delivery\"]");
   public final By kNetButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"K-Net/Debit Card\"]/android.widget.TextView");
    public final By backToHomeButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Back To Home\"]");
    public final By trashBinIconXpath = xpath("//android.view.ViewGroup[@content-desc=\"Couples Feast, KWD 4.95, 1\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
   public final By deleteButtonXpath=xpath("(//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"])[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
    public final By removeProductFromCartButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Remove\"]");
    public final By startShoppingButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Start Shopping\"]");

//Product
    public final By theProductButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Mix Royale Family Deal, 2 Whopper Sandwiches + 1 Chicken Royale Sandwich + 1 Spicy Royale Sandwich + Family Fries + Family Coca Cola for 4 people., KD 5.250\"]/android.view.ViewGroup/android.widget.TextView[1]");
    public final By familyMealButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Royale Mix Family Meal\"]/com.horcrux.svg.SvgView");
    public final By byProductRadioButtonXpath= xpath("//android.view.ViewGroup[@content-desc=\"Apple Pie\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.RectView[2]");
     public final By secondByProductRadioButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Hersheys Pie\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.RectView[2]");

//Phone Number
    public final By countryPhoneCodeButtonXpath = xpath("//android.widget.TextView[@text=\"\uE313\"]");
    public final By egyptCodePhoneButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"\uD83C\uDDEA\uD83C\uDDEC, +20, Egypt\"]");
    public final By phoneNumberTextFieldXpath = xpath("//android.widget.EditText[@text=\"Phone Number\"]");


    //K-net
    public final By bankXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View[2]");
    public final By kNetTestCartXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[8]");
    public final By cardNumberXpath= xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View[3]/android.view.View[3]/android.widget.EditText");
    public final By mmXpath= xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View[4]/android.view.View[2]");
    public final By mm09Xpath=xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[10]");
    public final By yyXpath= xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View[4]/android.view.View[3]");
    public final By yy25Xpath=xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]");
    public final By cartPinXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View[5]/android.view.View[2]/android.widget.EditText");
    public  final By aaXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[9]/android.widget.CheckBox");
    public final By submitButtonXpath =xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[10]/android.widget.Button[1]");
     public final By confirmButtonXpath =xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[11]/android.widget.Button[1]");
}

