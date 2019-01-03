package shisujia;
/*
 * author:shisujia
 * 添加标签类
 */
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddTag_Test extends BaseTest{
	Login_Action action; 
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	
	
	@Test
	public void addTag() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='标签']")).click();
		Thread.sleep(1000);
		//添加名称		
		webtest.type("id=tag-name", "firstTag");
		//添加名称
		webtest.type("id=tag-slug", "第一个tag");
		//点击添加标签
		webtest.click("id=submit");
		Thread.sleep(1000);
		Assert.assertFalse(ifContains("分类法中已存在同名项目"));
		System.out.println("添加标签成功");
	}
}
