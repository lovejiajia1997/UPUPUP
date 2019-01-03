package com.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;


/**
 * 
 * @author yzhldq
 *
 */
public class Get_Transport_Fee_Test {
	String url = "/common/getTransportFee";
	
	@Test(description = "获取运费成功")
	public void success1() throws Exception {

		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "浙江省_杭州市_滨江区");
		String result = HttpDriver.doGet(url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
	}
	
	@Test(description = "获取运费成功")
	public void success2() throws Exception {

		Map map = new HashMap();
		map.put("id", 2);
		map.put("addressDetail", "浙江省_杭州市_滨江区");
		String result = HttpDriver.doGet(url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
	}
	
	@Test(description = "登录失败，id参数类型不正确")
	public void idError() throws Exception {

		Map map = new HashMap();
		map.put("id", 1.25);
		map.put("addressDetail", "浙江省_杭州市_滨江区");
		String result = HttpDriver.doGet(url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","请求失败");
		
	}
	
	@Test(description = "登录失败，addressDetail参数类型不正确")
	public void addressDetailError() throws Exception {

		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "123");
		String result = HttpDriver.doGet(url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","请求失败");
		
	}
	
	@Test(description = "登录失败，缺少id参数")
	public void lackID() throws Exception {

		Map map = new HashMap();
		map.put("addressDetail", "浙江省_杭州市_滨江区");
		String result = HttpDriver.doGet(url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","请求失败");
		
	}
	
	@Test(description = "登录失败，缺少addressDetail参数")
	public void lackAddressDetail() throws Exception {

		Map map = new HashMap();
		map.put("id", 1);
		String result = HttpDriver.doGet(url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","请求失败");
		
	}
}
