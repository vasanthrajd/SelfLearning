package com.vasanth.restapi.scmessenger.Service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.vasanth.restapi.scmessenger.DataBase.DatabaseClass;
import com.vasanth.restapi.scmessenger.model.Profile;

public class ProfileService {

	private  Map<String, Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Vasanth", new Profile(1, "Vasanth", "Vasnath", "raj"));
	}
	
	

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile getProfile(String profilename){
		return profiles.get(profilename);
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profilename){
		return profiles.remove(profilename);
	}
	
}
