package shisujia;
/*
 * author:shisujia
 * 删除用户类
 */
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DeleteUser_Test extends BaseTest {
	Login_Action action;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		driver.findElement(By.xpath("//div[text()='用户']")).click();
		Thread.sleep(3000);
	}

	@Test(description="删除单个用户")
	public void deleteUser() throws Exception  {			
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//td[contains(.,' 1234567编辑 | 删除 | 查看显示详情')]"))).perform();
		Thread.sleep(3000);
		webtest.click("xpath=//a[text()='删除'");
		Thread.sleep(1000);
		webtest.click("id=submit");
		Thread.sleep(1000);		
	}
	
//	@Test(description="批量删除用户")
//	public void deleteUser_batch() throws Exception  {
//		driver.findElement(By.xpath("//input[@id='user_14']")).click();
//		driver.findElement(By.xpath("//input[@id='user_9']")).click();
//		driver.findElement(By.name("action")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//option[text()='删除']")).click();
//		driver.findElement(By.id("doaction")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("delete_option0")).click();
//		driver.findElement(By.id("submit")).click();
//		Thread.sleep(60000);		
//	}
	
}
