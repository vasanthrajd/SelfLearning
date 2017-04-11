package com.vasanth.client;

import org.json.*;


public class RunRestAPITest {
	

    // update these
    public static String ACCESS_SERVER_URL = "http://localhost:6232/resource";
    public static String USER_NAME = "mhegde@mobilecomplete.com";
    public static String PASSWORD = "111111";
    public static int MCD = 25037;
    //String filename = "android-rottentomatoes-demo-debug.apk";
    String filename = "ExpenseManager.apk";
    //String filename = "ExpenseManagerBad.apk";
    String appVersion = "1.2";
    String appName = "ExpenseManager";
    String appType = "ANDROID_APK";
    
    public void testAPI(){

        ACCESS_SERVER_URL = System.getProperty("ACCESS_SERVER_URL", ACCESS_SERVER_URL);
        USER_NAME = System.getProperty("USER_NAME", USER_NAME);
        PASSWORD = System.getProperty("PASSWORD", PASSWORD);
        String mcd  = System.getProperty("MCD", Integer.toString(MCD, 10));
        MCD = Integer.parseInt(mcd);
        // create session, positive test case
        String sessionID = createSession(USER_NAME, PASSWORD);
        if (sessionID == null || sessionID.isEmpty()) {
            System.out.println("Cannot login");
        }
        System.out.println("Session id" + sessionID);
        // create project application table.


    }
    private String createSession(String email, String password){
    	JSONObject jsonObject;
    	return null;
    }
    
}
