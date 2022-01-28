package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;


public class ExportfilesPage extends BrowserFunctions{
   private By lnkExportFiles = By.xpath("(//span[contains(text(),'Export Files')])[1]");
   private By lblExportID = By.xpath("//span[text()='EXPORT ID'] ");
   private By lblReportName = By.xpath("//span[text()='REPORT NAME']");
   private By lblExportDate = By.xpath("//span[text()='EXPORT DATE']");
   private By lblDateRange = By.xpath(" //span[text()='DATE RANGE']");
   private By lblStatus = By.xpath(" //span[text()='STATUS']");
   private By idCheckBox = By.xpath("(//td[@class=\"cell-col-0\"])[1]");
   
   public void clickExportfiles() {
	   click(lnkExportFiles, "Export files");
   }
   public void ExportIdView() {
	   new CommonFunctions().elementView(lblExportID, "Export Id");
   }
   public void ReportNameView() {
	   new CommonFunctions().elementView(lblReportName, "Report Name");
   }
   public void ExportDateView() {
	   new CommonFunctions().elementView(lblExportDate, "Export Date");
   }
   public void DateRangeView() {
	   new CommonFunctions().elementView(lblDateRange, "DateRange");
   }
   public void StatusView() {
	   new CommonFunctions().elementView(lblStatus, "Status");
   }
  public void verifyIdFormat() {
	  String id = getText(idCheckBox, "Export id");
	  if (id.matches("[0-9]*")){
		  ExtentTestManager.setPassMessageInReport("Export id is in digits");
	  }
	  else {
		  ExtentTestManager.setFailMessageInReport("Export id is not in digits format");
	  }
  }
   
  
	 }




   
   
   
   
   
   
   
	
	

