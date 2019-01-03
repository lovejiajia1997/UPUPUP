package yangtianying;

import com.webtest.core.WebDriverEngine;

/**
 * @author 杨天莹
 *
 */
public class Login_Action {
	private WebDriverEngine webtest;

	public Login_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}

	public void login(String username, String password) {

		webtest.type("id=user_login", username);
		webtest.type("id=user_pass", password);
		webtest.click("id=wp-submit");

	}

	public boolean is_login() {
		return webtest.isElementPresent("id=logoutLink");
	}

}
