package coyni_mobile.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class NavigationComponent extends MobileFunctions {

	private By btnBack = MobileBy.xpath("//*[@name='Back'] | (//*[@name='Button'])[1] | //*[@name='back']");
	private By btnClose = MobileBy.xpath("(//*[@name='close'])[1]| (//*[@name='Button'])[1] |(//XCUIElementTypeButton[@name='Button'])[2]|(//XCUIElementTypeButton[@name='close'])[2]");

	public void clickBack() {
		click(btnBack, "Back");
		ExtentTestManager.setInfoMessageInReport("Clicked on element Back");
//		List<WebElement> list = getElementList(btnBack, "Back");
//		int size = list.size();
//		for (int i = 0; i < size; i++) {
//			if (list.get(i).isDisplayed()) {
//				list.get(i).click();
//				break;
//			}
		}
		
//	click(btnBack, "Back");
//	}
	

	public void clickClose() {
		click(btnClose, "close");
		ExtentTestManager.setInfoMessageInReport("Clicked on element Close");
//		List<WebElement> list = getElementList(btnClose, "Close");
//		int size = list.size();
//		for (int i = 0; i < size; i++) {
//			if (list.get(i).isDisplayed()) {
//				list.get(i).click();
//				break;
//			}
//		}
		
//   click(btnClose, "Close");
	}

	public void verifyBackView() {
		// new CommonFunctions().elementView(btnBack, "Back Icon");
	}

	public void verifyCloseView() {
		//System.out.println("element list:" + DriverFactory.getDriver().findElements(btnClose).size());
//		 new CommonFunctions().elementView(btnClose, "Close Icon");
	}
}
