package com.edu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;
/**
 * 场景2：完整下单流程(未登录、有收货地址)
 * @author yzhldq
 *
 */
public class Scene2_Test {

	@Test
	public void scene2() throws IOException, Exception {
		
		String login_url = "/common/fgadmin/login";
		String getAddress_url = "/fgadmin/address/list";
		String getTransportFee_url = "/common/getTransportFee";
		String submit_url = "/common/fgadmin/submit";
		JSONObject user = new JSONObject();
		
		//登录成功
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000004");
		user.element("password", "netease123");
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//查询收货地址
		CookieStore cookie =  Common.getLoginCookie("20000000004","netease123");		
		result = HttpDriver.doGet(getAddress_url,cookie);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//计算运费
		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "浙江省_杭州市_西湖区");
		result = HttpDriver.doGet(getTransportFee_url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//提交订单
		JSONObject address = new JSONObject();		
		address.element("id", 1);
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
