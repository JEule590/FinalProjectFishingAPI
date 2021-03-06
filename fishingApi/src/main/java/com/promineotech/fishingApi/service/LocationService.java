package com.promineotech.fishingApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.fishingApi.entity.Location;
import com.promineotech.fishingApi.repository.LocationRepository;

@Service
  public class LocationService {
	
	@Autowired
	private LocationRepository repo;
   
 
	public Location createLocation(Location location, Long waterbodyId)  {
		return repo.save(location);
   }
	
	public void deleteLocation(Long locationId) throws Exception {
		try {
			repo.delete(locationId);   //deleteById
		} catch (Exception e) {
			throw new Exception();
		}
	}
 
}
