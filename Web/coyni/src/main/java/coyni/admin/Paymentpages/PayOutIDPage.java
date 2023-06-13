package coyni.admin.Paymentpages;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.ExportComponent;
import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class PayOutIDPage extends BrowserFunctions {

	private By lblCommission = By.xpath("(//span[contains(@class,'text-xl font-bold text-cgy4')])[2]");

	private By lblHeading = By.xpath("//span[contains(text(),'Payout ID')]");

	private By lblPayOutDate = By.xpath("//span[contains(text(),'Payout Date:')]/following-sibling::*[1]");

	private By lblPayOutAmount = By.xpath("//span[contains(text(),'Payout Amount:')]/following-sibling::*[1]");
	private By lblvolume = By.xpath("//span[contains(@class,'text-lg font-bold text-right w-52 text-cgy4')]");
	private By lblTransactionReference = By
			.xpath("//span[contains(text(),'Transaction Reference ID:')]/following-sibling::*[1]");
	private By lblPayoutCommission = By.xpath("//span[contains(@class,'text-lg font-bold text-right w-44 text-cgy4')]");
	private By lblTransactionCount = By.xpath("//span[contains(@class,'text-lg font-bold text-right w-52 text-cgy4')]");

	private By lblToTokenAccount = By.xpath("//span[contains(text(),'To Token Account:')]/following-sibling::*[1]");
	private By txtPayOutId = By.xpath("//span[contains(@class,'text undefined')]");
	private By lblAmount=By.xpath("//span[contains(@class,'w-56 text-lg font-bold text-right text-cgy4')]");

	public String getPayoutId() {
		String text = getText(txtPayOutId, "PayOut Id");
		String replace = text.replace("Payout ID ", "");
		ExtentTestManager.setInfoMessageInReport(replace);
		return replace;
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPayOutHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutDate, "Pay Out Date", expHeading);
	}

	public void getPayOutDate() {
		ExtentTestManager.setInfoMessageInReport("PayOut Date: " + getText(lblPayOutDate, "Payout Date"));
	}

	public void getPayOutAmount() {
		ExtentTestManager.setInfoMessageInReport("PayOut Amount: " + getText(lblPayOutAmount, "Payout Amount"));
	}

	public void getTransactionReference() {
		ExtentTestManager.setInfoMessageInReport(
				"Transaction Reference: " + getText(lblTransactionReference, "Transaction Reference"));
	}

	public void getToTokenAccount() {
		ExtentTestManager.setInfoMessageInReport("To Token Account: " + getText(lblToTokenAccount, "To Token Account"));
	}

	public void getTransactionCount() {
		String text = getText(lblTransactionCount, "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Total Transaction Count is " + text);
	}
	// span[contains(@class,'w-56 text-lg font-bold text-right text-cgy4')]

	public void getVolumeCount() {
		String text = getText(lblvolume, "Volume Processed");
		ExtentTestManager.setInfoMessageInReport("Volume Processed is " + text);
	}
	// span[contains(@class,'text-lg font-bold text-right w-44 text-cgy4')]

	public String getCommission() {
		String text = getText(lblCommission, "Total Commisssion");
		String replace = text.replace(" ", "");
		ExtentTestManager.setInfoMessageInReport("Total Commisssion is " + replace);
		return replace;
	}

	public String getPayoutCommission() {
		String text = getText(lblPayoutCommission, "Payout Commisssion");
		String replace = text.replace(" ", "");
		ExtentTestManager.setInfoMessageInReport("Payout Commisssion is " + replace);
		return replace;
	}

	public int transactionCount() {
		String text = getText(lblTransactionCount, "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Total amount is " + text);
		return Integer.parseInt(text);
	}
	
	public int transactionAmount() {
		String text = getText(lblAmount, "Transaction Amount");
		String replace = text.replace("CYN", "");
		ExtentTestManager.setInfoMessageInReport("Total amount is " + replace);
		return Integer.parseInt(replace);
	}

	public String query() {
		String query = String.format("select paid_transaction_count from total_transaction  where batch_id_dn ='%s'",
				getPayoutId());
		ExtentTestManager.setInfoMessageInReport("Total Transaction is " + query);
		return query;
	}

	
	
	public void getTotalTransactionCount() throws SQLException {
		
		int count = DBConnection.getDbCon().getCount(query());
		int expCount = transactionCount();
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Total Transaction count is  martched");
		} else {
			ExtentTestManager.setFailMessageInReport("Total Transaction count is not martched");
		}
	}
	public String queryforTotalTransaction() {
		String query = String.format("select total_amount from total_transaction  where batch_id_dn ='%s'",
				getPayoutId());
		ExtentTestManager.setInfoMessageInReport("Total amount is " + query);
		return query;
	}

	public void getTotalAmount() throws SQLException {
		int count = DBConnection.getDbCon().getCount(queryforTotalTransaction());
		int expCount = transactionAmount();
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Total  amount is  martched");
		} else {
			ExtentTestManager.setFailMessageInReport("Total  amount is not martched");
		}
	}
	
}
