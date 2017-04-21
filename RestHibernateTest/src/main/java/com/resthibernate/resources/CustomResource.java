package com.resthibernate.resources;


import java.io.IOException;
import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resthibernate.model.Country;
import com.resthibernate.model.CountryResponse;
import com.resthibernate.model.ResponseResult;
import com.resthibernate.model.Status;
import com.resthibernate.model.UserDetails;
import com.resthibernate.services.CountryService;
import com.resthibernate.services.UserServices;

@Path("/customresource")
public class CustomResource {

	@POST
	@Path("/country")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CountryResponse addCountry(Country country){
		
		CountryResponse countryResponse=new CountryResponse(Status.FAILURE, "");
		ObjectMapper objectMapper=new ObjectMapper();
		StringWriter strWriter=new StringWriter();
		
		if(CountryService.addCountry(country)){
			//try {
				countryResponse.setStatus(Status.SUCCESS);
				
				countryResponse.setFailureReason("");
				//objectMapper.writeValue(strWriter, country);
				//countryResponse.setResult(strWriter.toString());
				System.out.println(strWriter.toString());
				//objectMapper.writeValueAsString(country);
		/*	}

			catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/			
		}
		else{
			countryResponse.setFailureReason("Country Id already exist :"+country.getId());
		}
		System.out.println(countryResponse.getFailureReason());
		return countryResponse;
		
	}
	@Path("/user")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public UserDetails addUserDetails(UserDetails userDetails){
		return UserServices.addUser(userDetails);
			
	}
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public UserDetails getUserDetails(@QueryParam(value = "email") final String email){
		return UserServices.getUserDetails(email);
	}
	
	@GET
	@Path("/country")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Country getCountryDetails(@QueryParam(value = "country") final String country){
		return UserServices.getCountryDetails(country);
	}
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country")
	public String showCountry(){
		return "Country Get RESOURCE";
	}*/
}
