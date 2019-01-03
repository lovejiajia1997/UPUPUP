package com.webtest.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void test1() {
		System.setProperty("webdriver.gecko.driver","E:\\Firefox\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin","E:\\Firefoxbrowser\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
					
		//2.µÇÂ¼ÕËºÅ
		driver.get("http://localhost:8032/mymovie");
		driver.findElement(By.linkText("µÇÂ¼")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("//input[@value='ÂíÉÏµÇÂ¼']")).click();
	}
	
	

}
