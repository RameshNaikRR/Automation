package coyni_mobile.utilities;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;

public class    CommonFunctions {

    MobileFunctions mobileFunctions;

    public CommonFunctions() {
        mobileFunctions = new MobileFunctions();
    }

    public void verifyLabelText(String labelName, String expText, String actText){
        if (expText.equalsIgnoreCase(actText)){
            ExtentTestManager.setPassMessageInReport(String.format("%s is %s", labelName, actText));
        } else {
            ExtentTestManager.setFailMessageInReport(String.format("%s ::<p>Expected =  %s</br>Actual = %s</p>", labelName, expText, actText));
        }
    }
}
