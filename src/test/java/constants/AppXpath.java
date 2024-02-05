package constants;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public final class AppXpath {
    public final By givePermissionXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]");
    public final By GetStartedButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]");
    public final By loginButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Login\"]");
    public final By loginViaEmailButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Login via Email\"]");
    public final By emailTextFieldXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
    public final By passwordTextFieldXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
    public final By controlEyeIconXpath = xpath("//android.view.ViewGroup[@content-desc=\"\uE8F5\"]/android.widget.TextView");
    public final By loginWithLoginViaEmailXpath = xpath("(//android.view.ViewGroup[@content-desc=\"Login\"])[2]");
    public final By seeAllPopularRestaurantsButtonXpath = xpath("(//android.view.ViewGroup[@content-desc=\"See All \"])[2]");
    //ing bak
    public final By closingTheSearchFieldXpath = xpath("//android.view.ViewGroup[@content-desc=\"Offer\"]/android.widget.TextView");
    public final By phJahraButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"PH JAHRA, \uE660, 3.3, ETA 25 - 35 min, \uF180, min KWD 15.000\"]/android.view.ViewGroup[2]/android.widget.TextView[1]");
    public final By couplesFeastFavoriteButtonXpath = xpath("(//android.widget.TextView[@text=\"\uDB86\uDCA0\"])[3]");
    public final By couplesFeastButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Couples Feast, Meal for 2: Share a delightful moment with your dear one with a medium pizza (Pan/Thin/San Francisco), 1 deliciously blended salad, 4 pcs crispy garlic bread, 2 Pepsi (250ml), KWD 4.95\"]/android.view.ViewGroup/android.widget.TextView[2]");
    // ürün içerik xpath'i kullanildi.
    public final By panRadioButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Pan (Thick & Rich)\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    public final By ultimateCheeseRadioButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Ultimate Cheese\"]/android.widget.TextView");
    //ismi
    public final By macaroniSaladRadioButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Macaroni Salad\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    public final By mirindaRadioButtonXapth = xpath("//android.view.ViewGroup[@content-desc=\"Mirinda\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    public final By sevenUpRadioButtonXapth = xpath("//android.view.ViewGroup[@content-desc=\"7 Up\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    public final By addToCartButtonXpath = xpath("//android.widget.TextView[@text=\"Add to Cart\"]");
    public final By goToCartButtonXpath = xpath("//android.widget.TextView[@text=\"Go to Cart\"]");
    public final By couplesFeastTrashBinButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Couples Feast, KWD 4.95, 1\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
    public final By removeProductFromCartButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Remove\"]");
    public final By startShoppingButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Start Shopping\"]");
    //
    public final By seeAllFavoriteRestaurantsButtonXpath = xpath("(//android.view.ViewGroup[@content-desc=\"See All \"])[1]");
    public final By burgerKingButtonXpath = xpath("//android.widget.TextView[@text=\"Burger King\"]");
    public final By juniorBigKingMealButtonXpath = xpath("//android.widget.TextView[@text=\"Junior Big King Meal\"]");
    public final By juniorBigKingFavoriteButtonXpath = xpath("(//android.widget.TextView[@text=\"\uDB86\uDCA0\"])[2]");
    public final By goMegaRadioButtonXpath = xpath("//android.widget.TextView[@text=\"Go Mega\"]");
    public final By orionRingsRadioButtonXpath = xpath("//android.widget.TextView[@text=\"Onion Rings\"]");
    public final By cocaColaRadioButtonXpath = xpath("//android.widget.TextView[@text=\"Coca Cola\"]");
    public final By addCheeseRadioButtonXpath = xpath("//android.widget.TextView[@text=\"Add Cheese\"]");
    public final By bbqSauceRadioButtonXpath = xpath("//android.widget.TextView[@text=\"BBQ Sauce\"]");
    public final By plantBasedWhopperRadioButtonXpath = By.xpath("//android.widget.TextView[@text=\"Plant based Whopper\"]");
    public final By juniorBigKingMealTrashBinButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Junior Big King Meal, KWD 3.195, 1\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    //
    public final By alankoduXpath = xpath("//android.widget.TextView[@text=\"\uE313\"]");
    public final By egyptCodeXpath = xpath("//android.view.ViewGroup[@content-desc=\"\uD83C\uDDEA\uD83C\uDDEC, +20, Egypt\"]");
    public final By phoneNumberTextFieldXpath = xpath("//android.widget.EditText[@text=\"Phone Number\"]");
    public final By verificationCodeIndexXpath = xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]");
    public final By submitButtonXpath = xpath("//android.widget.TextView[@text=\"Submit\"]");
    //

    public final By filterButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"What you cravin?\"]/android.widget.TextView");
    public final By arabicButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Arabic\"]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView");
    public final By backPageButtonXpath = xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[15]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");

    public final By colaButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Cola\"]");
    public final By cocaColaButtonXpath = xpath("(//android.view.ViewGroup[@content-desc=\"coca cola, KWD 0.45 \"])[3]/android.widget.TextView[1]");
    public final By mixButtonXpath = xpath("(//android.view.ViewGroup[@content-desc=\"Mix\"])[2]/android.widget.TextView");
    public final By bkLuluHypermarketButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"BK LuLu Hypermarket, 4.4, ETA 40 - 50 min, ·, min KWD 15.000\"]/android.widget.TextView[1]");
    public final By onlyOnSpeedyBunnyButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"ONLY on SpeedyBunny\"]/android.widget.TextView");
    public final By familyAndFriendsOffersButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Family and Friends Offers\"]/android.widget.TextView");
    public final By clearButtonXpath = xpath("//android.view.ViewGroup[@content-desc=\"Clear\"]/android.widget.TextView");
    public final By closingTheSearchField2Xpath = xpath("//android.view.ViewGroup[@content-desc=\"Bbq\"]");
}

