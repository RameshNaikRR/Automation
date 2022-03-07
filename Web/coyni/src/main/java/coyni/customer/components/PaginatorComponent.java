package coyni.customer.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PaginatorComponent extends BrowserFunctions {
	
	private By btnPrev = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	private By pageNumbers = By.cssSelector("");
	
	public void clickPrev() {
		click(btnPrev, "Previous");
	}
	public void clickNext() {
		click(btnNext, "Next");
		
	}
	public void clickPageNumber(String pageNumber) {
//		List<WebElement> pageNumbers = getElementsList(this.pageNumbers, "page numbers");
//		List<String> pagenumList = pageNumbers.stream().map(ele -> ele.getText()).collect(Collectors.toList());
//		boolean flag = false;
//		for(int i =0; i< pagenumList.size(); i++) {
//			if(pagenumList.get(i).trim().equalsIgnoreCase(pageNumber)) {
//				pageNumbers.get(i).click();
//				ExtentTestManager.setInfoMessageInReport("Clicked on Page Number "+pageNumber);
//				flag = true;
//				break;
//			}	
//		}
//		if(!flag) {
//			ExtentTestManager.setFailMessageInReport("Unable to click on Page number "+pageNumber+" and available page numbers are "+ pagenumList);
//		}
	}
	

}
