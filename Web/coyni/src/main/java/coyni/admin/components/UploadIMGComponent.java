package coyni.admin.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class UploadIMGComponent extends BrowserFunctions {
	public static WebDriver driver;
	private By btnSelectImage = By.xpath("//p[text()='Click to select Image']");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By dropwnUserName = By.cssSelector(".down-arrow");
	private By lnkUserDetails = By.xpath("//button[text()='User Details']");
	private By heading = By.xpath("//h1[text()='Account Profile Image']");
	private By editUserImage = By.cssSelector(".w-4");
	private By btnUploadNewImage = By.xpath("//button[text()='Upload New Image']");
	private By btnUploadNewIm = By.xpath("//p[text()='Click to select Image']/preceding-sibling::input");
	private By headings = By.cssSelector("//h1[text()='Crop Your Image']");// crop

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}

	public void clickUserName() {
		click(dropwnUserName, "UserName");
	}

	public void clickUserDetails() {
		click(lnkUserDetails, "UserDetails");
	}

	public void clickEditUserImage() {
		click(editUserImage, "Edit User Image");
	}

	public void clickUploadNewImage() {
		click(btnUploadNewImage, "Upload New Image");
	}

	public void verifyHeadingsCrop(String expHeading) {
		//click(btnUploadNewImage, "Upload New Image");
		new CommonFunctions().verifyLabelText(headings, "heading", expHeading);
	}
	private By getUploadDocumentElement() {
		return By.xpath(String.format("//*[contains(@class,'font-bold text-cwhite')]/../input"));
	}

	public void uploadSelectImage(String folderName, String fileName) {
		getElement(getUploadDocumentElement(), "select Image").sendKeys(FileHelper.getFilePath(folderName, fileName));
	}


	public void clickSave() {
		click(btnSave, "Save");
	}
	//---------------------
	private By btnremove=By.xpath("//span[text()='Remove Image']");
	private By lblRemoveHeading=By.xpath("//h1[text()='Remove Profile Image']");
	private By lblContentRemove=By.cssSelector(".pb-12");
	private By btnRemove=By.xpath("//button[text()='Remove']");
	
	public void verifyRemoveHeading(String removeHeading) {
		new CommonFunctions().verifyLabelText(lblRemoveHeading, "Remove Profile Image", removeHeading);
	}
	public void verifyContent(String content) {
		new CommonFunctions().verifyLabelText(lblContentRemove, "content", content);
	}
	
	
	public void clickRemove() {
		click(btnRemove, "Remove");
	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	
	public void clickRemoveImg() {
		click(btnremove, "Remove Image");
	}
	
	
	
	

}
