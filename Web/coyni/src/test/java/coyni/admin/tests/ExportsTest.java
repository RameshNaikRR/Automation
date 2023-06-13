package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.ExportFileComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ExportsTest {

	HomePage homePage;
	ExportFileComponent exportfilecomponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		exportfilecomponent = new ExportFileComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFilesTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarComponent().verifyCursorAction();
			// homePage.sideBarComponent().verifyMouseHoverChangedColor("cssProp",
			// "expValue", "expColor");
			homePage.sideBarComponent().clickExportedFiles();
			// homePage.sideBarComponent().verifyExportFiles(data.get("exportHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportFilesTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDownloadExportFile(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickExportedFiles();
			exportfilecomponent.clickDownload();
			exportfilecomponent.verifySuccess();
			// exportfilecomponent.toastComponent().verifyToast(data.get("title"),
			// data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDownloadExportFile Failed due to Exception " + e);
		}
	}

//
	@Test
	@Parameters({ "strParams" })
	public void testDownloadMultipleExportFiles(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickExportedFiles();
			exportfilecomponent.clickchkboxBulkActions();
			exportfilecomponent.clickBulkActions();
			exportfilecomponent.clickBulkDownload();
			exportfilecomponent.clickApply();
			// exportfilecomponent.toastComponent().verifyToast(data.get("title"),
			// data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDownloadMultipleExportFiles Failed due to Exception " + e);
		}
	}

//
	@Test
	@Parameters({ "strParams" })
	public void testTrashExportFile(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickExportedFiles();
			exportfilecomponent.clickchkboxFirstExport();
			exportfilecomponent.clickBulkAction();
			exportfilecomponent.clickchkboxTrash();
			exportfilecomponent.clickApply();
			// exportfilecomponent.toastComponent().verifyToast(data.get("title"),
			// data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportFilesTest Failed due to Exception " + e);
		}
	}

}
