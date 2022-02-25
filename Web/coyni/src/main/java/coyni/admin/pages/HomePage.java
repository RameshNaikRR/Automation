package coyni.admin.pages;

import coyni.admin.components.SideBarComponent;
import coyni.admin.components.TopBarComponent;
import ilabs.WebFramework.BrowserFunctions;

public class HomePage extends BrowserFunctions {
	
	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}
	public TopBarComponent topBarComponent() {
		return new TopBarComponent();
	}

}
