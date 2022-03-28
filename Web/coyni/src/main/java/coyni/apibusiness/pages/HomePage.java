package coyni.apibusiness.pages;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.components.TopBarComponent;
import ilabs.WebFramework.BrowserFunctions;

public class HomePage extends BrowserFunctions {
	public TopBarComponent topBarComponent() {
		return new TopBarComponent();
	}

	public SideBarMenuComponent sideBarComponent() {
		return new SideBarMenuComponent();
	}

}