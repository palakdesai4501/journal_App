package com.palak.journalApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palak.journalApp.entity.JournalEntry;
import com.palak.journalApp.repository.JournalEntryRepository;

@Component
@Slf4j
public class JournalEntryService {
	
	@Autowired
	private JournalEntryRepository journalEntryRepository;

	public void saveEntry(JournalEntry journalEntry) {
		try {
			journalEntry.setDate(LocalDateTime.now());
			journalEntryRepository.save(journalEntry);
		} catch (Exception e){
			log.error("Exception ", e);
		}
	}
	
	public List<JournalEntry> getAll(){
		return journalEntryRepository.findAll();
	}
	
	public Optional<JournalEntry> findById(ObjectId id) {
		return journalEntryRepository.findById(id);
	}
	
	public void deleteById(ObjectId id) {
		journalEntryRepository.deleteById(id);
	}

}
