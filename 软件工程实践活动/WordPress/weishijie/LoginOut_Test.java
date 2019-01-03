package weishijie;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class LoginOut_Test {
	@Test
	public void LoginOut() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://localhost:8032/wordpress/wp-login.php";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("weishijie");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("wsj12521");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(2000);
		/*
		Actions actions = new Actions(driver);
		actions.moveToElement().perform();
		*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);",driver.findElement(By.id("wp-admin-bar-my-account")),"menupop with-avatar hover");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[contains(.,'编辑我的个人资料'？)]")).click();
//		driver.findElement(By.xpath("//a[text()='登出']")).click();
		driver.findElement(By.linkText("登出")).click();
		//driver.findElement(By.xpath("//a[contains(.,'登出')]")).click();

		Thread.sleep(5000);
	}

}
	