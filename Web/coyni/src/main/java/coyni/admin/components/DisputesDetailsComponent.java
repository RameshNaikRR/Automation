package coyni.admin.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class DisputesDetailsComponent extends BrowserFunctions {
	

	private By btnWon = By.xpath("//button[text()='Mark As Won']");

	private By btnLost = By.xpath("//button[text()='Mark As Lost']");

	private By lblAmount = By.xpath("(//p[@class='text-base'])[5]");//(//div[@class='card  shadow-lg']//div[@class='flex flex-col items-end']//p)[1]
	
	private By lblCaseID = By.xpath("//p[contains(@class,'Case_CaseTitle')]");

	public void clickLost() {
		click(btnLost, "Lost");
	}

	public void clickWon() {
		click(btnWon, "Won");
	}

	private By lblCaseId = By.xpath("//div[@class='flex flex-row justify-between ']/descendant::div[text()='Won']");
	private By lblMsg = By.xpath("//label[text()='Type custom activity log message here.']");

	public void enterMessage(String message) {
		click(lblMsg, "Message");
		enterText(lblCaseId, message, "Message");
	}

	public String getCaseID() {
		// ExtentTestManager.setInfoMessageInReport("The case Id is " +
		// getText(lblCaseId, "WOn"));
		String str = getText(lblCaseID, "Case Id");
		ExtentTestManager.setInfoMessageInReport("Case id is " + str);
		return str;
	}
	
	public String verifyAmount() {
		String caseDetailsAmount = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("The Amount is  " + caseDetailsAmount);
		return caseDetailsAmount;
	}
	private By lblDate=By.xpath("(//p[contains(@class,'mb-1 text-base text-cgy3')]//following-sibling::span)[3]");
	private By lblReferenceId=By.xpath("(//span[contains(@class,'font-bold text-cgy16 flex flex-row Case_transactionValue__144St')])[1]");
	private By lblTransactionSubType=By.xpath("(//p[contains(@class,'mb-1 text-base text-cgy3')]//following-sibling::span)[2]");
	

	public String verifyDate() {
		String transactionDetailsDate = getText(lblDate, "Amount");
		ExtentTestManager.setInfoMessageInReport("Date is " + transactionDetailsDate);
		return transactionDetailsDate;
	}

	public String verifySubType() {
		String transactionDetailsSubType = getText(lblTransactionSubType, "Amount");
		ExtentTestManager.setInfoMessageInReport("Transadction Sub Type is" + transactionDetailsSubType);
		return transactionDetailsSubType;
	}

	public String verifyReferenceID() {
		String transactionDetailsRef = getText(lblReferenceId, "Ref");
		ExtentTestManager.setInfoMessageInReport("Transadction Sub Type is" + transactionDetailsRef);
		return transactionDetailsRef;
	}

	private By tblData = By.xpath("//thead[@class='rounded-full']//following-sibling::th");
	private By statusPending = By.xpath("(//div[text()='Pending'])[2]");
	private By lblName = By.xpath("//td[text()='Test Test']");

	public void verifyName(String nameOfUser) {
		WebElement name = getElement(lblName, "");
		if (nameOfUser.equals(name)) {
			ExtentTestManager.setInfoMessageInReport("Customer name is " + nameOfUser);
		}
	}

	public void clickPending() {
		click(statusPending, "Status");
	}

	public void verifyTableData(String data) {
		List<WebElement> elementsList = getElementsList(tblData, "Table Data");
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String[] split = data.split(",");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				if (text.equalsIgnoreCase(split[i])) {
					ExtentTestManager.setPassMessageInReport(text + " Table Data match");
					break;
				}

				else {
					count++;
					if (count == split.length) {
						ExtentTestManager.setWarningMessageInReport(text + " Table data  Not Found");
					}
				}
			}

		}

	}

	public DisputesWonAndLostComponent disputesWonAndLostComponent() {
		return new DisputesWonAndLostComponent();
	}

}
