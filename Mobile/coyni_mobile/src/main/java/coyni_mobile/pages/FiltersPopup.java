package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.DatePickerComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FiltersPopup extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Transactions']");
	private By txtFromAmount = MobileBy.xpath("//*[contains(@resource-id,'transAmountStartET')]");
	private By txtToAmount = MobileBy.xpath("//*[contains(@resource-id,'transAmountEndET')]");
	private By btnCalender = MobileBy.xpath("//*[contains(@resource-id,'datePickET')]");
	private By btnResetAllFilters = MobileBy.xpath("//*[contains(@resource-id,'resetFiltersTV')]");
	private By btnApplyfilter = MobileBy.xpath("//*[contains(@resource-id,'applyFilterBtnCV')]");

	public void clickApplyfilters() {
		scrollDownToElement(btnApplyfilter, "Apply Filets");
		click(btnApplyfilter, "Apply filters");
	}

	public void clickResetAllFilters() {
		click(btnResetAllFilters, "Reset All Filters");
	}

	public void clickCalender() {
		scrollDownToElement(btnCalender, "Calender");
		click(btnCalender, "Calender");
	}

	public void fillFromAmount(String fromAmount) {
		scrollDownToElement(txtFromAmount, fromAmount);
		click(txtFromAmount, "fromAmount");
		enterText(txtFromAmount, fromAmount, "From Amount");
		//new CommonFunctions().clickDone();
	}

	public void fillToAmount(String toAmount) {
		click(txtToAmount, "toAmount");
		enterText(txtToAmount, toAmount, "To Amount");
		//new CommonFunctions().clickDone();

	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}

	public By getElement(String elementName) {
		return MobileBy.xpath(String.format("//*[contains(@resource-id,'%s')]", elementName));
	}

	public void selectFilterType(String type) {
		//scrollDownToElement(getElement(type), type);
		click(getElement(type), type);
	}
	public void selectFilterSubType(String subType) {
		scrollDownToElement(getElement(subType), subType);
		click(getElement(subType), subType);
	}

	public DatePickerComponent datePickerComponent() {
		return new DatePickerComponent();
	}

	public PermissionAlert permissionAlert() {
		return new PermissionAlert();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();

	}

}
