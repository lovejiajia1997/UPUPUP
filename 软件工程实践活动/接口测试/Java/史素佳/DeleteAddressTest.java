package com.edu.demo;

import static org.testng.Assert.assertEquals;
import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.test.Common;
import com.edu.utils.Checker;
import net.sf.json.JSONObject;

public class DeleteAddressTest {
	String url = "/fgadmin/address/delete";	
	GetAddressTest list = new GetAddressTest();
	Checker check;
	String name = "200000000077";
	String password = "netease123";
	public void deleteAddress(int id,int code,String returnMsg) throws  Exception {
		CookieStore cookie=Common.getLoginCookie(name, password);
		JSONObject addressPara = new JSONObject();
		addressPara.element("id", id);
		String result = HttpDriver.doPost(url, addressPara, cookie);
		System.out.println(result);
//		断言
		JSONObject json = JSONObject.fromObject(result);
		assertEquals(json.getString("message"),returnMsg);
		assertEquals(json.getInt("code"),code);
	}
	
	@Test(description="删除成功")
	public void deleteSuccess() throws Exception {
		int id = list.getId();
		int code = 200;
		String message = "success";	
		this.deleteAddress(id,code,message);
	}
	
	@Test(description="删除失败，id参数类型不正确")
	public void deleteAddressFail0() throws Exception {
		String id = "123";	
		CookieStore cookie=Common.getLoginCookie(name, password);
		JSONObject addressPara = new JSONObject();
		addressPara.element("id", id);
		String result = HttpDriver.doPost(url, addressPara, cookie);
		System.out.println(result);		
		//断言
		JSONObject json = JSONObject.fromObject(result);
		int code = 400;
		String message = "请求失败";	
		assertEquals(json.getString("message"),message);
		assertEquals(json.getInt("code"),code);
	}
	
	@Test(description="删除失败，id参数不存在")
	public void deleteAddressFail1() throws Exception {
		int id = 123456789;
		int code = 400;
		String message = "请求失败";	
		this.deleteAddress(id,code,message);
	}
	
	@Test(description="删除失败，缺少id参数")
	public void deleteAddressFail2() throws Exception {
		CookieStore cookie=Common.getLoginCookie(name, password);
		JSONObject addressPara = new JSONObject();
		addressPara.element("id","");
		String result = HttpDriver.doPost(url, addressPara, cookie);
		System.out.println(result);
		
//		断言
		JSONObject json = JSONObject.fromObject(result);
		assertEquals(json.getInt("code"),400);
		assertEquals(json.getString("message"),"may not be null");
	}
	
	@Test
	public void deleteAddressFail3() throws  Exception {
		int id = list.getId();
		JSONObject addressPara = new JSONObject();		
		addressPara.element("id", id);		
		String result = HttpDriver.doPost(url, addressPara);
		System.out.println(result);
//		断言
		JSONObject json = JSONObject.fromObject(result);
		assertEquals(json.getString("message"),"请重新登录");
		assertEquals(json.getInt("code"),403);
	}
	
}

