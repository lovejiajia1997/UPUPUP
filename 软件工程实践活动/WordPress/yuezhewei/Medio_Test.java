package yuezhewei;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * author:yuezhewei
 * SettingsÖÐÃ½ÌåµÄ²âÊÔ
 */
public class Medio_Test extends BaseTest {
	@Test(priority=0)
	public void testLogin() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		webtest.type("id=user_login","admin");
		webtest.type("id=user_pass", "123456");
		webtest.click("xpath=//input[@value='µÇÂ¼']");	
	}
	@Test(priority=1)
	public void medio() throws InterruptedException {
		  webtest.click("link=Settings");		 
		  webtest.pause(1000);
		  webtest.click("xpath=//a[@href='options-media.php']");	
		  webtest.typeAndClear("name=thumbnail_size_w", "0");
		  webtest.typeAndClear("name=thumbnail_size_h", "0");
		  webtest.click("xpath=//input[@id='thumbnail_crop']");
		  
		  webtest.typeAndClear("name=medium_size_w", "0");
		  webtest.typeAndClear("name=medium_size_h", "0");
		  webtest.typeAndClear("name=large_size_w", "0");		  
		  webtest.typeAndClear("name=large_size_h", "0");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=2)
	public void medio1() {
		  webtest.click("link=Settings");
		  webtest.pause(1000);
		  webtest.click("xpath=//a[@href='options-media.php']");
		  webtest.typeAndClear("name=thumbnail_size_w", "1");
		  webtest.typeAndClear("name=thumbnail_size_h", "2");
		  webtest.click("xpath=//input[@id='thumbnail_crop']");
		  
		  webtest.typeAndClear("name=medium_size_w", "3");
		  webtest.typeAndClear("name=medium_size_h", "4");
		  webtest.typeAndClear("name=large_size_w", "5");
		  webtest.typeAndClear("name=large_size_h", "6");
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=3)
	public void medio2() {
		  webtest.click("link=Settings");
		  webtest.pause(1000);
		  webtest.click("xpath=//a[@href='options-media.php']");	
		  webtest.typeAndClear("name=thumbnail_size_w", "999999999");
		  webtest.typeAndClear("name=thumbnail_size_h", "999999999");
		  webtest.click("xpath=//input[@id='thumbnail_crop']");
		  
		  webtest.typeAndClear("name=medium_size_w", "999999999");
		  webtest.typeAndClear("name=medium_size_h", "999999999");
		  webtest.typeAndClear("name=large_size_w", "999999999");
		  webtest.typeAndClear("name=large_size_h", "999999999");
		  webtest.click("xpath=//input[@type='submit']");
	}
}
