package com.promineotech.fishingApi.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.fishingApi.entity.Notes;
import com.promineotech.fishingApi.entity.Results;
import com.promineotech.fishingApi.repository.NotesRepository;
import com.promineotech.fishingApi.repository.ResultsRepository;

@Service
public class NotesService {

	@Autowired
	private NotesRepository repo;
	
	@Autowired
	private ResultsRepository resultsRepo;
	
	public Notes getNotesById(long notesId) {
		try {
			return repo.findOne(notesId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Notes createNotes(Notes notes, Long resultsId) {
		Notes newNotes = new Notes();
		Results newResults = new Results();
		newResults = resultsRepo.findOne(resultsId);
		newNotes.setResults(newResults);
		newNotes.setNotes(notes.getNotes());
		return repo.save(newNotes);
	}
	 
	public void deleteNotes(Long notesId) throws Exception {
		try {
			repo.delete(notesId);
		}catch (Exception e) {
			throw new Exception();
		}
	}
}
