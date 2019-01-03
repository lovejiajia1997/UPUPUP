package shisujia;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;



public class Login_Test extends BaseTest{

	Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	@Test
	public void testLogin() throws Exception  {
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		action.login();
	}

}