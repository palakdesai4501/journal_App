package com.palak.journalApp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palak.journalApp.entity.JournalEntry;
import com.palak.journalApp.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

	@Autowired
	private JournalEntryService journalEntryService; 
	
	@GetMapping
	public List<JournalEntry> getAll(){
		return journalEntryService.getAll();
	}
	
	@PostMapping
	public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
		myEntry.setDate(LocalDateTime.now());
		journalEntryService.saveEntry(myEntry);
		return myEntry;
	}
	
	@GetMapping("id/{myId}")
	public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
		return journalEntryService.findById(myId).orElse(null);
	}
	
	@DeleteMapping("id/{myId}")
	public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
		journalEntryService.deleteById(myId);
		return true;
	}
	
	@PutMapping("/id/{id}")
	public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
		JournalEntry old = journalEntryService.findById(id).orElse(null);
		if(old != null) {
			old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
			old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
		}
		journalEntryService.saveEntry(old);
		return old;
	}
}
