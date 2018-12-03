package id.latihan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class TestClientBlog {
	public static void main(String[] args) {
		try {
			
			JSONObject jsonObject = new JSONObject();
			 
			jsonObject.put( "id", "Crunchify");
			jsonObject.put( "topic", "REST Service");
			jsonObject.put( "description", "This is REST Service Example by Crunchify.");
			System.out.println("Send Json : ");
			System.out.println(jsonObject);
 
			// Step2: Now pass JSON File Data to REST Service
			try {
				URL url = new URL("http://localhost:8080/BlogProject/dig/json");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = null; 
				
				System.out.println("\nResponse ");
				while ( (line = in.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("\nSuccessfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling Crunchify REST Service");
				System.out.println(e);
			}
 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
