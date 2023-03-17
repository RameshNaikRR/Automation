package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class GetHelpPage extends BrowserFunctions {
	private By lblheading = By.xpath("//p[text()='Need help with coyni?']");
	private By lblcaption = By.xpath("//p[text()='Our support team is here for you.']");
	private By lblDescription = By
			.xpath("//p[@class='text-[14px] leading-[20px] tracking-[0.22px] font-normal text-cbc9 w-[430px]']");
	private By lblElements = By.xpath("//h1[@class='text-cbc9 font-semibold text-[13px] mb-[8px]']");
	private By helpElements = By.xpath("//h1[@class='text-cbc9 font-semibold text-[13px]']");
	private By supportHyperlink = By.xpath("//a[@href='mailto:support@coyni.com?subject']");

	public void verifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblheading, "Heading", heading);
	}

	public void verifyCaption(String caption) {
		new CommonFunctions().verifyLabelText(lblcaption, "caption", caption);
	}

	public void verifyDescription() {
		String description = getText(lblDescription, " ");
		ExtentTestManager.setInfoMessageInReport(description + "is displayed");
	}

	public void verifySupportHyperLink() {
		new CommonFunctions().verifyCursorAction(supportHyperlink, "click Action on Hyper link");
		moveToElement(supportHyperlink, "support@coyni.com");
		new CommonFunctions().verifyTextUnderLine(supportHyperlink, "support@coyni.com");
		String str = getElement(supportHyperlink, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(supportHyperlink, "hyperlink");
	}

	public void verifyHelpElements() {
		List<WebElement> rows = getElementsList(lblElements, " ");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", " ");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyGetHelpElements() {
		String text = getText(helpElements, " ");
		ExtentTestManager.setInfoMessageInReport(text + "is displayed");
	}
}