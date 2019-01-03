package com.edu.test;

import org.testng.Assert;

import net.sf.json.JSONObject;

public class AssertTest {
	
	public static void assertMessageEquels(String result,String key,String expected) {
		JSONObject json = JSONObject.fromObject(result);
		Assert.assertEquals(json.getString(key), expected);
	}
}
