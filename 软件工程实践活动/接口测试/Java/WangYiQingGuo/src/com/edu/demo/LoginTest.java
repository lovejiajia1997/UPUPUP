package com.edu.demo;

import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import net.sf.json.JSONObject;

/**
 *  
 * @author Shisujia
 * 
 **/

public class LoginTest {
	String url = "/common/fgadmin/login";
	String result = null;
	
	public JSONObject login(String u_name,String u_pwd)  {	
		JSONObject user = new JSONObject();
		user.element("phoneArea", 86);
		user.element("phoneNumber", u_name);
		user.element("password", u_pwd);
		String result = HttpDriver.doPost(url, user);
		System.out.println(result);
		return user;
	}
	
	@Test(description="µÇÂ¼³É¹¦")
	public void loginSuccess()  {
		this.login("200000000077","netease123");
	}
	
	@Test(description="µÇÂ¼Ê§°Ü£¬ÃÜÂë´íÎó")
	public void loginFail() {
		this.login("200000000077","netease12311");
	}
	
	
	
}
