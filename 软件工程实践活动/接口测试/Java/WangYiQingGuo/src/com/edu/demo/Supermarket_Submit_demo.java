package com.edu.demo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;


public class Supermarket_Submit_demo {
	
	@Test
	public void submit() throws Exception {
		String url = "http://10.7.90.245:8080/Supermarket/analysis/palceoreder";
		String para = "{\"total\":\"1\",\"record\":[{\"pNum\":1,\"pId\":\"123457\"}],\"oSum\":8}";
		String result = HttpDriver.doPostByForm(url, para);
		System.out.println(result);
	}
}
