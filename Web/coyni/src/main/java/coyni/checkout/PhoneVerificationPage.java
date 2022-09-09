package coyni.checkout;

import coyni.merchant.components.PhoneVerificationComponent;

public class PhoneVerificationPage extends PhoneVerificationComponent {
	public PayPage page() {
		return new PayPage();
	}
}
