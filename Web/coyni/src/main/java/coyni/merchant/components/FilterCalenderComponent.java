package coyni.merchant.components;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.LongStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class FilterCalenderComponent extends BrowserFunctions {
	private static final String DATE_FORMAT = "MM dd yyyy";
	private static final String DAY_FIRST = "01";
	private static final String SPACE = " ";
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public String currentDay() {
		LocalDate dt = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		return formatter.format(dt);
	}

	/*
	 * Added new Code
	 */
	public String previousTenDays() {
		LocalDate dt = LocalDate.now().minusDays(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		return formatter.format(dt);
	}

	public String nextDay() {
		LocalDate dt = LocalDate.now().plusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		return formatter.format(dt);
	}

	@FindBy(css = ".react-datepicker__navigation--previous")
	private WebElement prev;

	@FindBy(css = ".react-datepicker__navigation--next")
	private WebElement next;

	@FindBy(xpath = "(//div[contains(@class,'current-month')])[1]")
	private WebElement curDate;

	@FindBy(xpath = "(//div[contains(@class,'current-month')])[1]/../following-sibling::*[1]//div[contains(@class,'react-datepicker__day react-datepicker__day') and not(contains(@class,'outside'))]")
	private List<WebElement> dates;

	@FindBy(xpath = "//div[@class='rc_body-cell' or @class='rc_body-cell rc_this_year']")
	private List<WebElement> years;

	@FindBy(xpath = "//div[@class ='rc_body-cell' or@class='rc_body-cell rc_this_month']")
	private List<WebElement> months;

	@FindBy(xpath = "//button[@class='rc_header_label rc_header_label-years']")

	private WebElement address;

	public FilterCalenderComponent() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public String currentDay1() {
		LocalDate dt = LocalDate.now();
		// .plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		return formatter.format(dt);
	}

	public String previous10Days() {
		LocalDate dt = LocalDate.now().minusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		return formatter.format(dt);
	}

	public void setPrevious10Date() {
		String temp = previous10Days();
		// date = date.replace("/", " ");
		System.out.println(temp);
		long diff = this.getDateDifferenceInMonths(temp);
		int day = this.getDay(temp);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);

		// click the arrows
		LongStream.range(0, diff).forEach(i -> arrow.click());

		// select the date
		dates.stream().filter(ele -> !ele.getText().equals("")).filter(ele -> Integer.parseInt(ele.getText()) == day)
				.findFirst().ifPresent(WebElement::click);
		System.out.println(temp + " selected from Calendar");
	}
	

	public void setDate() {
		String temp = currentDay1();
		// date = date.replace("/", " ");
		System.out.println(temp);
		long diff = this.getDateDifferenceInMonths(temp);
		int day = this.getDay(temp);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);

		// click the arrows
		LongStream.range(0, diff).forEach(i -> arrow.click());

		// select the date
		dates.stream().filter(ele -> !ele.getText().equals("")).filter(ele -> Integer.parseInt(ele.getText()) == day)
				.findFirst().ifPresent(WebElement::click);
		System.out.println(temp + " selected from Calendar");
	}

	/*
	 * Added new Code
	 */
	public void clickCurrentDay() {
		String temp = date();
		temp = temp.replace("/", " ");
		System.out.println(temp);
		long diff = this.getDateDifferenceInMonths(temp);
		int day = this.getDay(temp);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);

		// click the arrows
		LongStream.range(0, diff).forEach(i -> arrow.click());

		// select the date
		dates.stream().filter(ele -> !ele.getText().equals("")).filter(ele -> Integer.parseInt(ele.getText()) == day)
				.findFirst().ifPresent(WebElement::click);
		System.out.println(temp + " selected from Calendar");
	}

	public void clickPreviousTenDays() {
		String temp = previousTenDays();
		temp = temp.replace("/", " ");
		System.out.println(temp);
		long diff = this.getDateDifferenceInMonths(temp);
		int day = this.getDay(temp);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);

		// click the arrows
		LongStream.range(0, diff).forEach(i -> arrow.click());

		// select the date
		dates.stream().filter(ele -> !ele.getText().equals("")).filter(ele -> Integer.parseInt(ele.getText()) == day)
				.findFirst().ifPresent(WebElement::click);
		System.out.println(temp + " selected from Calendar");
	}

	public String date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public void clickCustomDate() throws InterruptedException {
		String temp = currentDay();
		System.out.println(temp);
		String date1 = currentDay().replace(" ", " ");
		System.out.println(date1);
		long diff = this.getDateDifferenceInMonths(date1);
		int day = this.getDay(date1);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);

		// click the arrows
		LongStream.range(0, diff).forEach(i -> arrow.click());

		// select the date
		Thread.sleep(2000);
		dates.stream().filter(ele -> !ele.getText().equals("")).filter(ele -> Integer.parseInt(ele.getText()) == day)
				.findFirst().ifPresent(WebElement::click);
		System.out.println(currentDay() + " selected from Calendar");
	}

	public void generateDate() throws InterruptedException {
		String temp = nextDay();
		System.out.println(temp);
		String date1 = nextDay().replace(" ", " ");
		System.out.println(date1);
		long diff = this.getDateDifferenceInMonths(date1);
		int day = this.getDay(date1);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);

		// click the arrows
		LongStream.range(0, diff).forEach(i -> arrow.click());

		// select the date
		Thread.sleep(2000);
		dates.stream().filter(ele -> !ele.getText().equals("")).filter(ele -> Integer.parseInt(ele.getText()) == day)
				.findFirst().ifPresent(WebElement::click);
		System.out.println(temp + " selected from Calendar");
	}

	private int getDay(String date) {
		System.out.println(date);
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		return dpToDate.getDayOfMonth();
	}

	private long getDateDifferenceInMonths(String date) {

		System.out.println(date);
		LocalDate dpCurDate = LocalDate.parse(DAY_FIRST + SPACE + this.getCurrentMonthFromDatePicker(),
				DateTimeFormatter.ofPattern("dd MMMM yyyy"));
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		System.out.println(YearMonth.from(dpCurDate).until(dpToDate, ChronoUnit.MONTHS));
		return YearMonth.from(dpCurDate).until(dpToDate, ChronoUnit.MONTHS);
	}

	private String getCurrentMonthFromDatePicker() {
		return this.curDate.getText().replace("\n", " ");
	}

	private long getDateDifferenceInYears(String date) {
		System.out.println(date);
		LocalDate dpCurDate = LocalDate.parse(DAY_FIRST + SPACE + this.getCurrentMonthFromDatePicker(),
				DateTimeFormatter.ofPattern("dd MMMM yyyy"));
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		System.out.println(Year.from(dpToDate).until(dpCurDate, ChronoUnit.YEARS));
		return Year.from(dpToDate).until(dpCurDate, ChronoUnit.YEARS);
	}

	private String getMonth(String date) {
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		// String month = dpToDate.getMonth().toString();
		return dpToDate.getMonth().toString();
	}

	public void setDateWithYear(String date) throws InterruptedException {
		String year = date.split("/")[2];
		System.out.println(year);
		String temp = date;
		date = date.replace("/", " ");
		System.out.println(date);
		long yearDiff = this.getDateDifferenceInYears(date);
		String month = this.getMonth(date);
		int day = this.getDay(date);

		curDate.click();
		System.out.println(address.getText());
		String lower = address.getText().split("-")[0];
		String upper = address.getText().split("-")[1];
		int upp = Integer.parseInt(upper);
		int low = Integer.parseInt(lower);
		int yr = Integer.parseInt(year);
		long count = years.stream().count();
		System.out.println(count);

		yearDiff = Math.abs(yearDiff);
		long i1 = yearDiff / count;
		int arrowNext = (int) Math.floor(i1);
		System.out.println(arrowNext);

		if (yr <= upp && yr >= low) {
			System.out.println("Year is Middle");
		} else if (yr < low) {
			for (int i = 0; i <= arrowNext; i++) {
				prev.click();
			}
		} else {
			for (int i = 1; i <= arrowNext; i++) {
				next.click();
			}
		}

		years.stream().filter(ele -> ele.getText().equals(year)).findFirst().ifPresent(WebElement::click);
		// select month
		months.stream().filter(ele -> ele.getText().equalsIgnoreCase(month)).findFirst().ifPresent(WebElement::click);

		// select the date
		dates.stream().filter(ele -> !ele.getText().equals("") && ele.isEnabled())
				.filter(ele -> Integer.parseInt(ele.getText()) == day).findAny().ifPresent(WebElement::click);

	}

	// -----------------------------
	private By txtStartDate = By.xpath("(//span[text()='Select Date'])[1]");// span[text()='Select
																			// Date']/following-sibling::span
	private By txtEndDate = By.xpath("(//span[text()='Select Date'])[2]");// span[text()='End
																			// Date']/following-sibling::span

	private void VerifyDate(By dateEle, String date, String eleName) {
		String dateValue = getAttributeValue(dateEle, "value", eleName);
		if (dateValue.equals(date)) {
			ExtentTestManager.setInfoMessageInReport(String.format("%s %s selected", eleName, date));
		} else {
			ExtentTestManager
					.setFailMessageInReport(String.format("%s %s selected instead of %s", eleName, dateValue, date));
		}
	}

	public void verifyStartDate(String startDate) {
		click(txtStartDate, "Start Date");
		VerifyDate(txtStartDate, startDate, "Start Date");
	}

	public void verifyEndDate(String endDate) {
		click(txtEndDate, "End Date");
		VerifyDate(txtEndDate, endDate, "End Date");
	}

	public void clickStartDate() {
		click(txtStartDate, "Start Date");
	}

	public void clickEndDate() {
		click(txtEndDate, "End Date");
	}

	private By getDate(String date) {
		return By.xpath(
				String.format("//div[contains(@class,\"react-datepicker__day react-datepicker__day--007\")]", date));
	}

	private By getDate1(String date) {
		return By.xpath(String.format(
				"//div[contains(@class,\"react-datepicker__day react-datepicker__day--001 react-datepicker__day--weekend\")]",
				date));
	}

	public void clickSelectDate(String date) {
		click(getDate(date), "date");

	}

	public void clickSelectDate1(String date) {
		click(getDate1(date), "date");

	}

}
