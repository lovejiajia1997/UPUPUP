package yangtianying;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * @author 杨天莹 工具模块测试
 */
public class Tools_Test extends BaseTest {

	Login_Action action;

	@BeforeMethod
	public void setup() {
		action = new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("xpath=//input[@id='wp-submit']");
	}

	// 导入文章
	@Test(description = "导入文章")
	public void Tools_In() {

		webtest.click("xpath=//div[text()='工具']");
		webtest.click("link=导入");
		// 导入
		webtest.click("xpath=//a[@aria-label='运行Blogger']");
		webtest.type("xpath=//input[@id='upload']", "D:\\WordPress_UPUP\\Test.txt");
		webtest.click("xpath=//input[@id='submit']");
		webtest.click("xpath=//input[@value='Submit']");
		assertTrue(webtest.ifContains("All done"));
	}



	// 插件启用测试[启用你好，多莉]
	@Test()
	public void Duoli() {
		

		webtest.click("xpath=//div[contains(text(),'插件')]");
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.click("xpath=//a[@aria-label='激活你好多莉']");
	}

}
