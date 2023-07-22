package coyni_mobile.pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;

public class VisualTestingClass extends MobileFunctions {

	private final static String Validation_path = "\\Users\\ideyaLabs\\Desktop\\images";
	private final static String login_Screen = "login";
	private final static String pin = "pinn";
	private final static String BASELINE = "BASELINE_";
	private final static double MATCH_THRESHOLD = 0.99;

	private final static By landingLogin = MobileBy.AccessibilityId("Log in");
	private final static By Login = MobileBy.AccessibilityId("nav-cart");
	private By txtEmail = MobileBy.id("com.coyni.mapp:id/emailET");
	private By txtPassword = MobileBy.AccessibilityId("Password");

	public void testAppDesign() throws Exception {
		// now we know the home screen is loaded, so do a visual check
		// Click on add to cart btn for adding item in card
		click(landingLogin, "Login");
		// perform our second visual check, this time Login Screen
		doVisualCheck(login_Screen);
	}

	public void testLoginScreen() throws Exception {
		doVisualCheck(login_Screen);
	}

	public void testPinScreen() throws Exception {
		doVisualCheck(pin);
	}

	private void doVisualCheck(String checkName) throws Exception {
		String baselineFilename = Validation_path + "/" + BASELINE + checkName + ".png";
		File baselineImg = new File(baselineFilename);

		// If no baseline image exists for this check, we should create a baseline image
		if (!baselineImg.exists()) {
			System.out.println(String.format("No baseline found for '%s' check; capturing baseline instead of checking",
					checkName));
			File newBaseline = DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(newBaseline, new File(baselineFilename));
			return;
		}

		// Otherwise, if we found a baseline, get the image similarity from Appium. In
		// getting the similarity,
		// we also turn on visualization so we can see what went wrong if something did.
		SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
		opts.withEnabledVisualization();
		SimilarityMatchingResult res = DriverFactory.getDriver().getImagesSimilarity(baselineImg,
				DriverFactory.getDriver().getScreenshotAs(OutputType.FILE), opts);

		// If the similarity is not high enough, consider the check to have failed
		if (res.getScore() < MATCH_THRESHOLD) {
			File failViz = new File(Validation_path + "/FAIL_" + checkName + ".png");
			res.storeVisualization(failViz);
			throw new Exception(String.format(
					"Visual check of '%s' failed; similarity match was only %f, and below the threshold of %f. Visualization written to %s.",
					checkName, res.getScore(), MATCH_THRESHOLD, failViz.getAbsolutePath()));
		}

		// Otherwise, it passed!
		System.out.println(
				String.format("Visual check of '%s' passed; similarity match was %f", checkName, res.getScore()));
	}

}
