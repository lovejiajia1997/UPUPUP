package yuezhewei;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * author:yuezhewei
 * Settings中撰写的测试
 */
public class Compose_Test extends BaseTest {  
	@BeforeMethod
  public void login (){
	  //打开页面
	   webtest.open("http://localhost:8032/wordpress/wp-login.php?loggedout=true");
	   //文本框输入
	   webtest.type("name=log","admin");
	   webtest.type("name=pwd","123456");
	   webtest.click("xpath=//input[@type='submit']");
	   assertTrue(webtest.isTextPresent("登录"));	  
  }
  @Test(priority=1)
  public void compose() {
	  webtest.click("link=Settings");
	  webtest.click("link=撰写");
	  webtest.selectByValue("name=default_category", "2");
	  webtest.selectByValue("id=default_post_format", "0");
	  webtest.typeAndClear("id=mailserver_url", "541520730@qq.com");
	  webtest.typeAndClear("id=mailserver_login", "ceshi");
	  webtest.typeAndClear("id=mailserver_pass", "123456");
	  webtest.selectByValue("id=default_email_category", "2");
	  webtest.click("xpath=//input[@type='submit']");
  }

}
