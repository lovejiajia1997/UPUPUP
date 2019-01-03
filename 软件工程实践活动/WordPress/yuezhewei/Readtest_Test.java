package yuezhewei;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * author:yuezhewei
 * SettingÖÐÔÄ¶ÁµÄ²âÊÔ
 */
public class Readtest_Test extends BaseTest {
	      @Test(priority=0)
		  public void testLogin() {
			   //´ò¿ªÒ³Ãæ
			   webtest.open("http://localhost:8032/wordpress/wp-login.php?loggedout=true");
			   //ÎÄ±¾¿òÊäÈë
			   webtest.type("name=log","admin");
			   webtest.type("name=pwd","123456");
			   webtest.click("xpath=//input[@type='submit']");
			   assertTrue(webtest.isTextPresent("µÇÂ¼"));	   
		   }
	      @Test(priority=1)
		  public void read() throws InterruptedException {
	
		  webtest.click("link=Settings");
		  webtest.click("link=ÔÄ¶Á");		 		  
		  webtest.typeAndClear("name=posts_per_page","0");
		  webtest.typeAndClear("name=posts_per_rss", "0");	 
		  webtest.click("xpath=//input[@type='submit']");
		  Thread.sleep(1000);	
	      }
		  @Test(priority=2)
		  public void read1() throws InterruptedException {
	
		  webtest.click("link=Settings");
		  webtest.click("link=ÔÄ¶Á");		 		  
		  webtest.typeAndClear("name=posts_per_page","1");
		  webtest.typeAndClear("name=posts_per_rss", "1");	 
		  webtest.click("xpath=//input[@type='submit']");
		  Thread.sleep(1000);	
		  }
		  @Test(priority=3)
		  public void read2() throws InterruptedException {
				
		  webtest.click("link=Settings");
		  webtest.click("link=ÔÄ¶Á");		 		  
		  webtest.typeAndClear("name=posts_per_page","99999999999");
		  webtest.typeAndClear("name=posts_per_rss", "99999999999");	 
		  webtest.click("xpath=//input[@type='submit']");
		  Thread.sleep(1000);	
	      
	      } 
}
