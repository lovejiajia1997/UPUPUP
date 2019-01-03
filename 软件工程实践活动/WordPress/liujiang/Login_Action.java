package liujiang;

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	  private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String username,String password) throws Exception 
	  {
	
			webtest.type("id=user_login", "admin");
			webtest.type("name=pwd", "admin");
			webtest.click("xpath=//input[@id='wp-submit']");
			
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }
	  
}
