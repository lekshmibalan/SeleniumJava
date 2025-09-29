package pagestestscript;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ModuleListPage;
import pages.ServicesPage;
public class ServicesPageTest extends Base {
	ModuleListPage modulelist;
	ServicesPage services;
  @Test
  public void verifyThatUserCanSelectUserCanSelectServiceType() {
	  LoginPage login=new LoginPage(driver);
	  login.clickOnPublicUser().loginAsPublicUser("dennis.vazhappily@portescap.com", "pass");
	  modulelist=login.clickOnLoginButton();
	  services=modulelist.clickUnitManagementModule();
	  services.moveToServicesTab().selectUnitName("TATA").selectService();
  }
}
