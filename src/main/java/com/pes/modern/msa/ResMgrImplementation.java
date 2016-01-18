package com.pes.modern.msa;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResMgrImplementation implements ResMgr {



//this is my second commit	
		
	//static final String Image = null;

	//public String Image;

	@SuppressWarnings("unused")
	public List<ContainerModel> getList()
			
	{
		String json = Execute("url","action");
		
        try
        {         	
        	
        	JSONArray firstarray = new JSONArray(json);
           					
			
			for(int i=0 ; i<firstarray.length(); i++)
			{  
                   
                   				// iterate through jsonArray 
				JSONObject jsonObject = firstarray.getJSONObject(i);
		       
				JSONArray Names = jsonObject.getJSONArray("Names");
			    String Image =(String) jsonObject.get("Image");
				String Id = (String)  jsonObject.get("Id");
				String Status =(String) jsonObject.get("Status");
				
				System.out.println("ContainerImageName=" + Image);
		        System.out.println( "ContainerID=" + Id);
			    System.out.println("ContainerStatus=" + Status);
			    System.out.println("ContainerName=" + Names);
		 
			   }
			 }
		
		catch (JSONException e) {
			e.printStackTrace();
		}  
        return null;
            
	}
	
				
	
	
	
	public String Execute(String url, String action) {
		
		// TODO Auto-generated method stub
		StringBuilder ret = new StringBuilder(2000);
	
		try  
	    {
	    String url1 = " http://localhost:2375/containers/json?all=true";


		    URL obj = new URL(url1);
		    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

		    conn.setRequestProperty("Content-Type", "application/json");
		    conn.setDoOutput(true);

		    conn.setRequestMethod("GET");

		    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		 		    String line;
			while ((line = in.readLine()) != null)
			{
				ret.append(line).append("\n");
			}
			return ret.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	
	}

	
	public String createContainer() {
		// TODO Auto-generated method stub
		
		String result = Execute1(" url","action","Image");
		return result;
	}
	
	public String Execute1(String url, String action,String Image)
	{
		
	StringBuilder ret = new StringBuilder(2000);
	
		try  
	    {
	    String url1 = " http://localhost:2375/containers/create ";
	    		 	    


		    URL obj = new URL(url1);
		    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

		    conn.setRequestProperty("Content-Type", "application/json/apurvagosavi/mysql");
		    conn.setDoOutput(true);

		     conn.setRequestMethod("POST");
		    
		   // conn.setString Image1 = "apurvagosavi/mysql";
			// OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			 //out.write(data);
		    //out.close();*/

		    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		 		    String line;
			while ((line = in.readLine()) != null)
			{
				ret.append(line).append("\n");
			}
			return ret.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	
	}

	//return result;
	
}


	
