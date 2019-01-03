package com.edu.test;

import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import net.sf.json.JSONObject;

/**
 *  
 * @author weishijie
 * 
 **/

public class Login_Test {
	String url = "/common/fgadmin/login";
	String result = null;
	
	public JSONObject login(String u_name,String u_pwd)  {
		
		
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", u_name);
		user.element("password", u_pwd);
		String result = HttpDriver.doPost(url, user);
		JSONObject jsonResult=JSONObject.fromObject(result);
		System.out.println(result);
		return jsonResult;
	}
	
	@Test
	public void loginSuccess()  {
		this.login("200000000077","netease123");
	}
	
	@Test(description="登录失败，phoneArea参数类型不正�?")
	public void loginFail1() {
		JSONObject user = new JSONObject();
		user.element("phoneArea", 86);
		user.element("phoneNumber", "200000000077");
		user.element("password", "netease123");
		String result = HttpDriver.doPost(url, user);
		System.out.println(result);
	}
	@Test(description="登录失败，phoneNumber参数类型不正�?")
	public void loginfail2() {
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");

		user.element("phoneNumber",200.000);
		user.element("password", "netease123");
		String result = HttpDriver.doPost(url, user);
		System.out.println(result);
	}
	@Test(description="登录失败，password参数类型不正�?")
	public void loginfail3() {
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", "200000000077" );
		user.element("password", 123456);
		String result = HttpDriver.doPost(url, user);
		System.out.println(result);
	}
	@Test(description="登录失败，缺少phoneArea参数")
	public void loginfail4() {
		JSONObject user = new JSONObject();
		user.element("phoneArea", "");
		user.element("phoneNumber", "200000000077" );
		user.element("password", "netease123");
		String result = HttpDriver.doPost(url, user);
		System.out.println(result);
	}
	@Test(description="登录失败，缺少phoneNumber参数")
	public void loginfail5() {
		this.login("","netease123");
	}
	@Test(description="登录失败，缺少password参数")
	public void loginfail6() {
		this.login("200000000077","");
	}
	@Test(description="登录失败，电话号码超�?11�?")
	public void loginfail7() {
		this.login("2000000000777","netease123");
	}
	@Test(description="登录失败，密码错�?")
	public void loginfail8() {
		this.login("200000000077","netease12311");
	}
	@Test(description="登录失败，用户不存在")
	public void loginfail9() {
		this.login("10086","netease123");
	}
}
