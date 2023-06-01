package coyni.admin.components;

import java.sql.SQLException;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class DisputesDetailsComponent extends BrowserFunctions {

	private By btnWon = By.xpath("//button[text()='Mark As Won']");

	private By lblWon = By.xpath("//div[text()='Won']");

	private By btnLost = By.xpath("//button[text()='Mark As Lost']");
	private By lblLost = By.xpath("//div[text()='Lost']");

	private By lblAmount = By.xpath("(//p[contains(@class,'text-base')])[6]");// (//div[@class='card
																				// shadow-lg']//div[@class='flex
																				// flex-col items-end']//p)[1]

	private By lblCaseID = By.xpath("//p[contains(@class,'Case_CaseTitle')]");
	private By lblShowingItems = By.xpath("//span[@class='entries-message']");

	public String getTotalPendingTransaction() {
		String text = getText(lblShowingItems, "Toatl Pending Transction");
		String[] split = text.split(" ");
		String string = split[3];
		return string;
	}

	public void clickLost() {
		click(btnLost, "Lost");
	}

	public void clickLosts() {
		click(lblLost, "Lost");
	}

	public void clickWon() {
		click(btnWon, "Won");
	}

	public void clickWons() {
		click(lblWon, "Won");
	}

	/*
	 * New code for filters
	 */
	private By getTabItemLoc(String elementName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", elementName));
	}

	private By verifyTabItemLoc(String elementName) {
		return By.xpath(String.format("//div[text()='%s']/parent::*", elementName));
	}

	public void clickAllDisputes(String expColor, String colorName) {
		click(getTabItemLoc("All Disputes"), "All Disputes");
		new CommonFunctions().verifyColor(verifyTabItemLoc("All Disputes"), expColor, colorName);
	}

	public void clickPendingTab(String expColor, String colorName) {
		click(getTabItemLoc("Pending"), "Pending");
		new CommonFunctions().verifyColor(verifyTabItemLoc("Pending"), expColor, colorName);
	}

	public void clickWonTab(String expColor, String colorName) {
		click(getTabItemLoc("Won"), "Won");
		new CommonFunctions().verifyColor(verifyTabItemLoc("Won"), expColor, colorName);
	}

	public void clickLostTab(String expColor, String colorName) {
		click(getTabItemLoc("Lost"), "Lost");
		new CommonFunctions().verifyColor(verifyTabItemLoc("Lost"), expColor, colorName);
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

	private By lblDate = By.xpath("(//p[contains(@class,'mb-1 text-base text-cgy3')]//following-sibling::span)[3]");
	private By lblReferenceId = By.xpath("(//p[contains(@class,'mb-1 text-base text-cgy3')])[4]");
	private By lblTransactionSubType = By
			.xpath("(//p[contains(@class,'mb-1 text-base text-cgy3')]//following-sibling::span)[2]");

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
	private By topstatusPending = By.xpath("(//div[text()='Pending'])[1]");
	private By lblName = By.xpath("//td[text()='Test Test']");

	public void verifyName(String nameOfUser) {
		WebElement name = getElement(lblName, "");
		if (nameOfUser.equals(name)) {
			ExtentTestManager.setInfoMessageInReport("Customer name is " + nameOfUser);
		}
	}

	public void clickPending() {
		click(statusPending, "Clicked on Pending");
	}

	public void clickPendingStatus() {
		click(topstatusPending, "Clicked on Pending");
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

	// public void getTotalItemsCount(String query) throws SQLException {

	// }

	public void getTotalItemsCount(String query) {
		;
		try {
			int count = DBConnection.getDbCon().getCount(query);
			ExtentTestManager.setInfoMessageInReport(" Db pending Details is " + count);
			int expCount = Integer.parseInt(getTotalPendingTransaction());
			ExtentTestManager.setInfoMessageInReport(" Application pending Details is " + expCount);
			if (count == expCount) {
				ExtentTestManager
						.setPassMessageInReport("Number of Pending Details  matches with number of entries in DB ");
			} else {
				ExtentTestManager
						.setFailMessageInReport("Number of Pending Details not matches with number of entries in DB ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getTotalWonItemsCount(String query) {
		try {
			int count = DBConnection.getDbCon().getCount(query);
			ExtentTestManager.setInfoMessageInReport(" Db Won Details is " + count);
			int expCount = Integer.parseInt(getTotalPendingTransaction());
			ExtentTestManager.setInfoMessageInReport(" Application pending Details is " + count);
			if (count == expCount) {
				ExtentTestManager
						.setPassMessageInReport("Number of Won Details  matches with number of entries in DB ");
			} else {
				ExtentTestManager
						.setFailMessageInReport("Number of Won Details not matches with number of entries in DB ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getTotalLostItemsCount(String query) {
		try {
			int count = DBConnection.getDbCon().getCount(query);
			ExtentTestManager.setInfoMessageInReport(" Db Lost Details is " + count);
			ExtentTestManager.setInfoMessageInReport(count + " Db Transaction");
			ExtentTestManager.setInfoMessageInReport(" Application Lost Details is " + count);
			int expCount = Integer.parseInt(getTotalPendingTransaction());
			if (count == expCount) {
				ExtentTestManager
						.setPassMessageInReport("Number of Lost Details  matches with number of entries in DB ");
			} else {
				ExtentTestManager
						.setFailMessageInReport("Number of Lost Details not matches with number of entries in DB ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getTotalDisputesCount(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(getTotalPendingTransaction());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(
					count + " Number of users  matches with number of entries in DB " + expCount);
		} else {
			ExtentTestManager.setFailMessageInReport("Number of users not matches with number of entries in DB ");
		}
	}

	private By getTableItems(String elementName) {
		return By.xpath(String.format("//span[contains(text(),'No')]", elementName));
	}

	public int noDisputesData() {
		int size = getElementsList(getTableItems("No Disputes Found"), "").size();
		return size;
	}
	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

}
