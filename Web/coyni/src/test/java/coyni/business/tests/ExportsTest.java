package coyni.business.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import coyni.business.components.ExportFileComponent;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ExportsTest {
	HomePage homePage;
	ExportFileComponent exportFileComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		exportFileComponent = new ExportFileComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testExportFilesTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickExportedFiles();
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
			exportFileComponent.clickDownload();
			exportFileComponent.verifySuccess();
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
			exportFileComponent.clickchkboxBulkActions();
			exportFileComponent.clickBulkActions();
			exportFileComponent.clickBulkDownload();
			exportFileComponent.clickApply();
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
			exportFileComponent.clickchkboxFirstExport();
			exportFileComponent.clickBulkAction();
			exportFileComponent.clickchkboxTrash();
			exportFileComponent.clickApply();
			// exportfilecomponent.toastComponent().verifyToast(data.get("title"),
			// data.get("message"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testExportFilesTest Failed due to Exception " + e);
		}
	}

}
