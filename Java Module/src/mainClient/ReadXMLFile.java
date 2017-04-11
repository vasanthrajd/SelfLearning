package mainClient;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public static void main(String[] args) {
		try{
		// TODO Auto-generated method stub
		File xmlFile=new File("C:\\Users\\ee206105\\workspace\\Java Module\\File.xml");
		DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
		Document doc=docBuilder.parse(xmlFile);
		System.out.println(doc);
		NodeList nNode=doc.getElementsByTagName("staff");
		System.out.println("----Node List-----");
		for(int temp=0;temp<nNode.getLength();temp++){
			Node nItem=nNode.item(temp);
			System.out.println("\nCurrent Node Name:="+nItem.getNodeName());
			if(nItem.getNodeType()==Node.ELEMENT_NODE){
				Element eElement=(Element)nItem;
				System.out.println("\tStaff ID:="+eElement.getAttribute("id"));
				System.out.println("\tFirst Name:="+eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("\tLast Name:="+eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("\tNick Name:="+eElement.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("\tSalary Name:="+eElement.getElementsByTagName("salary").item(0).getTextContent());
			}
			
		
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
