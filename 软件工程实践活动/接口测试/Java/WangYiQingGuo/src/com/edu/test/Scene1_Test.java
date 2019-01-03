package com.edu.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

/**
 * 场景1：浏览商品列表并查看商品详情
 * @author yzhldq
 *
 */
public class Scene1_Test {

	@Test
	public void scene1() throws IOException, Exception {
		
		String url = "/common/skuList";
		//获取所有商品的sku列表成功
		String result = HttpDriver.doGet(url);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//获取goodsId=1的商品sku信息成功
		result = HttpDriver.doGet(url,"goodsId=1");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//获取goodsId=2的商品sku信息成功
		result = HttpDriver.doGet(url,"goodsId=2");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//获取goodsId=3的商品sku信息成功
		result = HttpDriver.doGet(url,"goodsId=3");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
	}
}
