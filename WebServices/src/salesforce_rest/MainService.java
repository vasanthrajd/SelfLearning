package salesforce_rest;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;
import java.util.*; 
public class MainService {
    /*  
    static final String USERNAME     = "username@salesforce.com";
    
    static final String PASSWORD     = "passwordSecurityToken";
    static final String LOGINURL     = "https://login.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID     = "ConsumerKeyFromSalesfoceConnectedApps";
    static final String CLIENTSECRET = "ConsumerSecretFromSalesforceConnectedApps";
 	*/
	static final String USERNAME     = "vasanthrajdevaraju@gmail.com";
    static final String PASSWORD     = "learnintegration16XnlXT2yIVggtqoQ8Hew5P7E0";
    static final String LOGINURL     = "https://login.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID     = "3MVG9Y6d_Btp4xp6ElZyxvdzQ3MV1JVI7hlKdfIiTga5ZGR2lg.UN1d3eJHBa7Cj.rSRzuH5kGMXK8KwhgaAj";
    static final String CLIENTSECRET = "7496477234252567477";
    private static String REST_ENDPOINT = "/services/data" ;
    private static String API_VERSION = "/v32.0" ;
    private static String baseUri;
    private static Header oauthHeader;
    private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
    private static String leadId ;
    private static String leadFirstName;
    private static String leadLastName;
    private static String leadCompany;
    
    
    public static void main(String[] args) {
 
        HttpClient httpclient = HttpClientBuilder.create().build();
        
        // Assemble the login request URL
        String loginURL = LOGINURL +
                          GRANTSERVICE +
                          "&client_id=" + CLIENTID +
                          "&client_secret=" + CLIENTSECRET +
                          "&username=" + USERNAME +
                          "&password=" + PASSWORD;
 
        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse response = null;
        /*
        List<String> parameter=new ArrayList<String>();
        
        parameter.add("/services/oauth2/token?grant_type=password");
        parameter.add("username=vasanthrajdevaraju@gmail.com");
        parameter.add("password=learnintegration16p4meXkQfy947MfrrZuXhpliq");
        parameter.add("client_id=3MVG9Y6d_Btp4xp6ElZyxvdzQ3MV1JVI7hlKdfIiTga5ZGR2lg.UN1d3eJHBa7Cj.rSRzuH5kGMXK8KwhgaAj");
        parameter.add("client_secret=7496477234252567477");
        */
        
        
 
        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        
        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: "+statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return;
        }
 
        System.out.println(response.getAllHeaders().toString());
        System.out.println(response.getFirstHeader("Content-Type"));
        
        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;
        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
            
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        baseUri=loginInstanceUrl+REST_ENDPOINT+API_VERSION;
        oauthHeader= new BasicHeader("Authorization", "OAuth "+loginAccessToken);
        
        System.out.println(jsonObject.toString());
        System.out.println(response.getStatusLine());
        System.out.println("Successful login");
        System.out.println("  instance URL: "+loginInstanceUrl);
        System.out.println("  access token/session ID: "+loginAccessToken);
        System.out.println("  base URI: "+baseUri);
        System.out.println("  aAuthHeader:"+ oauthHeader);
        
        RestRequest.queryLeads(baseUri, oauthHeader, prettyPrintHeader);
        // release connection
        httpPost.releaseConnection();
    }
}