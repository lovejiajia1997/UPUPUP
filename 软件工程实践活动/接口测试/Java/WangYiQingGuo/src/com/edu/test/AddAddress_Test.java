package com.edu.test;

import static org.testng.Assert.assertEquals;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.test.Common;

import net.sf.json.JSONObject;

/**
 *  
 * @author Shisujia
 * 
 **/

public class AddAddress_Test {
	String url = "/fgadmin/address/new";
	String result;
	public void assertion(int code,String message) {
		JSONObject json = JSONObject.fromObject(result);	
		assertEquals(json.getString("message"),message);
		assertEquals(json.getInt("code"),code);
	}
	
	@Test(description="添加地址成功")
	public void addAddressSuccess() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
		this.assertion(200, "success");
	}	
	
	@Test(description="添加地址失败，id参数非空")
	public void addAddressFail10() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","123");
		address.element("receiverName","jiajia");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail", "");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
		this.assertion(400, "must be null");		
	}
	
	@Test(description="添加地址失败，未登录")
	public void addAddressFail11() throws Exception {
		JSONObject address = new JSONObject();
		address.element("id","123");
		address.element("receiverName","jiajia");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail", "");	
		result = HttpDriver.doPost(url, address);
		System.out.println(result);
		this.assertion(403, "请重新登录");
		
	}
	
	@Test(description="添加地址失败，receiveName参数类型不正确")
	public void addAddressFail0() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		double receiveName=2.355555;
		address.element("receiverName",receiveName);
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail", "");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
		
	}
	
	@Test(description="添加地址失败，receiveName参数类型不正确")
	public void addAddressFail1() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","1");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，cellphone参数类型不正确")
	public void addAddressFail2() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","123");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，province参数类型不正确")
	public void addAddressFail3() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","123");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，city参数类型不正确")
	public void addAddressFail4() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","123");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");		
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，area参数类型不正确")
	public void addAddressFail5() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","123");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，缺少receiverName参数")
	public void addAddressFail6() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，缺少cellPhone参数")
	public void addAddressFail7() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","");
		address.element("province","浙江省");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，缺少province参数")
	public void addAddressFail8() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","");
		address.element("city","杭州市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="添加地址失败，province和city不匹配")
	public void addAddressFail9() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","浙江省");
		address.element("city","石家庄市");
		address.element("area","滨江区");
		address.element("addressDetail","浙江大学");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}

}
