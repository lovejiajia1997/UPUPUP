package weishijie;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MediaLibraryDelete_Test {
	@Test
	public  void Delete() throws InterruptedException{
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);",driver.findElement(By.id("menu-media")),"wp-has-submenu wp-not-current-submenu menu-top menu-icon-media opensub");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'媒体�?')]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@class='view-list']")).click();
		//Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@src='http://localhost:8032/wordpress/wp-content/uploads/2018/12/641A6675-10-100x100.jpg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'永久删除')]")).click();
		Thread.sleep(2000);
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);

	}

}
	