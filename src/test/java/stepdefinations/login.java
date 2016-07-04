package stepdefinations;


import org.junit.Assert;

import baseFile.BaseFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login  extends BaseFile {
	
	@Given("^As a user I navigate to \"(.*?)\"$")
	public void as_a_user_I_navigate_to(String url) throws Throwable {
	    web_driver.get(url);
	    seleniumwait.wait(3);
	
	}
	
	@Given("^I enter username as \"(.*?)\" and password as \"(.*?)\"$")
	public void i_enter_username_as_and_password_as(String uname, String pwd) throws Throwable {
		  seleniumutils.typeBy_Id(uname,"email");
	  seleniumutils.typeBy_Id(pwd,"password");

	}

	@When("^I click submit button$")
	public void i_click_submit_button() throws Throwable {
		seleniumwait.wait(2);
		  seleniumutils.clickByXPath_("submitbtn");

	
	}

	@Then("^I see nopecommerce store$")
	public void i_see_nopecommerce_store() throws Throwable {
		String Actual = web_driver.getTitle();
	Assert.assertEquals(Actual, "nopCommerce demo store");
	}



}
