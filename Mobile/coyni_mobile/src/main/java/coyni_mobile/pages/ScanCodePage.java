package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanCodePage extends MobileFunctions {
  private By btnFlashLight = MobileBy.xpath(" ");
  
  public void clickFlashLight() {
	  click(btnFlashLight, "FlashLight");
  }
}
