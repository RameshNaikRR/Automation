package coyni.checkout;

import coyni.merchant.popups.OrderPreviewPopup;

public class BuyCoyniTokensOrderPreviewPage extends OrderPreviewPopup{
	
	
	public IdentityVerificationPage identityVerificationPage() {
		return new IdentityVerificationPage();
	}

}
