package coyni.reusable.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ProcessingFeeComponent extends BrowserFunctions {

	private By lblProcessingFee = By.xpath("//div[contains(text(),'Fee:')]");

	String finalProcessingFeeAmount;
	String finalTotal = null;

	public float getProcessingFeePercentageValue() {
		String lblFee = getText(lblProcessingFee, "Fee Amount");
		ExtentTestManager.setInfoMessageInReport(lblFee);
		String str1 = lblFee.replaceAll("[a-zA-Z]", "");
		String str2 = str1.replaceAll("[%:$]", "");
		String str3 = str2.replaceAll("\\s", "");
		String[] str4 = str3.split("[+]");
		float i = Float.valueOf(str4[0]);
		ExtentTestManager.setInfoMessageInReport("The percentange value is " + i + "%");

		return i;
	}

	public float getDollarAmount() {
		String lblFee = getText(lblProcessingFee, "Fee Amount");
		ExtentTestManager.setInfoMessageInReport(lblFee);
		String str1 = lblFee.replaceAll("[a-zA-Z]", "");
		String str2 = str1.replaceAll("[%:$]", "");
		String str3 = str2.replaceAll("\\s", "");
		String[] str4 = str3.split("[+]");
		float k = Float.valueOf(str4[1]);
		ExtentTestManager.setInfoMessageInReport("The dollar amount for transaction is " + " $" + k);
		return k;
	}

	public float getPercentageAmount(String amount) {
		float amount1 = Float.valueOf(amount);
		float percentage = getProcessingFeePercentageValue() / 100 * amount1;
		String s = String.format("%.2f %n", percentage);
		float percentageAmount = Float.valueOf(s);
		ExtentTestManager.setInfoMessageInReport("The Percentage Amount is " + s);
		return percentageAmount;
	}

	public String getTotalProcessingFee(String amount) {

		float f = getDollarAmount() + getPercentageAmount(amount);
		String s = String.valueOf(f);
		ExtentTestManager.setInfoMessageInReport("The Total Processing Fee is " + f);
		return s;
	}
	
	public float getTotalProcessingAmountToAdd(String amount) {
		float f = getDollarAmount() + getPercentageAmount(amount);
		return f;
	}

	//String processingFee = getTotalProcessingFee("");
	
	
	public String getAmount(String amount) {
		String s = amount;
		ExtentTestManager.setInfoMessageInReport("The Amount is " + s);
		return s;
	}

	public float getAmountTOAdd(String amount) {
		float f = Float.valueOf(amount);
		ExtentTestManager.setInfoMessageInReport("The Amount is " + f);
		return f;
	}

	public String getTotalAmount(String amount) {
		float f = getAmountTOAdd(amount)+getTotalProcessingAmountToAdd(amount);
		String s = String.valueOf(f);
		ExtentTestManager.setInfoMessageInReport("The Total amount is " + f);
		return s;
	}

	public void verifyProcessingFee(String amount, String processingFee, String totalAmount) {
		String lblAmount = getText(By.xpath("//span[contains(text(),'Amount')]/following-sibling::*"),
				"Withdraw Amount");
		// float amount = Float.valueOf(lblAmount);
		String lblTotalProcessingFee = getText(
				By.xpath("//span[contains(text(),'Processing Fee')]/following-sibling::*"), "Processing Fee");
		String lblTotal = getText(By.xpath("//span[contains(text(),'Total')]/following-sibling::*"), "Total Amount");
		String str = lblAmount.replaceAll("[a-zA-Z]", "").replaceAll("\\s", "");
		String str1 = lblTotalProcessingFee.replaceAll("[a-zA-Z]", "").replaceAll("\\s", "");
		String str2 = lblTotal.replaceAll("[a-zA-Z]", "").replaceAll("\\s", "");
		if (str.equals(getAmount(amount))) {
			ExtentTestManager.setPassMessageInReport(str + " The Amount is Matched with given amount " + amount);
		} else {
			ExtentTestManager.setFailMessageInReport(str + " The Amount is not Matched with given amount " + amount);
		}
		if (str1.equals(processingFee)) {
			ExtentTestManager.setPassMessageInReport(
					str1 + " The Processing Fee Amount is Matched with " + processingFee);
		} else {
			ExtentTestManager.setFailMessageInReport(
					str1 + " The Processing Fee Amount is not Matched with " + processingFee);
		}
		if (str2.equals(totalAmount)) {
			ExtentTestManager.setPassMessageInReport(str2 + " The Total Amount is Matched with " + totalAmount);
		} else {
			ExtentTestManager.setFailMessageInReport(str2 + " The Total Amount is not Matched with " + totalAmount);
		}

	}
}
