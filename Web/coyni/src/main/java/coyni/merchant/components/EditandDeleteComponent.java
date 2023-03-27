package coyni.merchant.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EditandDeleteComponent extends BrowserFunctions {

	private By cardNumber = By.xpath("//p[contains(@class,'text-base')]");
	private By btnConfirmDelete = By.xpath("//button[text()='Confirm Remove']");
	private By txtaddress = By.xpath("//p[text()='address1']");
	private By lblDebitCard = By.xpath("//p[contains(text(),'Mastercard')]");
	private By btnEdit = By.xpath("//button[@data-tip='Edit'][1]");

	public String getCardNumber(int number) {
		List<WebElement> cardNumbers = getElementsList(cardNumber, "card number");
		String cardNumber = cardNumbers.get(number).getText();
		ExtentTestManager.setInfoMessageInReport("Card Number is " + cardNumber);
		return cardNumber;
	}

	public void clickEdit(String number) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", number)), "card");
		click(By.xpath(String
				.format("//p[contains(text(),'%s')]/following-sibling::button[contains(@class, 'icon-edit')]", number)),
				number);
		ExtentTestManager.setInfoMessageInReport("Edit button clicked for card " + (number));

	}

	public void clickDelete(String number) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", number)), "card");
		click(By.xpath(String.format(
				"//p[contains(text(),'%s')]/following-sibling::button[contains(@class, 'icon-trash')]", number)),
				number);
		ExtentTestManager.setInfoMessageInReport("Delete button clicked for card " + (number));
	}

	public void clickConfirmDelete() {
		click(btnConfirmDelete, "Confirm Delete");
	}

}
