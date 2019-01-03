package shisujia;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

/*
 * 用户权限验证类
 * author:shisujia
 */
public class UserPrivileges_Test extends BaseTest {
	
	@Test(description="验证角色为订阅者的用户是否具有用户权限")
	public void subscriber() throws Exception{
		//登录，用户1的角色为订阅者
		Login_Action action;
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");	
		action.loginNew("1", "1");
		Thread.sleep(1000);
		webtest.JavaScriptClick("xpath=//div[text()='仪表盘']");
		Thread.sleep(3000);
		Assert.assertFalse(ifContains("用户"));
		System.out.println("角色为订阅者的用户不具有用户权限");
	}
	
	@Test(description="验证角色为投稿者的用户是否具有用户和文章权限")
	public void contributor(){
		//登录，用户12的角色为投稿者
		Login_Action action;
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		try {
			action.loginNew("12", "12");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(ifContains("用户"));
		System.out.println("角色为投稿者的用户不具有用户权限");
		Assert.assertTrue(ifContains("文章"));
		System.out.println("角色为投稿者的用户具有文章权限");
		
	}
}
