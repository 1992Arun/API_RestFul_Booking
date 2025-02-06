package org.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.auth.Auth;
import org.postRequest.Bookingdates;
import org.postRequest.Parent;
import org.putRequest.PUTBookingdates;
import org.putRequest.PUTParent;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import patchUpdate.PatchParent;

public class UtilityClass {
	
	
	public static String getProperty(String key){
		

			Properties p = new Properties();
			
			try {
				
				FileReader f = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Confic.properties");
				
				p.load(f);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String property = p.getProperty(key);
	
		return property;
		
	}
	
	

	
	
	public static Auth getAuthBody(){
		
		Auth a = new Auth();
		
		a.setUsername(getProperty("UserName"));
		
		
		a.setPassword(getProperty("Password"));
		
		
		return a;
		
		
	}
	
	public static Parent postRequestBody() {
		
		
		Bookingdates b = new Bookingdates();
		
		b.setCheckin(getProperty("checkin"));
		
		b.setCheckout(getProperty("checkout"));
		
		Parent p = new Parent();
		
		p.setAdditionalneeds(getProperty("additionalneeds"));
		
		p.setBookingdates(b);
		
		p.setDepositpaid(getProperty("depositpaid"));
		
		p.setFirstname(getProperty("firstname"));
		
		p.setLastname(getProperty("lastname"));
		
		p.setTotalprice(getProperty("totalprice"));
		
		
		return p;
		
		
	}
	
	public static PUTParent putRequestBody() {
	
	PUTBookingdates b = new PUTBookingdates();
		
		b.setCheckin(getProperty("PUTcheckin"));
		
		b.setCheckout(getProperty("PUTcheckout"));
		
		PUTParent p = new PUTParent();
		
		p.setAdditionalneeds(getProperty("PUTadditionalneeds"));
		
		p.setBookingdates(b);
		
		p.setDepositpaid(getProperty("PUTdepositpaid"));
		
		p.setFirstname(getProperty("PUTfirstname"));
		
		p.setLastname(getProperty("PUTlastname"));
		
		p.setTotalprice(getProperty("PUTtotalprice"));
		
		
		return p;
		
	}public static PatchParent patchRequestBody() {
	
		PatchParent p = new PatchParent();
		
		p.setFirstname(getProperty("Patchfirstname"));
		
		p.setLastname(getProperty("Patchlastname"));
		
		return p;
		
		
	}
	
	public static void getJVMReport(String json){
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\JVMReport.html");
		
		Configuration conf = new Configuration(f, "API Report");
		
		conf.addClassifications("UserName", System.getProperty("user.name"));
		
		conf.addClassifications("OS", System.getProperty("os.name"));
		
		List<String> li = new LinkedList();
		
		li.add(json);
		
		ReportBuilder rb = new ReportBuilder(li, conf);
	
		rb.generateReports();
		
	}
	

}
