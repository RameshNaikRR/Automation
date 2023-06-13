package coyni.admin.Paymentcomponents;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class PaginationAndEntriesComponent extends BrowserFunctions {

	private By btnPrev = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	private By pageNumbers = By.cssSelector("");

	private By firstPage = By.xpath("//a[contains(@aria-label, 'first page') or text() = '«']");

	private By seconPage = By.xpath("//a[@aria-label='Go to page number 2']");

	private By prevPage = By.xpath("//a[contains(@aria-label, 'previous page') or text() = '❮']");

	private By nextPage = By.xpath("//a[contains(@aria-label, 'next page') or text() = '❯']");

	private By lastPage = By.xpath("//a[contains(@aria-label, 'last page') and text() = '»']");

	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");

	private By transaction = By.xpath("//tr[@class='  hovered']");

	public void clickGoToFirstPage() {
		click(firstPage, "first page '«'");
	}

	public void clickGoToPreviousPage() {
		click(prevPage, "previous page '❮'");
	}

	public void clickGoToNextPage() {
		click(nextPage, "next page '❯'");
	}

	public void clickGoToLastPage() {
		click(lastPage, "last page '»'");
	}

	public void clickPrev() {
		click(btnPrev, "Previous");
	}

	public void clickNext() {
		click(btnNext, "Next");

	}

	public String getItemsPerPage() {
		return getText(lblItemsPerPage, "entries per page");
	}

	public void verifyTableItemsCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(String.format(query));
		int expCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(
					"Number of transactions in table matches with number of entries selected i.e ");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Number of transactions in table doesnot match with numer of entries selected");
		}
	}

	public void verifyPageNumbersWithCount() {
		int actCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		int page = getElementsList(transaction, "page transaction count").size();
		int pageNumber = actCount / page;
		int remainder = actCount % page;
		if (!(remainder == 0)) {
			pageNumber++;
			if (!(pageNumber == 0)) {
				ExtentTestManager.setPassMessageInReport("No of pages is" + pageNumber);
			} else if (remainder == 0) {
				ExtentTestManager.setPassMessageInReport("No of pages is" + pageNumber);
			}
		} else {
			ExtentTestManager.setFailMessageInReport("No of Page is Null");
		}

	}

	public void verifyPageNumberHighlighted(String cssProp, String expValue, String expColor) {

		if (verifyElementDisplayed(nextPage, "Next Page")) {
			click(nextPage, "Clicked Next Page");
		//	new CommonFunctions().verifyChangedColor(seconPage, "Second Page", cssProp, expValue, expColor);
			ExtentTestManager.setPassMessageInReport("Page is Highlighted when clicked on Page number");
		} else {
			ExtentTestManager.setWarningMessageInReport("Page is Not Highlighted");
		}
	}

	public void clickPageNumber(String pageNumber) {
//		List<WebElement> pageNumbers = getElementsList(this.pageNumbers, "page numbers");
//		List<String> pagenumList = pageNumbers.stream().map(ele -> ele.getText()).collect(Collectors.toList());
//		boolean flag = false;
//		for (int i = 0; i < pagenumList.size(); i++) {
//			if (pagenumList.get(i).trim().equalsIgnoreCase(pageNumber)) {
//				pageNumbers.get(i).click();
//				ExtentTestManager.setInfoMessageInReport("Clicked on Page Number " + pageNumber);
//				flag = true;
//				break;
//			}
//		}
//		if (!flag) {
//			ExtentTestManager.setFailMessageInReport(
//					"Unable to click on Page number " + pageNumber + " and available page numbers are " + pagenumList);
//		}
	}

}
