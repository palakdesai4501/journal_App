package com.palak.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palak.journalApp.entity.JournalEntry;
import com.palak.journalApp.repository.JournalEntryRepository;

@Component
public class JournalEntryService {
	
	@Autowired
	private JournalEntryRepository journalEntryRepository;
	
	public void saveEntry(JournalEntry journalEntry) {
		journalEntryRepository.save(journalEntry);
	}
	
	public List<JournalEntry> getAll(){
		return journalEntryRepository.findAll();
	}
	
	public Optional<JournalEntry> findById(ObjectId id) {
		return journalEntryRepository.findById(id);
	}

}
