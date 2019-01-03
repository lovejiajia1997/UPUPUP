package com.edu.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.test.Common;

import net.sf.json.JSONObject;

public class New {
	@Test(dataProvider="user",dataProviderClass=NSDataProvider.class)
	public void submit(String name,String password) throws IOException, Exception {
		CookieStore cookie=Common.getLoginCookie(name, password);
		String url = "/fgadmin/orders/submit";
		JSONObject address = new JSONObject();
		address.element("id", "");
		address.element("receiverName", "Zoe");
		address.element("cellPhone", "15868470172");
		address.element("province", "河北省");
		address.element("city", "张家口市");
		address.element("area", "康保县");
		address.element("addressDetail", "永安大街77号");
		address.element("transportFee", 0);
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
	    String result = HttpDriver.doPost(url, address, cookie);
	    System.out.println(result);
////		断言
//		JSONObject json = JSONObject.fromObject(result);
//		assertEquals(json.getString("message"),"success");
//		assertEquals(json.getInt("code"),200);
	}
	

}
