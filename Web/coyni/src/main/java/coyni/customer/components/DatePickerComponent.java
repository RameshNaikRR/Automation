package coyni.customer.components;


import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.LongStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class DatePickerComponent {

	private static final String DATE_FORMAT = "MM dd yyyy";
	private static final String DAY_FIRST = "01";
	private static final String SPACE = " ";
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_FORMAT);

	@FindBy(xpath = "//button[@class=\"rc_header_nav rc_header_nav-prev\"]")
	private WebElement prev;



	@FindBy(xpath = "//button[@class=\"rc_header_nav rc_header_nav-next\"]")
	private WebElement next;



	@FindBy(css = ".rc_header_label-days-of-month")
	private WebElement curDate;



	@FindBy(xpath = "//div[@class=\"rc_body-cell_value\"]")
	private List<WebElement> dates;

	@FindBy(xpath = "//div[@class='rc_body_cell' or @class='rc_body-cell rc_this_year']")
	private List<WebElement> years;

	@FindBy(xpath = "//div[@class ='rc_body-cell' or@class='rc_body-cell rc_this_month']")
	private List<WebElement> months;



	public DatePickerComponent(){
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}



	public void setDate(String date) {
		String temp = date;
		date = date.replace("/", " ");
		System.out.println(date);
		long diff = this.getDateDifferenceInMonths(date);
		int day = this.getDay(date);
		WebElement arrow = (diff >= 0 ? next : prev);
		diff = Math.abs(diff);



		//click the arrows
		LongStream.range(0, diff)
		.forEach(i -> arrow.click());



		//select the date
		dates.stream()
		.filter(ele -> !ele.getText().equals(""))
		.filter(ele -> Integer.parseInt(ele.getText()) == day)
		.findFirst()
		.ifPresent(WebElement::click);
		ExtentTestManager.setInfoMessageInReport(temp + " selected from Calendar");
	}



	private int getDay(String date) {
		System.out.println(date);
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		return dpToDate.getDayOfMonth();
	}

	private String getMonth(String date) {
		System.out.println(date);
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		return dpToDate.getMonth().toString();
	}



	private long getDateDifferenceInMonths(String date) {

		System.out.println(date);
		LocalDate dpCurDate = LocalDate.parse(DAY_FIRST + SPACE + this.getCurrentMonthFromDatePicker(), DateTimeFormatter.ofPattern("dd MMMM yyyy"));
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		System.out.println(YearMonth.from(dpCurDate).until(dpToDate,  ChronoUnit.MONTHS));
		return YearMonth.from(dpCurDate).until(dpToDate, ChronoUnit.MONTHS);
	}

	private long getDateDifferenceInYears(String date) {

		System.out.println(date);
		LocalDate dpCurDate = LocalDate.parse(DAY_FIRST + SPACE + this.getCurrentMonthFromDatePicker(), DateTimeFormatter.ofPattern("dd MMMM yyyy"));
		LocalDate dpToDate = LocalDate.parse(date, DTF);
		System.out.println(Year.from(dpCurDate).until(dpToDate,  ChronoUnit.YEARS));
		return Year.from(dpCurDate).until(dpToDate, ChronoUnit.YEARS);
	}



	private String getCurrentMonthFromDatePicker() {
		return this.curDate.getText().replace("/n", " ");
	}

	public void setDateAndYear(String date) {
		String year = date.split("/")[2];
		date = date.replace("/", " ");
		System.out.println(date);

		long yeardiff = this.getDateDifferenceInYears(date);
		String month = this.getMonth(date);
		//click the month in the middle
		curDate.click(); 
		//select year
		years.stream().filter(ele ->ele.getText().equals(year)).findFirst().ifPresent(WebElement::click);

		WebElement arrow = (yeardiff > 0 ? next : prev);
		yeardiff = Math.abs(yeardiff);

		//click the arrows



		//select years after clicking on arrow
		years.stream().filter(ele ->ele.getText().equals(year))
		.findFirst()
		.ifPresent(WebElement::click);

		//select month
		months.stream().filter(ele ->ele.getText().equalsIgnoreCase(month))
		.findFirst()
		.ifPresent(WebElement::click);


	}






}





