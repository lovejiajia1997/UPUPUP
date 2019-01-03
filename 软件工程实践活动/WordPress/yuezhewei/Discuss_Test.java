package yuezhewei;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * author:yuezhewei
 * Settings÷–Ã÷¬€µƒ≤‚ ‘
 */
public class Discuss_Test extends BaseTest{
	@BeforeMethod
	public void testLogin() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		webtest.type("id=user_login","admin");
		webtest.type("id=user_pass", "123456");
		webtest.click("xpath=//input[@value='µ«¬º']");	
	}
	@Test
	public void discuss() {
		webtest.click("link=Settings");
		  webtest.click("link=Ã÷¬€");				 
		  webtest.click("xpath=//input[@id='default_pingback_flag']");
		  webtest.click("xpath=//input[@id='default_ping_status']");
		  webtest.click("xpath=//input[@id='default_comment_status']");
		  
		  webtest.click("xpath=//input[@id='require_name_email']");
		  webtest.click("xpath=//input[@id='comment_registration']");
		  webtest.click("xpath=//input[@id='close_comments_for_old_posts']");
		  webtest.typeAndClear("name=close_comments_days_old", "999999999");
		  
		  webtest.click("xpath=//input[@id='show_comments_cookies_opt_in']");
		  webtest.click("xpath=//input[@id='thread_comments']");
		  webtest.selectByValue("id=thread_comments_depth","3");
		  
		  webtest.click("xpath=//input[@id='page_comments']");
		  webtest.typeAndClear("name=comments_per_page", "999999999");
		  webtest.selectByValue("id=default_comments_page","oldest");
		  
		  webtest.click("xpath=//input[@id='comments_notify']");
		  webtest.click("xpath=//input[@id='moderation_notify']");
		  webtest.click("xpath=//input[@id='comment_moderation']");
		  webtest.click("xpath=//input[@id='comment_whitelist']");
		  
		  webtest.typeAndClear("name=moderation_keys", "upup≤‚ ‘");
		  webtest.typeAndClear("name=blacklist_keys", "upup≤‚ ‘");
		  
		  webtest.typeAndClear("name=comment_max_links", "999999999");
		  webtest.click("xpath=//input[@type='submit']");
	}

}
