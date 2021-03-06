package com.promineotech.fishingApi.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.fishingApi.entity.Results;
import com.promineotech.fishingApi.entity.Waterbody;
import com.promineotech.fishingApi.repository.ResultsRepository;
import com.promineotech.fishingApi.repository.WaterbodyRepository;
//import com.promineotech.fishingApi.repository.WaterbodyRepository;


@Service
public class ResultsService {
	
	@Autowired
	private ResultsRepository repo;
	
	
	@Autowired
	private WaterbodyRepository waterbodyRepo;
	
	public Iterable<Results> getResultses() {
		return repo.findAll();
	}
	
	public Results getResultsById(Long resultsId) {
		return repo.findOne(resultsId);
	}
	

	
	public Results createResults(Results results, Long waterbodyId) {
		Results newResult = new Results();
		
		Waterbody newBody = new Waterbody();
		newBody = waterbodyRepo.findOne(waterbodyId);
		
		newResult.setWaterbody(newBody);
		newResult.setLargest(results.getLargest());
		newResult.setMethodUsed(results.getMethodUsed());
		newResult.setNumber(results.getNumber());		
		return repo.save(newResult);
		
	}
	
	public void deleteResults(Long results_id)  {
		try {
			repo.delete(results_id);
		} catch (Exception e) {
			 
		}
	}



	//public void deleteResults(Long resultsId) {
		// TODO Auto-generated method stub
		
	}
//public Optional<Results> getResultsById(long resultsId) throws Exception {
//try {
//	return repo.findById(resultsId);         //findOne(resultsId);
//} catch (Exception e) {
//	throw e;
//}
//}

//public Results createResults(Results results, Long waterbodyId) throws Exception{
//Optional<Waterbody> waterbody = waterbodyRepo.findById(waterbodyId);                          //findOne or findById
//if (waterbody == null) {
//	throw new Exception("Waterbody not found");  
//}
//results.setWaterbody(waterbody);
//return repo.save(results);
//}
