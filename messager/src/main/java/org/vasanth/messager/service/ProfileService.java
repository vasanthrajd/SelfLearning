package org.vasanth.messager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.vasanth.messager.model.Profile;
import org.vasanth.messanger.database.DatabaseClass;

public class ProfileService {
	private static Map<Long, Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService(){
			profiles.put(1L,new Profile(1L, "VasanthCrusader","Vasanthraj","Devaraju",new Date()));
	}
	
	public static Profile getProfiles(){
		
		return (profiles.get(1L));
	}
	public static Profile setProfiles(Profile profile){
		Profile tmpProfile=new Profile();
		tmpProfile.setProfileName(profile.getProfileName());
		tmpProfile.setFirstName(profile.getFirstName());
		tmpProfile.setLastName(profile.getLastName());
		tmpProfile.setCreated(new Date());
		profiles.put(2L, tmpProfile);
		return tmpProfile;
	}
}
