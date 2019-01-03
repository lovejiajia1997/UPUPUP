package com.edu.demo;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;


public class Supermarket_Demo {
	
	String url = "http://10.7.90.245:8080/Supermarket/analysis/lookupprice";
	
	@Test
	public void price() throws Exception {
		String googsId = URLEncoder.encode("{\"pId\":\"123456\"}", "UTF-8");
		Map para = new HashMap();
		para.put("goodsCode",googsId);
		String result = HttpDriver.doGet(url, para);	
		System.out.println(result);
	}	
}
