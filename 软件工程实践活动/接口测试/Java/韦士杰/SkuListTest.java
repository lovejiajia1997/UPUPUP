package QingGuo;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

/**
*  
* @author weishijie
* 
**/

public class SkuListTest {
	String url = "/common/skuList";
	String result = null;
	public String getMessage(String result) {
		JSONObject json =JSONObject.fromObject(result);
		return json.getString("message");
	}
	
	public void skulist(){
		try {
			result = HttpDriver.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		assertEquals(this.getMessage(result),"success");
	}
	
	public void skulist(String addUrl) {
		try {
			result = HttpDriver.doGet(url,addUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		
	}
	
	@Test(description="获取所有商品的sku列表成功")
	public void skulist1(){
		this.skulist();
		assertEquals(this.getMessage(result),"success");
	}
	@Test(description="获取goodsId=1的商品sku信息成功")
	public void skulist2(){
		this.skulist("goodsId=1");
		assertEquals(this.getMessage(result),"success");
	}
	
	@Test(description="获取goodsId=2147483648的商品sku信息失败(超过int最大取值范围)")
	public void skulist3() {
		this.skulist("goodsId=2147483648");
		assertEquals(this.getMessage(result),"success");
	}
	@Test(description="获取goodsId不存在的商品失败")
	public void skulist4() {
		this.skulist("goodsId=1999");
		assertEquals(this.getMessage(result),"success");
	}
	@Test(description="goodsId类型不正确")
	public void skulist5() {
		
		this.skulist("goodsId=1.12");
		assertEquals(this.getMessage(result),"Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Long' for property 'goodsId'; nested exception is java.lang.NumberFormatException: For input string: \"1.12\"");
	}
	
	


	}
	
	

	