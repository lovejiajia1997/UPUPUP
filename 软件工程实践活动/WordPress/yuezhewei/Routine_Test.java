package yuezhewei;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * author:yuezhewei
 * Settings中常规的测试
 */
public class Routine_Test extends BaseTest {
	@BeforeMethod
   public void testLogin() {
	   //打开页面
	   webtest.open("http://localhost:8032/wordpress/wp-login.php?loggedout=true");
	   //文本框输入
	   webtest.type("name=log","admin");
	   webtest.type("name=pwd","123456");
	   webtest.click("xpath=//input[@type='submit']");
	   assertTrue(webtest.isTextPresent("登录"));	   
   }
   @Test(priority=0)
   public void routine() throws InterruptedException {
	   webtest.click("link=Settings");
	   webtest.typeAndClear("id=blogname","upup");	   
	   webtest.typeAndClear("name=blogdescription", "wordpress站点");
	   webtest.typeAndClear("name=new_admin_email", "541520730@qq.com");
	   webtest.click("xpath=//input[@type='checkbox']");
	   webtest.selectByValue("id=default_role","editor");
	   webtest.selectByValue("id=WPLANG", "zh_CN");
	   webtest.click("xpath=//input[@id='submit']");
	   
   } 
}

