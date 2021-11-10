package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.ChangePasswordComponent;
import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.components.PaymentMethodsComponent;
import coyni.customer.components.PreferencesComponent;
import coyni.customer.components.ToastComponent;
import coyni.customer.components.UserDetailsComponent;
import ilabs.WebFramework.BrowserFunctions;

public class CustomerProfilePage extends BrowserFunctions{
	
	
	
	public  CustomerMenuComponent    customerMenuComponent() {
	return new CustomerMenuComponent();
	}
     public  UserDetailsComponent  userDetailsComponent() {
 	 return new UserDetailsComponent();
 	}
	

	public  PaymentMethodsComponent paymentMethodsComponent() {
    return new PaymentMethodsComponent();
    }
	 public  PreferencesComponent preferencesComponent() {
     return new PreferencesComponent();
     }
	 public ToastComponent toastComponent() {
	 return new ToastComponent();
	 }
	 public  ChangePasswordComponent changePasswordComponent() {
	 return new ChangePasswordComponent();
	 }
  
  
}
    
	
		
	
	


