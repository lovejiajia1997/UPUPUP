package yangtianying;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * @author 杨天莹 评论模块测试
 */
public class Comment_Test extends BaseTest {
	Login_Action action;

	@BeforeMethod
	public void setup() {
		action = new Login_Action(webtest);
	}

	// 发表评论功能
	@Test(priority = '1')
	public void Add_comment() throws Exception {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		action.login("admin", "admin");
		webtest.open("http://localhost:8032/wordpress/");
		// 按下DOWN键
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("link=世界，您好！");
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}

		webtest.click("id=comment");
		Thread.sleep(2000);
		webtest.type("id=comment", "这本书很好");
		// 鼠标移出
		webtest.mouseoverElement("xpath=//h2[text()='功能']");
		webtest.click("xpath=//h2[text()='功能']");
		for (int i = 0; i < 5; i++) {
			webtest.KeyDown();
		}
		webtest.click("id=submit");
		assertTrue(webtest.ifContains("这本书很好"));
	}

	// 回复评论
	@Test(priority = '2')
	public void Reply() throws InterruptedException {

		webtest.open("http://localhost:8032/wordpress/"); // 按下DOWN键
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("link=世界，您好！");
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}

		webtest.click(
				"xpath=//a[@href='http://localhost:8032/wordpress/2018/11/27/%e6%b0%b4%e6%b5%92%e4%bc%a0%e8%af%bb%e5%90%8e%e6%84%9f/?replytocom=2#respond']");
		webtest.type("xpath=//textarea[@id='comment']", "经典之作"); // 鼠标移出
		webtest.mouseoverElement("xpath=//h2[text()='功能']");
		webtest.click("xpath=//h2[text()='功能']");

		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();

		webtest.click("xpath=//input[@id='submit']");

	}

	// 能否批量操作
	@Test(priority = '3')
	public void Many() throws InterruptedException {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("xpath=//input[@id='wp-submit']");

		// 点击评论
		webtest.runJs("arguments[0]. click();", "xpath=//a[@href='edit-comments.php']");
		Thread.sleep(3000);

		webtest.click("xpath=//tbody[@id='the-comment-list']/tr/th/input");
		// 选择批准下拉框
		webtest.click("xpath=//select[@id='bulk-action-selector-top']");
		webtest.selectByValue("xpath=//select[@id='bulk-action-selector-top']", "approve");
		webtest.click("xpath=//input[@id='doaction']");
	}

	// 删除评论功能
	// 在删除评论时，先让鼠标移动到该评论上，而不是先点击（两者效果不同）
	@Test(priority = '4')
	public void Delete_comment() throws Exception {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("xpath=//input[@id='wp-submit']");

		webtest.runJs("arguments[0].click();", "xpath=//div[contains(text(),'评论')]");
		Thread.sleep(3000);
//		webtest.runJs("arguments[0].click();", "xpath=//p[contains(text(),'经典之作')]");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//p[contains(.,'经典之作')]"));
		webtest.mouseoverElement("xpath=//p[contains(.,'这本书很好')]");

		webtest.runJs("arguments[0].click();", "xpath=//a[contains(text(),'移至回收站')]");
		Thread.sleep(3000);

	}

	// 能否对评论进行筛选
	@Test(priority = '5')
	public void Select() throws InterruptedException {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("xpath=//input[@id='wp-submit']");

		webtest.runJs("arguments[0].click();", "xpath=//a[@href='edit-comments.php']");
		Thread.sleep(3000);
		webtest.click("xpath=//select[@id='filter-by-comment-type']");
		webtest.selectByVisibleText("xpath=//select[@id='filter-by-comment-type']", "评论");
		webtest.click("xpath=//input[@id='post-query-submit']");
	}

	// 能否修改评论
	@Test(priority = '6')
	public void change_commit() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("xpath=//input[@id='wp-submit']");

		webtest.open("http://localhost:8032/wordpress/");
		// 按下DOWN键
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("link=世界，您好！");
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("xpath=//a[@href='http://localhost:8032/wordpress/wp-admin/comment.php?action=editcomment&c=1']");
		webtest.click("xpath=//label[text()='待审']");

		
		webtest.click("xpath=//input[@id='save']");

	}

}
