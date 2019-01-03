package shisujia;

import com.webtest.core.WebDriverEngine;
import com.webtest.utils.ReadProperties;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login() throws Exception 
	  {
		  	String username = ReadProperties.getPropertyValue("username");
		  	String password = ReadProperties.getPropertyValue("password");
			webtest.type("id=user_login", username);
			webtest.type("name=pwd", password);
			webtest.click("xpath=//input[@id='wp-submit']");		
		
	  }
	  
	  public void loginNew(String username,String password) throws Exception 
	  {
			webtest.type("id=user_login", username);
			webtest.type("name=pwd", password);
			webtest.click("xpath=//input[@id='wp-submit']");		
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }

	


}