package com.resthibernate.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.resthibernate.model.Country;
import com.resthibernate.model.CountryResponse;
import com.resthibernate.model.ResponseResult;
import com.resthibernate.model.Status;
import com.resthibernate.services.CountryService;

@Path("/customresource")
public class CustomResource {

	@POST
	@Path("/country")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CountryResponse addCountry(Country country){
		
		CountryResponse countryResponse=new CountryResponse(Status.FAILURE, "");
		if(CountryService.addCountry(country)){
			countryResponse.setStatus(Status.SUCCESS);
			countryResponse.setCountry(country);
			countryResponse.setFailureReason("");
		}
		else{
			countryResponse.setFailureReason("Country Id already exist :"+country.getId());
		}
		System.out.println(countryResponse.getFailureReason());
		return countryResponse;
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country")
	public String showCountry(){
		return "Country Get RESOURCE";
	}
}
