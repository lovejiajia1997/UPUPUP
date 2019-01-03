package com.edu.core;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.edu.utils.FileToZIP;
import com.edu.utils.Log;

public class ApiListener extends TestListenerAdapter{
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
		super.onFinish(testContext);
		Log.info(testContext.getName());
        FileToZIP ftz = new FileToZIP();  
        try {
			ftz.fileToZip();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumSendMail sm = new SeleniumSendMail();
		sm.sendmail();
		//把测试结果美化
		//把测试结果发送邮件
	}

}
