package com.vasanth.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONCreator {

	public static void main(String[] args) throws JSONException, IOException {
		// TODO Auto-generated method stub
			String url="http://localhost:6232/resource/portal/establish-api-session";
			//String url="https://login.salesforce.com";
			try{
			/*
			 * The below mentioned code will generate the JSON content, which can be used to send the 
			 * request to the server.	
			 */
			JSONObject jo=new JSONObject();
			jo.put("email", "vasanth@sasken.com");
			jo.put("password", "Harmony1");
			
			StringWriter sw=new StringWriter();
			jo.write(sw);
			System.out.println(sw.toString());
			
			InputStream input[]=restResource(url,"POST","application/json", "application/json",sw.toString());

			if(input[0]!=null){
				JSONObject json=getJsonObject(input[0]);
				String str=(String)json.get("status");
				Iterator<String> it=json.keys();
				while(it.hasNext()){
				//	System.out.println(it.next());
					System.out.println(json.get(it.next()));
				}
				Iterator<String> it1=json.keys();
				
				while(it1.hasNext()){
				    System.out.println(it1.next());
					//System.out.println(json.get(it1.next()));
				}
			}
			}		
			catch(JSONException e){
				e.printStackTrace();
			}
	}
	private static InputStream[] restResource(String url, String method, String contentType, String acceptContent,String body) {
			InputStream response=null;
			InputStream errResponse=null;
			HttpURLConnection conn=null;
			try{
				conn= (HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod(method);
				conn.setRequestProperty("Content-Type", contentType);
				conn.setRequestProperty("Accept", acceptContent);
				conn.setRequestProperty("Content-transfer-encoding", "UTF-8");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; .NET CLR 1.0.3705;)");
				conn.setDoInput(true);
				System.out.println("Body"+body);
				if(body!=null){
						conn.setDoOutput(true);

		                final OutputStream output = conn.getOutputStream();
		                final OutputStreamWriter osWriter = new OutputStreamWriter(output, "UTF-8");

		                osWriter.write(body);
		                osWriter.flush();
		                osWriter.close();
		                output.close();
		            }
				conn.connect();
				conn.disconnect();
				errResponse=conn.getErrorStream();
				response=conn.getInputStream();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return Arrays.asList(response,errResponse).toArray(new InputStream[0]);
			
	}
	private static JSONObject getJsonObject(InputStream inputStream) throws IOException{
		byte[] bytesRead = new byte[1024];
		StringBuffer buff=new StringBuffer();
		int length;
		
		do{
			length=inputStream.read(bytesRead, 0, bytesRead.length);
			if(length>0){
				String msg=new String(bytesRead, 0, length);
				buff.append(msg);
			}
		}while(length>0);
		buff.trimToSize();
		JSONObject jsonObject=null;
		try {
			jsonObject = new JSONObject(buff.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
