package Methods;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.csvreader.CsvWriter;


public class G_A {
	public static void main(String args[]) throws ClientProtocolException, IOException
	{
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinaya\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Navigating to Google.com
		driver.get("https://www.google.com");
		//Selecting Search input and providing search text "Datalicious"
		driver.findElement(By.className("gsfi")).sendKeys("Datalicious"); 
		//Selecting the search button
		driver.findElement(By.id("sfdiv")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//int s = driver.findElements(By.id("rso").className("g")).size();
		//System.out.println(s);
		//Selecting the first result
		driver.findElements(By.className("srg").className("g").className("r")).get(0).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    		
		URL G_A = new URL("https://www.google-analytics.com/r/collect");
		URL d_c = new URL("https://dc.optimahub.com/");
				
		//verify Google Analytics "collect" Endpoint Status code
		HttpURLConnection httpCon = (HttpURLConnection) G_A.openConnection();
		if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK)
		{
				System.out.println("Response code for collect endpoint is " + httpCon.getResponseCode());
		}
		 else
		{
				System.out.println("Response code is " + httpCon.getResponseCode());
		}
						
		//verify "collect" Endpoint Status code
		HttpURLConnection httpCon1 = (HttpURLConnection) d_c.openConnection();
		if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK)
		{
				System.out.println("Response code for dc.optimahub.com is " + httpCon1.getResponseCode());
		}
		else
		{
			System.out.println("Response code is " + httpCon1.getResponseCode());
		}
		String path = "/r/collect?v=1&_v=j56&a=913850200&t=pageview&_s=1&dl=https%3A%2F%2Fwww.datalicious.com%2F&dr=https%3A%2F%2Fwww.google.co.in%2F&ul=en-us&de=UTF-8&dt=Marketing%20Data%20Specialists%20%7C%20Datalicious&sd=24-bit&sr=1920x1080&vp=800x864&je=0&_u=yCCAAEADY~&jid=1261772601&gjid=1837744328&cid=1936761257.1500369163&tid=UA-6757849-1&_gid=1992142176.1500890356&_r=1&cd2=&cd3=IN&cd4=tn&cd5=chennai&cd6=not-detected&cd1=&cd7=&cd8=464610432&z=1373374516";
	    //Check if the Google Analytics URL has dt and dp parameters
		if(path.contains("&dt="))
	    		{	System.out.println(" dt parameter - Available");
	    			param(path, "dt");
	    		}
	    			else{ System.out.println("dt parameter - Unavailable"); }
	    if(path.contains("&dp="))
	    		{ 	System.out.println("dp parameter - Available");
	    			param(path, "dp");
	    		}
	    			else{ System.out.println("dp parameter - Unavailable"); }	
	            
		driver.close();	
}
	    


// Reading the parameter and its value and writting it to .CSV file	    
 public static void param(String path, String Parameter) throws IOException
	{
	    CsvWriter csvOutput = new CsvWriter(new FileWriter("D:\\testing\\GA.csv",true),',');
	    String[] params = path.split("&");  
	    Map<String, String> map = new HashMap<String, String>();  
		    for (String param : params)  
		    { 
		    String [] p=param.split("=");
		    String name = p[0];  
		    	if(p.length>1)  
				    {
				    	String value = p[1];  
				    	map.put(name, value);
				    	if (name.equalsIgnoreCase(Parameter))
				    	{
				    		//Priniting the values of dt and writing it in .CSV file
				    		System.out.println(name + " : " + value);
				    		csvOutput.write(name);
				    		csvOutput.write(value);
				    		csvOutput.close();
				    	}
				    }
		    }
		    
	    }  
	    
}



