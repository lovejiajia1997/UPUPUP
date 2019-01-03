package com.edu.demo;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.test.Common;
import com.edu.utils.Checker;
import net.sf.json.JSONObject;


/**
 *  
 * @author Shisujia
 * 
 **/

public class GetAddressTest extends Common{
	String url = "/fgadmin/address/list";
	String result = null;
	int id;
	Checker checker;
	
	public void testList(String u_name,String u_pwd,String retmsg) throws Exception {
		CookieStore cookie=Common.getLoginCookie(u_name,u_pwd);
		result = HttpDriver.doGet(url,cookie);
		System.out.println(result);
		checker = new Checker(result);
		checker.verifyTextPresent("message");
		checker.verifyXpath("message", retmsg);
	}
	
	public int getId() throws Exception {
		CookieStore cookie=Common.getLoginCookie("200000000077","netease123");
		result = HttpDriver.doGet(url,cookie);
		System.out.println(result);
		
		JSONObject json = JSONObject.fromObject(result);
		String idd = json.getString("result");
		System.out.println(idd);		
		int temp = 0;
		String  tempid ;
		
		for(int i = 0;i<10;i++) {
			if ((idd.indexOf("\"id\":"+i)) != -1){
			    int index = idd.indexOf("\"id\":"+i);
				tempid = idd.substring(index+5, index+13);
				id = Integer.parseInt(tempid);
				temp++;
				if(temp==2)
					break;
			}
		}
		System.out.println("id="+id);
		return id;
	}
	
	@Test(description="获取收获地址列表成功")
	public void ListSucccess() throws Exception {
		String user = "200000000077";
		String password = "netease123";
		String message = "success";
		this.testList(user,password,message);
	}
	
	@Test(description="获取收获地址列表失败，用户未登录")
	public void ListFail() throws Exception {
		String user = "200000000077";
		String password = "netease12345";
		String message = "请重新登录";
		this.testList(user,password,message);
	}
	
}




