package com.webtest.core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.FileToZIP;
import com.webtest.utils.Log;

/**
 * author:lihuanzhen
 * 监听器，用例失败，截屏
 * 用例执行成功，发送邮件
 */


public class WebTestListener  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败，需要截屏");
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();		  
	  }
	  
//	  @Override
//	  public void onTestSuccess(ITestResult tr) {
//		  Log.info(tr.getInstance()+"-"+tr.getName()+"运行成功，需要发送电子邮件");
//		  BaseTest wp = (BaseTest) tr.getInstance();
//          WebDriver driver = wp.getDriver(); 
//          FileToZIP ftz = new FileToZIP();
//          ftz.fileToZip();
//		  SeleniumSendMail sm = new SeleniumSendMail();
//		  sm.sendmail();
//		  
//	  }
	  
	
	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		Log.info(testContext.getName());
        FileToZIP ftz = new FileToZIP();
        ftz.fileToZip();
		SeleniumSendMail sm = new SeleniumSendMail();
		sm.sendmail();
	}
}
