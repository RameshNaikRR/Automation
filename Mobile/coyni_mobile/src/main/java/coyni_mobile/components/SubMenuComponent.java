package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SubMenuComponent extends MobileFunctions {
    //    private By btnSend = MobileBy.id("com.ideyalabs.quickcard:id/layoutTSend");
//    private By btnReceive = MobileBy.id("com.ideyalabs.quickcard:id/layoutTReceive");

    private By btnScanQR = MobileBy.id("com.coyni.android:id/layoutTScan");
    private By btnPayOrRequest = MobileBy.id("com.coyni.android:id/layoutTPay");
    private By btnBuyToken = MobileBy.id("com.coyni.android:id/layoutTBuy");
    private By btnWithdraw = MobileBy.id("com.coyni.android:id/layoutTWihdraw");
//
//    // sub menu actions
//    public BuyTokenComponent clickBuyToken() {
//        click(btnBuyToken, "Buy Token");
//        return new BuyTokenMenuComponent();
//    }

    public void clickScanQR() {
        click(btnScanQR, "Scan QR");
    }

    public void clickPayOrRequest() {
        click(btnPayOrRequest, "Pay / Request");
    }

    public WithdrawMenuComponent clickWithdraw() {
        click(btnWithdraw, "Withdraw");
        return new WithdrawMenuComponent();
    }


}
