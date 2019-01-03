package com.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

public class Food_Fun {
	String url="/http/isLogin" ;
	public String login(String name,String password) {
		Map<String,Object> user =new HashMap();
		user.put("userAccount", name);
		user.put("userPassword", password);
		String result=HttpDriver.doPostByForm(url, user);
		return result;
	
	}
	@Test
	public void loginSuccess() {
		String res=this.login("123456", "123456");
		System.out.println(res);
	}
	
	

}
