package id.co.blog.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/dig")
public class ServerJson {
	
	@POST
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponseJson(InputStream incomingData) {
		JSONObject job = new JSONObject();
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());	// -> data from client
		
		job.put("responseCode", "00");
		job.put("describtionCode", "Trx Success !!");
		return Response.status(200).entity(job.toString()).build();
		
	}
}
