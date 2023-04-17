package CommonEmail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import coyni_mobile_merchant.pages.BusinessTokenAccountPage;
import coyni_mobile_merchant.pages.LandingPage;
import coyni_mobile_merchant.pages.LoginPage;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.android.AndroidDriver;

public class Appium_AppLaunch_BrowserStack {

	public static final String UserName="tarakam_5BcN1s";
	public static final String AutomateKey="eL52mRq5apoFpJXK36Qf";
	public static final String URL="https://"+UserName+":"+AutomateKey+"@hub-cloud.browserstack.com/wd/hub";
	BusinessTokenAccountPage businessTokenAccountPage;
	
	@BeforeTest
	public void Setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName","Google Pixel 7");
		caps.setCapability("os_version","13.0");
		caps.setCapability("Project","Coyni");
		caps.setCapability("build","2.2.3");
		caps.setCapability("name","BrowserStack Sample");
		caps.setCapability("app","bs://fff69f254d7348584beaeca77da5c52817e9fedb");		
		URL url = new URL(URL);
		AndroidDriver driver = new AndroidDriver(url, caps);
		driver.findElement(By.id("com.coyni.mapp:id/layoutLogin")).click();
		driver.findElement(By.xpath("//*[contains(@resource-id,'etEmail')] | (//*[contains(@name,'Email')])[1]")).sendKeys("bicipat748@topyte.com");
		driver.findElement(By.xpath("//*[contains(@resource-id,'etPassword')] | (//*[contains(@name,'Password')])[1]")).sendKeys("Merch@123");
		driver.findElement(By.xpath("//*[contains(@resource-id,'cvNext')]")).click();
		businessTokenAccountPage = new BusinessTokenAccountPage();

	}
	
	
	public void testLogin() {
		try {
			LandingPage landingPage = new LandingPage();
//			landingPage.clickGetStartedLogin();
			landingPage.clickLogin();
			LoginPage loginPage = new LoginPage();
			loginPage.AppUpdate();
			loginPage.VerifyLoginPageView();
			loginPage.verifyEmailview();
			loginPage.verifyPasswordview();
			loginPage.verifyRememberMeView();
////			loginPage.fillEmail(data.get("email"));
////			loginPage.fillPassword(data.get("password"));l
////			loginPage.verifyPasswordMaskedView(data.get("password"));
////			loginPage.verifyColour();
//			loginPage.clickLogin();
//			loginPage.enterYourPINComponent().verifyEnterYourPinView();
//			loginPage.enterYourPINComponent().fillPin(data.get("pin"));
//			loginPage.enterYourPINComponent().enableFaceIDpage().verifyEnableFaceIdView();
//			loginPage.enterYourPINComponent().enableFaceIDpage().clickNotNow();
//			loginPage.agreementComponent().verifyTermsOfServiceUpdate(data.get("termsUpdateHeading"));
//			loginPage.agreementComponent().verifyPrivacyPolicyHeading(data.get("privacyUpdateHeading"));
//			businessTokenAccountPage.getUserName();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Login failed due to Exception " + e);
		}
	}
}
	
