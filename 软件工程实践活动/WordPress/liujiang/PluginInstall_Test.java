/**
 * author:刘江
 * 安装插件
 */
package liujiang;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PluginInstall_Test extends BaseTest {
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void plugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("link=安装插件");
		webtest.click("link=BuddyPress ");
		webtest.click("link=现在安装");
	}
}
