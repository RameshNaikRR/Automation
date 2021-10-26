package coyni.customer.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class HomePage extends BrowserFunctions {
	private By lnkPersonalAccount = By.name("");
	private By lnkBusinessAccount = By.name("");
	private By lnkSignIn = By.name(" ");
	private By heading = By.name("");
	private By lnkLogIn = By.cssSelector("");
	private By lblCreateAccountText = By.cssSelector("");
	private By lblPersonalAccountText = By.cssSelector("");
	private By lblBusinnesAccountText = By.cssSelector("");
    private By lblCreateAPersonAccountText = By.cssSelector("");
    private By SignUpElements = By.cssSelector("");
    private By txtFirstName = By.cssSelector("");
    private By txtLastName = By.cssSelector("");
    private By txtEmail = By.cssSelector("");
    private By txtCreatePasswordFiled = By.cssSelector("");
    private By txtConfirmPasswordFiled = By.cssSelector("");
    private By btnNext = By.cssSelector("");
    private By txtPhoneNumber = By.cssSelector("");
    private By lnkUsLogoDefault = By.cssSelector("");
    private By passErrorMsg = By.cssSelector("");
    private By lnkCreatePasswordShowIcon = By.cssSelector("");
    private By lnkConfirmPasswordShowIcon = By.cssSelector("");
    private By lnkPrivacyPolicy = By.cssSelector("");
    private By lnkTermsOfServices = By.cssSelector("");
    
	public void clickPersonalAccount() {
		click(lnkPersonalAccount, "PersonalAccount");
	}

	public void clickBusinessAccount() {
		click(lnkBusinessAccount, "BusinessAccount");
	}

	public void clickSignIn() {
		click(lnkSignIn, "SignIn");
	}
	public void clickLogIn() {
		click(lnkLogIn, "click LogIn");
	}

	public void verifyHomePageTitle(String expHeading) {
		String actTitle = getPageTitle();
		if (expHeading.equalsIgnoreCase(actTitle)) {
			ExtentTestManager.setPassMessageInReport(String.format("%s is %s", actTitle));
		} else {
			ExtentTestManager.setFailMessageInReport(
					String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", expHeading, actTitle));
		}

	}

	public void verifyCreatAccountLinks(String ase) {
		switch (ase) {
		case "Personal Account":
			verifyElementDisplayed(lnkPersonalAccount, ase);
			break;
		case "Business Account":
			verifyElementDisplayed(lnkBusinessAccount, ase);
			break;
		case "Log In":
			verifyElementDisplayed(lnkLogIn, ase);
			break;
		}
	}


	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "autentication heading",expHeading);
	}
	
	public void verifyCreateAccountText(String expCreateAccountText) {
		new CommonFunctions().verifyLabelText(lblCreateAccountText, "Create Account Text",expCreateAccountText);
	}
	public void verifyPersonalAccountText(String expPersonalAccountText) {
		new CommonFunctions().verifyLabelText(lblPersonalAccountText, "Personal Account Text",expPersonalAccountText);
	}
	public void verifyBusinnesAccountText(String expBusinnesAccountText) {
		new CommonFunctions().verifyLabelText(lblBusinnesAccountText, "BusinnesAccountText",expBusinnesAccountText);
	}
	public void verifyCreateAPersonalAccountText(String expCreateAPersonAccountText) {
		new CommonFunctions().verifyLabelText(lblCreateAPersonAccountText, "BusinnesAccountText",expCreateAPersonAccountText);
	}
	public void verifyFirstNameautoFoucsed() {
	
		
		String attributeValue = getAttributeValue(txtFirstName, "autofoucs", "autofocus");
		
		if( attributeValue.equals("1")) {
			ExtentTestManager.setPassMessageInReport("Autofoucsed");
		
			
		}
		else {
			ExtentTestManager.setFailMessageInReport("Not AutoFoucsed");
		}
	
	}
      public void verifyTabNavigation() throws AWTException {
    	  Robot robot = new Robot();
    	  List<WebElement> str= getElementsList(SignUpElements, "elementsList");
    	  for(int i=0; i<str.size() ; i++) {
    		  robot.keyPress(KeyEvent.VK_TAB);
    		  String focus =str.get(i).getAttribute("focus");
    		  if (focus.equals("true")) {
    			  
    			  ExtentTestManager.setPassMessageInReport("foucsed with tab");
			} else {
				ExtentTestManager.setFailMessageInReport("Not Foucsed in order with Tab");
				break;
			}
    		  
    	  }
	 }
      public void verifyFirstNameValidations(String SingleCharacter) {
    	 enterText(txtFirstName, "FirstName", SingleCharacter);
    	 String gav = getAttributeValue(txtFirstName, "First Name", SingleCharacter);
    	  
    	  if(SingleCharacter == gav) {
    		  
    		  ExtentTestManager.setPassMessageInReport("Accepting "+ SingleCharacter+"character");
    	  }
    	  else {
    		  ExtentTestManager.setFailMessageInReport("Not Accepting "+ SingleCharacter+" character");
    	  }
    	  
      }
      
      
      public void verifyLastNameValidations(String SingleCharacter) {
     	 enterText(txtLastName, "Last Name", SingleCharacter);
     	 String gav = getAttributeValue(txtLastName, "value", SingleCharacter);
     	  
     	  if(SingleCharacter == gav) {
     		  
     		  ExtentTestManager.setPassMessageInReport("Accepting "+ SingleCharacter+"character");
     	  }
     	  else {
     		  ExtentTestManager.setFailMessageInReport("Not Accepting "+ SingleCharacter+" character");
     	  }
     	  
       }
      

      public void phoneNumberValidations(String PhoneNumber) {
    	  enterText(txtPhoneNumber, "Phone Number", PhoneNumber);
    	  String phnnum = getAttributeValue(txtPhoneNumber, "value", PhoneNumber);
    	  int size =phnnum.length();
    	  if(size == 10) {
    		  ExtentTestManager.setPassMessageInReport("Accepting "+ PhoneNumber+"Number");
    		  
    	  }
    	  else {
    		  ExtentTestManager.setFailMessageInReport("Not Accepting "+ PhoneNumber+" Number");
    	  }
      }
      
      
      public void verifyUSLogoDefault() {
    	  verifyElementDisplayed(lnkUsLogoDefault, "Defaul UsLogo");
      }
      public void validateRemainingAttempts(String expAttempts) {
    	  Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
  		String text = getText(passErrorMsg, "password error").replaceAll("[^0-9]", "");
  		if (expAttempts.equals(text)) {
  			ExtentTestManager.setPassMessageInReport("Number of remaining invalid password attemps are " + expAttempts);
  		} else {
  			ExtentTestManager.setFailMessageInReport("Expected of number of remaining password attempts  are "
  					+ expAttempts + " but actual are " + text);
  		}
      }
      
      public void verifyUSnumberForformat(String number) {
    	   Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\\\d{3}-\\d{4}");
    	  Matcher matcher = pattern.matcher(number); 
    	   if (matcher.matches()) {
    		   ExtentTestManager.setPassMessageInReport("US Number Format is mattched (xxx) xxx-xxxx");
     		} else {
     			ExtentTestManager.setFailMessageInReport("US Number Format is not mattched (xxx) xxx-xxxx");
     		}
      }
       
      public void verifyEmailAdressFiledwithReqcharc(String number) {
    	  String reqText=randomStringGen(Integer.parseInt(number));
    	  enterText(txtEmail, "Email Address", reqText);
    	  String actualEmail = getAttributeValue(txtEmail, "value", "Email");
    	  if (actualEmail.length()==reqText.length()) {
   		   ExtentTestManager.setPassMessageInReport("Email text Filed is accepting lenght is "+actualEmail.length());
    		} else {
    			ExtentTestManager.setFailMessageInReport("Email text Filed is not accepting lenght is "+actualEmail.length());
    		}
    	  
      }
      public void verifyEmailAdressFiledWithSpecialCharacters(String reqText) {
    	  enterText(txtEmail, "Email Address", reqText);
    	  String actualEmail = getAttributeValue(txtEmail, "value", "Email");
    	  if (actualEmail.equals(reqText)) {
   		   ExtentTestManager.setPassMessageInReport("Email text Filed is accepting Special Characters is "+reqText);
    		} else {
    			ExtentTestManager.setFailMessageInReport("Email text Filed is not accepting Special Characters is "+reqText);
    		}
    	  
      }
      

      public String randomStringGen( int length) {


    	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    	    StringBuilder sb = new StringBuilder();

    	    Random random = new Random();

    	   

    	    for(int i = 0; i < length; i++) {

    	      int index = random.nextInt(alphabet.length());

    	      char randomChar = alphabet.charAt(index);

    	      sb.append(randomChar);
    	    }

    	    String randomString = sb.toString();

    	    return randomString;
    	  
      }
     
      public void verifyCreatePasswordTextFiled(String Createpassword) {
    	  enterText(txtCreatePasswordFiled,Createpassword,"create password");//San@123$* San123
    	  String actualcrtpwd = getAttributeValue(txtCreatePasswordFiled, "value", "password");
    	  if (actualcrtpwd.equals(Createpassword)) {
   		   ExtentTestManager.setPassMessageInReport("Create password is accepted Uppercase, lower case and numbers and special charcters"+actualcrtpwd);
    		} else {
    			ExtentTestManager.setFailMessageInReport("Create password is NOT accepted Uppercase, lower case and numbers and special charcters"+actualcrtpwd);
    		}
    	  
    	  
      }
      public void verifyConfirmPasswordTextFiled(String Confirmpassword) {
    	  enterText(txtConfirmPasswordFiled,Confirmpassword,"create password");//San@123$* San123
    	  String actualcnfpwd = getAttributeValue(txtConfirmPasswordFiled, "value", "password");
    	  if (actualcnfpwd.equals(Confirmpassword)) {
   		   ExtentTestManager.setPassMessageInReport("Confirm password is accepted Uppercase, lower case and numbers and special charcters"+actualcnfpwd);
    		} else {
    			ExtentTestManager.setFailMessageInReport("Confirm password is NOT accepted Uppercase, lower case and numbers and special charcters"+actualcnfpwd);
    		}
    	  
    	  
      }
      public void verifyCreatePasswordAndConfirmPasswordShowIcons(String ShowIcon) {
    	  boolean flag = verifyElementDisplayed(lnkCreatePasswordShowIcon, "");
    	  boolean stag = verifyElementDisplayed(lnkConfirmPasswordShowIcon, "");
    	  if (flag && stag) {
    		  ExtentTestManager.setPassMessageInReport("Create and confirm password have"+ShowIcon);
  		} else {
  			ExtentTestManager.setFailMessageInReport("Create and confirm password not have"+ShowIcon);
  		}  
    	  
    	  
      }
      public void verifyPasswordFieldsverifyMaskedWithBlackCircles(String Password) {
    	  enterText(txtCreatePasswordFiled, Password, "Create Password");
    	  enterText(txtConfirmPasswordFiled, Password, "Confirm Password");
    	  String str = getAttributeValue(txtCreatePasswordFiled, "type", Password);
    	  String str1 = getAttributeValue(txtConfirmPasswordFiled, "type", Password);
    	 
    	  if(str.contains("password") && str1.contains("password")) {
    		  
    		  ExtentTestManager.setPassMessageInReport("Create and confirm password have masked with black circles"+Password);
    		} else {
    			ExtentTestManager.setFailMessageInReport("Create and confirm password not masked with black circles"+Password);
    	  
    }
      }
      public void clickOnNext() {
    	  click(btnNext, "click Next");
    	  
    	  }
      public void clickOnPrivacyPolicy() {
    	  click(lnkPrivacyPolicy, "click PrivacyPolicy");
      }
      public void clickOnTermsOfServices() {
    	  click(lnkTermsOfServices, "click TermsOfServices");
      }
      
}
