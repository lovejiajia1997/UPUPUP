package com.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

/**
 * 场景4：完整下单流程(已登录、有收货地址)
 * @author yzhldq
 *
 */
public class Scene4_Test {

	@Test
	public void Scene4() throws Exception {

		String addressList_url = "/fgadmin/address/list";
		String getTransportFee_url = "/common/getTransportFee";
		String submit_url = "/common/fgadmin/submit";
		
		//查询收货地址
		CookieStore cookie =  Common.getLoginCookie("20000000004","netease123");		
		String result = HttpDriver.doGet(addressList_url,cookie);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//计算运费
		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "河北省_石家庄市_裕华区");
		result = HttpDriver.doGet(getTransportFee_url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//提交订单
		cookie =  Common.getLoginCookie("20000000004","netease123");	
		JSONObject address = new JSONObject();		
		address.element("id", "");
		address.element("receiverName", "Tom");
		address.element("cellPhone", "18032430000");
		address.element("province", "河北省");
		address.element("city", "石家庄市");
		address.element("area", "裕华区");
		address.element("addressDetail", "南二环东路");
		address.element("transportFee", 0);
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");			
		result = HttpDriver.doPost(submit_url,address,cookie);
		System.out.println(result);	
	}
}
