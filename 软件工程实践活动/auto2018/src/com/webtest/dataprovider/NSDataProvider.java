package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	
	@DataProvider(name="txt")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/user.txt");
	}
	@DataProvider(name="txt1")
	public  Object[][] getTxtData1() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/login_movie.txt");
	}

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `mm_movie` ");
	}
	@Test(dataProvider="excel")
	public void test1(String filename,String petname,String director,String editor,String nation,String language,String minutes
,String picname,String showtime) {
		System.out.println(filename);	
		System.out.println(petname);
		System.out.println(director);
		System.out.println(editor);
		System.out.println(language);
		System.out.println(nation);
		System.out.println(minutes);
		System.out.println(picname);
		System.out.println(showtime);
	}
}
