package salesforce_soap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
public class SoapMain {

	
		
	/*static {
		File propertyFile = new File("Properties");
		try {
			FileInputStream fileInput = new FileInputStream(propertyFile);
			Properties property=new Properties();
			property.load(fileInput);
			fileInput.close();
			 String USERNAME = property.getProperty("LOGINUSERNAME");
			 String PASSWORD = property.getProperty("LOGINPASSWORDTOKEN");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	*/
	
	static String USERNAME = "vasanthrajdevaraju@gmail.com";
	static String PASSWORD = "learnintegration16XnlXT2yIVggtqoQ8Hew5P7E0";
	static EnterpriseConnection connection;
   
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ConnectorConfig config=new ConnectorConfig();
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD);
		
		try {
			connection=Connector.newConnection(config);
			System.out.println("Authentication Token"+config.getAuthEndpoint());
			System.out.println("Service End Point"+config.getServiceEndpoint());
			System.out.println("UserName"+config.getUsername());
			System.out.println("Session ID"+config.getSessionId());
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
