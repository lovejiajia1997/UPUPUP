package com.edu.test;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

/**
 * 
 * @author yzhldq
 *
 */
public class Submit_Test {

	String url = "/common/fgadmin/submit";
	String username = "20000000004";
	String password = "netease123";
	
	@Test(description = "提交订单成功")	
	public void success1() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
		
		String result = HttpDriver.doPost(url,address,cookie);
//		AssertTest.assertMessageEquels(result,"message","success");
	}
	
	@Test(description = "提交订单成功，并开发票")	
	public void success2() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "网易杭州研究院");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，未购买商品")	
	public void commodityNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "");
		address.element("skuNumbers", "");
		address.element("stockIds", "");
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，未选择收货地址")	
	public void addressNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，开发票，没有写发票抬头")	
	public void billNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，缺少货物编号")	
	public void goodsIDNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，缺少要购买的货物个数")	
	public void skuNumbersNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("stockIds", "74966312,74966313");
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，缺少库存批次ID")	
	public void stockIdNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，要购买的货物个数类型不正确")	
	public void skuNumbersError1() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("stockIds", "74966312,74966313");
		address.element("skuNumbers", "11");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，要购买的货物个数类型不正确")	
	public void skuNumbersError2() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("stockIds", "74966312,74966313");
		address.element("skuNumbers", 11);
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，货物编号类型不正确")	
	public void skuIdsError() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", 2);
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，库存批次ID类型不正确")	
	public void stockIdsError() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", 74966312);
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，货物编号不存在")	
	public void skuIdsNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "222222,333333");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "提交订单失败，库存批次ID不存在")	
	public void stockIdsNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "11111111,11111111");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 栋 3 单元");
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
}
