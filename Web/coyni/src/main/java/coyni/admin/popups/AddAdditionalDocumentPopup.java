package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class AddAdditionalDocumentPopup extends BrowserFunctions {

	private By heading = By.xpath("//h3[contains(text(),'Add Additional Documents')]");
	private By chkbx   = By.xpath("(//input[@type='checkbox'])[1]");
	private By btnAdd = By.xpath("//button[text()='Add']");
	  private By btnCustomDoc = By.xpath("//span[text()='Custom Document']");
	    private By txtNewTask = By.xpath("//textarea[@id='newTask']");
	    private By btnNewTaskAdd = By.xpath("(//button[text()='Add'])[1]");
	    private By btnCutsomTask = By.xpath("//span[text()='Custom Task']");
	    private By txtHeader = By.xpath("//textarea[@id='task']");
	    
	    
	    private By getUploadDocumentElement = By
				.xpath(String.format("(//input[@type='file'])[1]"));

		public void uploadSelectImage(String folderName, String fileName) {
			getElement(getUploadDocumentElement, "select Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
		}
	    
	    public void enterHeader(String header) {
	    enterText(txtHeader, header, "Header - Comment");	
	    }
	    
	    public void enterNewTask(String newTask) {
	    	enterText(txtNewTask, newTask, "New Task");
	    }
	    
	    public void clickCustomTask() {
	    	click(btnCutsomTask, "Custom Task");
	    }
	    
	    public void clickNewDocumetAdd() {
	    	click(btnNewTaskAdd, "New Document Add Button");
	    }
	    
	   
	    
	    public void clickCustomDoc() {
	    	click(btnCustomDoc, "Custom DOcument");
	    }

	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading is");
	}
	
	public void clickCheckBox() {
		click(chkbx,"CheckBox");
	}
	
	public void clickAdd() {
		click(btnAdd, "Add");
	}
	
	
	
}
