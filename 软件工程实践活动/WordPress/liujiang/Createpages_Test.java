/**
 * author:刘江
 * 创建页面
 */
package liujiang;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Createpages_Test extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void caeatePagesTest() throws InterruptedException {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//div[text()='页面']"))).perform();
			Thread.sleep(2000);
			//进入“写新建页面”页面
			driver.findElement(By.xpath("//a[text()='新建页面']")).click();
			Thread.sleep(1000);	
			webtest.type("id=post-title-0", "页面");
			webtest.type("id=post-content-0", "这是页面的内容");
			webtest.click("xpath=//button[contains(.,'发布...')]");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(.,'发布')]")).click();
			Thread.sleep(1000);
	}
}
