package com.vasanth.restapi.scmessenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vasanth.restapi.scmessenger.Service.ProfileService;
import com.vasanth.restapi.scmessenger.model.Profile;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService proService=new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return proService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getSingleProfile(@PathParam("profileName") String profileName){
		return proService.getProfile(profileName);
	}
	
	@POST
	public Profile addSingleProfile(Profile profile){
		return proService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateSingleProfile(@PathParam("profileName") String profileName,Profile profile){
		profile.setProfileName(profileName);
		return proService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void removeSingleProfile(@PathParam("profileName") String profileName){
		proService.removeProfile(profileName);
	}
}
