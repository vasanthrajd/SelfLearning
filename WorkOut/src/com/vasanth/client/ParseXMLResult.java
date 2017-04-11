package com.vasanth.client;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

public class ParseXMLResult {
	
	public static void main(String[] args){
		//File xmlFile=new File("C:\\Users\\ee206105\\Desktop\\Today's Task\\Parsing\\565_466_xunit.xml");
		File xmlFile=new File("C:\\Users\\ee206105\\Desktop\\xunit-495.xml");
		DocumentBuilderFactory xmlBase=DocumentBuilderFactory.newInstance();
	
		try {
			
			DocumentBuilder document=xmlBase.newDocumentBuilder();
			Document xDocument=document.parse(xmlFile);
			String baseTag=xDocument.getDocumentElement().getNodeName();
			System.out.println("Base Tag"+baseTag);
			NodeList node=xDocument.getElementsByTagName(baseTag);
			NodeList node1=xDocument.getElementsByTagName("testsuite");
			NodeList node2=xDocument.getElementsByTagName("testcase");
		//	locateTagResult(node2);
			locateTagResult(node1);
			
			NodeList nodeList=xDocument.getDocumentElement().getChildNodes();
			
			
			NodeList nodeList1=xDocument.getElementsByTagName("test-case");
			String str1=locateTestCase(nodeList1);
			
						
			//System.out.println(str1);*/
			NodeList nodeList2=xDocument.getElementsByTagName("test-run");
			String str2=locateTestCase(nodeList2);
			System.out.println(str2);
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
	
		}
	}
	
	public static void identifyNode(NodeList nodeList){
		for(int i=0;i<nodeList.getLength();i++){
			Node tempNode=nodeList.item(i);
			if(tempNode.getNodeType()==Node.ELEMENT_NODE){
				//System.out.print(tempNode.getNodeName()+"<Open>");
				if(tempNode.hasAttributes()){
						
						NamedNodeMap namedNodeMap=tempNode.getAttributes();
						for(int j=0;j<namedNodeMap.getLength();j++){
							Node node=namedNodeMap.item(j);
							System.out.print("\t"+node.getNodeName());
							System.out.print("="+node.getNodeValue());
							
						}
					System.out.println();
				}
				if(tempNode.hasChildNodes()){
					identifyNode(tempNode.getChildNodes());
				}
				System.out.println(tempNode.getNodeName()+"<close>");
			}
		}
	}
	private static String locateTestCase(NodeList nodeList){
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<nodeList.getLength();i++){
		
			Node tempNode=nodeList.item(i);
			
			if(tempNode.getNodeType()==Node.ELEMENT_NODE){
							
				if(tempNode.hasAttributes()&&tempNode.hasChildNodes()){
					
					NamedNodeMap nodemap=tempNode.getAttributes();
					if(tempNode.getNodeName()=="test-run"){
						//System.out.println(nodemap.getNamedItem("total").getNodeValue()+"\n"+nodemap.getNamedItem("duration")+"\n"+nodemap.getNamedItem("failed")+"\n"+nodemap.getNamedItem("skipped")+"\n");

						/*
						System.out.println(nodemap.getNamedItem("duration").getNodeValue());
						System.out.println(nodemap.getNamedItem("total").getNodeValue());
						System.out.println(nodemap.getNamedItem("failed").getNodeValue());
						System.out.println(nodemap.getNamedItem("skipped").getNodeValue());*/
						Float f=Float.parseFloat(nodemap.getNamedItem("duration").getNodeValue());
						Long lduration=(long)Math.round(f*1000);
						//System.out.println(lduration);
						
						String startTime=nodemap.getNamedItem("start-time").getNodeValue();
						String endTime=nodemap.getNamedItem("end-time").getNodeValue();
						/*System.out.println(startTime);
						System.out.println(endTime);*/
						SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat sFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
						String showTime1="2016-12-09 17:06:54.817";
						String showTime2="2016-12-09 17:08:11.233";
						
						try {
							Date sdate=sFormat1.parse(startTime.replaceAll("Z$", "+0000"));
							Date edate=sFormat1.parse(endTime.replaceAll("Z$", "+0000"));
						/*	System.out.println(sdate);
							System.out.println(edate);
							long duration=edate.getTime()-sdate.getTime();
							System.out.println(duration/1000);*/
							
							/*System.out.println("Duration"+duration);
							System.out.println(new Date(System.currentTimeMillis()));
							System.out.println(112*1000);
							System.out.println(new Date(System.currentTimeMillis()+(112*1000))); */
						/*	Date showDate1=sFormat.parse(showTime1);
							Date showDate2=sFormat.parse(showTime2);
							System.out.println("Formated Date"+showDate1);
							System.out.println("Formated Date"+showDate2);
							System.out.println(showDate2.getTime()-showDate1.getTime());
							System.out.println();
							System.out.println(new Date(1481287164000l));
							System.out.println(new Date(1481287230062l));
							System.out.println(1481287230062l-1481287164000l);
							System.out.println(1481287230278l-1481287162193l); */
							
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						Long l=(long) Math.round(f);
						//System.out.println(l);
						

					}
					if(tempNode.getNodeName()=="test-case"){
						System.out.println(nodemap.getNamedItem("name")+"\n"+nodemap.getNamedItem("result")+"\n"+nodemap.getNamedItem("duration")+"\n"+nodemap.getNamedItem("methodname")+"\n");
						if(nodemap.getNamedItem("result").getNodeValue().contains("Failed")){
							NodeList innerNode=tempNode.getChildNodes();
							
							for(int j=0;j<innerNode.getLength();j++){
							
								if(innerNode.item(j).getNodeName().contains("failure")){
									System.out.println(innerNode.item(j).getTextContent());
									//str.append(innerNode.item(j).getNodeName()+"="+innerNode.item(j).getTextContent()+"\n");
								
								}
							}
						}
						if(nodemap.getNamedItem("result").getNodeValue().contains("Skipped")){
							System.out.println("Skipped. the Test Case");
							NodeList innerNode=tempNode.getChildNodes();
							for(int k=0;k<innerNode.getLength();k++){
								if(innerNode.item(k).getNodeName().contains("reason")){
									System.out.println("Skipped Reason"+innerNode.item(k).getTextContent());
								}
							}
						}
					
					}
					/*Map<String,String> map=new HashMap<String,String>();
					for(int j=0;j<nodemap.getLength();j++){
						map.put(nodemap.item(j).getNodeName(), nodemap.item(j).getNodeValue());
					}
					Set<String> set=map.keySet();
					for(String tmp:set){
						if(tmp.contains("name") || tmp.contains("methodname") || tmp.contains("result") || tmp.contains("duration"))
							System.out.println(tmp+"\t"+map.get(tmp));
					}
					
					str.append(nodemap.getNamedItem("name")+"\n").append(nodemap.getNamedItem("result")+"\n").append(nodemap.getNamedItem("duration")+"\n");*/
									
					NodeList innerNode=tempNode.getChildNodes();
			
					for(int j=0;j<innerNode.getLength();j++){
					
						if(innerNode.item(j).getNodeName().contains("failure")){
						
							str.append(innerNode.item(j).getNodeName()+"="+innerNode.item(j).getTextContent()+"\n");
						
						}
					}
				}
			}
		}
		return str.toString();
	}
	private static void locateTagResult(NodeList nodeList) throws Exception{
		for(int i=0;i<nodeList.getLength();i++){
			Node tempNode=nodeList.item(i);
			if(tempNode.getNodeType()==Node.ELEMENT_NODE){
				if(tempNode.getNodeName().equals("testsuite")){
					if(tempNode.hasAttributes()){
						NamedNodeMap namedNodeMap=tempNode.getAttributes();
						/*System.out.println(namedNodeMap.getNamedItem("tests"));
						System.out.println(namedNodeMap.getNamedItem("failures"));
						System.out.println(namedNodeMap.getNamedItem("errors"));
						System.out.println(namedNodeMap.getNamedItem("skipped"));
						
						System.out.println(namedNodeMap.getNamedItem("time"));*/
						//System.out.println(namedNodeMap.getNamedItem("timestamp"));
						String time=namedNodeMap.getNamedItem("timestamp").getNodeValue();
						System.out.println("Time="+time);
						
						SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss");
						simpleDateFormat.setTimeZone(TimeZone.getDefault());
						
						
						System.out.println("Conversion\t"+simpleDateFormat.parse(time));
						
											
						Date localTime=simpleDateFormat.parse(time);
						System.out.println("Date Read from the file \t"+localTime.getTime());
						
						System.out.println(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
						
						Date systime=new Date(localTime.getTime()+TimeZone.getDefault().getOffset(System.currentTimeMillis()));
						
						System.out.println(System.currentTimeMillis());
						
						System.out.println("Converted Time \t"+systime.getTime());
						
						
						
						System.out.println("to local String\t"+localTime);
						System.out.println(systime);
						
					
						/*Date startTime=simpleDateFormat.parse(time.replaceAll("T", " "));
						
						System.out.println("Parsed Date \t"+startTime.getTime());
						System.out.println("Long Seconds \t"+startTime.getTime());
						
												
						Float totalTime=Float.parseFloat(namedNodeMap.getNamedItem("time").getNodeValue());
						System.out.println(new Date(System.currentTimeMillis()));
						long duration=System.currentTimeMillis()+(long)(totalTime*1000);
						System.out.println(duration);
						System.out.println(new Date(duration)); */
						
					}
				}else if(tempNode.getNodeName().equals("testcase")){
					if(tempNode.hasChildNodes()){
						System.out.println(tempNode.getTextContent());
					}
					if(tempNode.hasAttributes()){
						NamedNodeMap namedNodeMap=tempNode.getAttributes();
						System.out.println(namedNodeMap.getNamedItem("classname").getNodeValue());
						System.out.println(namedNodeMap.getNamedItem("name"));
						System.out.println(namedNodeMap.getNamedItem("time"));
						Float totalTime=Float.parseFloat(namedNodeMap.getNamedItem("time").getNodeValue());
						System.out.println(new Date(System.currentTimeMillis()));
						long duration=System.currentTimeMillis()+(long)(totalTime*1000);
						System.out.println(duration);
						System.out.println(new Date(duration));
						
					}
				}
				/*if(tempNode.hasChildNodes()){
					NodeList innerNodeList=tempNode.getChildNodes();
					locateTagResult(innerNodeList);
				}*/
			}
		}	
	}
	
	private static String locateTestRun(NodeList nodeList){
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<nodeList.getLength();i++){
		
			Node tempNode=nodeList.item(i);
			
			if(tempNode.getNodeType()==Node.ELEMENT_NODE){
							
				if(tempNode.hasAttributes()&&tempNode.hasChildNodes()){
					
					NamedNodeMap nodemap=tempNode.getAttributes();
					
					Map<String,String> map=new HashMap<String,String>();
					for(int j=0;j<nodemap.getLength();j++){
						map.put(nodemap.item(j).getNodeName(), nodemap.item(j).getNodeValue());
					}
					Set<String> set=map.keySet();
					if(tempNode.getNodeName()=="test-run"){
						System.out.println(tempNode.getNodeName());
					}
					for(String tmp:set){
						if(tmp.contains("total") || tmp.contains("duration") || tmp.contains("failed") || tmp.contains("skipped"))
							System.out.println(tmp+"\t"+map.get(tmp));
					}
					
				//	str.append(nodemap.getNamedItem("name")+"\n").append(nodemap.getNamedItem("result")+"\n").append(nodemap.getNamedItem("duration")+"\n");
									
					NodeList innerNode=tempNode.getChildNodes();
			
					for(int j=0;j<innerNode.getLength();j++){
					
						if(innerNode.item(j).getNodeName().contains("failure")){
						
							str.append(innerNode.item(j).getNodeName()+"="+innerNode.item(j).getTextContent()+"\n");
						
						}
					}
				}
			}
		}

		return "";
	}
}
