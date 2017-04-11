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

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class JSONSF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://login.salesforce.com";
		String un="vasanthrajdevaraju@gmail.com";
		String pw="learnintegration16";
		try{
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("un", un);
			jsonObject.put("pw", pw);
			StringWriter writer=new StringWriter();
			jsonObject.write(writer);
			InputStream[] result=requestURL(url,"POST","application/json","application/json",writer.toString());
			if(result[0]!=null){
				//JSONObject respones=getJSONObject(result[0]);
				byte[] by=new byte[1024];
				System.out.println(result[0].read(by, 0, by.length));
				String str=new String(by, 0, by.length);
				System.out.println(str);
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	private static JSONObject getJSONObject(InputStream input){
		byte[] readValue=new byte[1024];
		StringBuffer buff=new StringBuffer();
		JSONObject jsonReturn=null;
		try {
			int length=input.read(readValue, 0, readValue.length);
			while(length>0){
				String msg=new String(readValue, 0, length);
				buff.append(msg);
				length=input.read(readValue, 0, readValue.length);
			}
			System.out.println(buff.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JSONObject();
	}
	private static InputStream[] requestURL(String url, String method, String contentType, String accept, String body) throws MalformedURLException, IOException{
		HttpURLConnection conn=null;
		if(url.contains("https")){
			conn=(HttpsURLConnection) new URL(url).openConnection();
		}else{
			conn=(HttpURLConnection)  new URL(url).openConnection();
		}
		conn.setRequestMethod(method);
		conn.setRequestProperty("Content-Type", contentType);
		conn.setRequestProperty("Accept", accept);
		conn.setRequestProperty("Content-transfer-encoding", "UTF-8");
		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; .NET CLR 1.0.3705;)");
		conn.setDoInput(true);
		if(body!=null){
			conn.setDoOutput(true);
			final OutputStream output=conn.getOutputStream();
			final OutputStreamWriter owriter=new OutputStreamWriter(output);
			owriter.write(body);
			owriter.flush();
			output.close();
		}
		conn.connect();
		conn.disconnect();
		
		InputStream response=conn.getInputStream();
		InputStream errResponse=conn.getErrorStream();
		
		return Arrays.asList(response,errResponse).toArray(new InputStream[0]);
	}

}
