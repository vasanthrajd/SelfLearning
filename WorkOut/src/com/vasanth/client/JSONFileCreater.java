package com.vasanth.client;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONWriter;
import java.util.*;

public class JSONFileCreater {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
			try {
				FileWriter fw=new FileWriter("E:\\DeveloperAutomationTask\\Environment.json");
				JSONWriter jw=new JSONWriter(fw);
				
				Map<String,String> envVar=System.getenv();
				Set<String> keyName=envVar.keySet();
				jw.object();
				for(String key:keyName){
					jw.key(key).value(envVar.get(key));
					System.out.println(key+"==="+envVar.get(key));
					
				}
				jw.endObject();
				fw.close();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
