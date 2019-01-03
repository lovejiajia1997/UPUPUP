package shisujia;
/*
 * author:shisujia
 * 删除标签类
 */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DeleteTag_Test extends BaseTest {
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
	public void deleteTag() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='标签']")).click();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//td[contains(.,'firstTag123firstTag123firsttag1230编辑 | 快速编辑 | 删除 | 查看显示详情')]"))).perform();
		Thread.sleep(1000);
		webtest.click("xpath=//a[contains(@aria-label,'删除“firstTag123”')]");
		Thread.sleep(1000);
		//弹出窗口处理
		Alert alert=driver.switchTo().alert();
		alert.accept();//相当于点击确定
		System.out.println("删除标签成功");
	
	}
}
