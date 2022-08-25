package coyni.admin.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.utilities.FileHelper;

public class UploadIMGComponent extends BrowserFunctions {
	public static WebDriver driver;
	private By btnSelectImage = By.xpath("//p[text()='Click to select Image']");
	private By btnSave = By.cssSelector(".UserDetails_container__50Pke>div>button");
	private By dropwnUserName = By.cssSelector(".down-arrow");
	private By lnkUserDetails = By.xpath("//button[text()='User Details']");
	private By heading = By.xpath("//h1[text()='Account Profile Image']");
	private By editUserImage = By.cssSelector(".w-4");
	private By btnUploadNewImage = By.xpath("//button[text()='Upload New Image']");
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
		new CommonFunctions().verifyLabelText(headings, "heading", expHeading);
	}

	public void uploadSelectImage(String folderName, String fileName) {
		getElement(btnUploadNewImage, "fileName").sendKeys(folderName, fileName);

//		WebElement chooseFile = driver.findElement(By.xpath("//button[text()='Upload New Image']"));
//		chooseFile.sendKeys("D:\\Automation-web\\WebRegression(17-08-2022)\\coyni-automation\\Web\\coyni\\Images.jpg");

	}


	public void clickSave() {
		click(btnSave, "Save");
	}

}
