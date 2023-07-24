package coyni.business.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EditandDeleteComponent extends BrowserFunctions {
	private By cardNumber = By.xpath("//p[contains(@class,'text-base')]");
	private By btnConfirmDelete = By.xpath("//button[text()='Confirm Remove']");
	private By txtaddress = By.xpath("//p[text()='address1']");

	public String getCardNumber(int number) {
		List<WebElement> cardNumbers = getElementsList(cardNumber, "card number");
		String cardNumber = cardNumbers.get(number).getText();
		ExtentTestManager.setInfoMessageInReport("Card Number is " + cardNumber);
		return cardNumber;
	}

	public void clickEdit(String number) {
//		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", number)), "card");
		click(By.xpath(String.format(
				"//div[contains(text(),'%s')]/ancestor::div[@class='flex justify-between items-center']//button[@data-tip='Edit Payment Method']",
				number)), number);
		ExtentTestManager.setInfoMessageInReport("Edit button clicked for card Number (Last Digits) " + (number));
	}

	public void clickDelete(String number) throws InterruptedException {
//		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", number)), "card");
		click(By.xpath(String.format(
				"//div[contains(text(),'%s')]/ancestor::div[@class='flex justify-between items-center']//button[@data-tip='Remove Payment Method']",
				number)), number);
		Thread.sleep(3000);
		ExtentTestManager.setInfoMessageInReport("Delete button clicked for card Number (Last Digits) " + (number));
	}
	public void clickBankAccountDelete(String number) throws InterruptedException {
//		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", number)), "card");
		click(By.xpath(String.format(
				"//div[contains(text(),'%s')]/ancestor::div[@class='flex justify-between items-center']//button[@data-tip='Remove Payment Method']",
				number)), number);
		Thread.sleep(3000);
		ExtentTestManager.setInfoMessageInReport("Delete button clicked for card Number (Last Digits) " + (number));
	}

	public void clickConfirmDelete() {
		click(btnConfirmDelete, "Confirm Delete");
	}

}
