package shisujia;
/*
 * author:shisujia
 * 修改标签类
 */
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AlterTag_Test extends BaseTest{
	Login_Action action; 
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	public boolean ifContains(String content) {
		return driver.getPageSource().contains(content);
	}
	
	@Test
	public void alterTag() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='标签']")).click();
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("//td[contains(.,'firstTagfirstTag第一个tag0编辑 | 快速编辑 | 删除 | 查看显示详情')]"))).perform();
		Thread.sleep(3000);
		webtest.click("xpath=//a[@aria-label='编辑“firstTag”']");
		Thread.sleep(3000);
		webtest.typeAndClear("id=name", "firstTag123");
		webtest.typeAndClear("id=slug", "firstTag123");
		webtest.type("id=description", "我是WordPress项目的第一个标签呀");
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(3000);
		System.out.println("修改标签成功");
	}
}
