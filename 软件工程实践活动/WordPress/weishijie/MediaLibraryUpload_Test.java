package weishijie;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MediaLibraryUpload_Test {
	@Test
	public void Upload() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://localhost:8032/wordpress/wp-login.php";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("weishijie");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("wsj12521");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(1000);
		/*
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(By.xpath("//div[text()='媒体']"))).perform();
		*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);",driver.findElement(By.id("menu-media")),"wp-has-submenu wp-not-current-submenu menu-top menu-icon-media opensub");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@class='page-title-action aria-button-if-js']")).click();
		driver.findElement(By.xpath("//a[text()='添加']")).click();
		Thread.sleep(1000);
		
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("arguments[0].setAttribute('type',arguments[1]);",driver.findElement(By.id("plupload-browse-button")),"file");
//		Thread.sleep(2000);
		
//		driver.findElement(By.id("html5_1cubll2vu1s5i10b21n6d1os11vca5")).sendKeys("F:\\641A6675.JPG");
		
		driver.findElement(By.xpath("//input[starts-with(@id,'html5_')]")).sendKeys("F:\\641A6675.JPG");
		
		Thread.sleep(2000);
		
	//	Actions action =new Actions(driver);
		//.sendKeys(Keys.TAB).perform();


		

	}
}

