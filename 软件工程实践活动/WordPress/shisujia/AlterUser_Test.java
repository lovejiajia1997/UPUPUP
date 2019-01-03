package shisujia;
/*
 * author:shisujia
 * 编辑个人资料类
 */

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AlterUser_Test extends BaseTest{
	Login_Action action;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	
	
	@Test
	public void alterUser() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='用户']"))).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='我的个人资料']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("名字");
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("姓氏");
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("佳佳");
		driver.findElement(By.id("display_name")).click();
		driver.findElement(By.xpath("//option[contains(.,'姓氏 名字')]")).click();
		driver.findElement(By.id("submit")).click();	
	}
}
