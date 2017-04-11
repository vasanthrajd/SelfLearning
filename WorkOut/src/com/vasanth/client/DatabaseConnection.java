package com.vasanth.client;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.vasanth.client.Country;

import com.microsoft.sqlserver.*;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/*
 * Data Base Connection Setup Check
 */
public class DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Country> countryList=new ArrayList<Country>();
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL="jdbc:sqlserver://10.51.2.57:1433;DatabaseName=dadeveloper";
			conn=DriverManager.getConnection(dbURL,"sa","Keynote@123");
			String sql ="select * from country";
			PreparedStatement pr=conn.prepareStatement(sql);
			ResultSet rs=pr.executeQuery();
			ResultSetMetaData md=(ResultSetMetaData)rs.getMetaData();
			int col=md.getColumnCount();
			int row=rs.getRow();
			System.out.println(row);
			for(int i=1;i<=col;i++){
				
				System.out.print(md.getColumnName(i)+"\t");
				
			}
			System.out.println(rs.getMetaData());
			
			while(rs.next()){
				Country country=new Country();
				country.setId(rs.getString(1));
				country.setCode(rs.getString(2));
				country.setPaypalsupport(rs.getString(3));
				countryList.add(country);
				
			}
			for(Country tmpCountry:countryList){
				System.out.println(tmpCountry.getId()+"\t"+tmpCountry.getCode()+"\t"+tmpCountry.isPaypalsupport());
			}
			Country country=countryList.get(1);
			try{
			JSONObject jo=new JSONObject();
				//jo.put("deviceInformation", countryList.get(1));
				jo.valueToString(countryList.get(1));
			//jo.put("deviceInformation", country.toString());
			//jo.put(country.getCode(),country.getCode());
			jo.put(country.getId(),country.getId());
			jo.put(country.isPaypalsupport(), country.isPaypalsupport());
				
			StringWriter sw=new StringWriter();
			jo.write(sw);
			
			System.out.println(sw.toString());
			System.out.println(sw);
			}
			catch(JSONException e){
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
