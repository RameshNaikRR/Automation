package coyni.admin.components;

import org.openqa.selenium.By;


import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CalenderComponent extends BrowserFunctions {
		 private By txtStartDate = By.xpath("//span[text()='Start Date']/following-sibling::span");
	     private By txtEndDate = By.xpath("//span[text()='End Date']/following-sibling::span");
	     
	     private void VerifyDate(By dateEle,String date,String eleName) {
	    	String dateValue = getAttributeValue(dateEle, "value", eleName); 
	    	if (dateValue.equals(date)) {
				ExtentTestManager.setInfoMessageInReport(String.format("%s %s selected", eleName,date));
			}else {
				ExtentTestManager.setFailMessageInReport(String.format("%s %s selected instead of %s",eleName,dateValue,date));
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
		    	return By.xpath(String.format("//div[contains(@class,\"react-datepicker__day react-datepicker__day--007\")]", date));
		 }
		    
	    public void clickSelectDate(String date) {
		    	click(getDate(date), "date");
		       
		}
	     
	     public DatePickerComponent datePickerComponent() {
	    	 return new DatePickerComponent();
	     }

		
	}

