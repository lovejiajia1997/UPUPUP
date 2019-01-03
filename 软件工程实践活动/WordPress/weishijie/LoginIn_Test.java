package weishijie;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class LoginIn_Test extends BaseTest {
	public static void main(String[]args) throws InterruptedException {
		driver.get("http://localhost:8032/wordpress/wp-login.php");
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(2000);
	}
	@Test
	public void failLogin() throws InterruptedException {
		driver.get("http://localhost:8032/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("admin1");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(2000);
	}

}
