package com.palak.journalApp.service;

import com.palak.journalApp.entity.JournalEntry;
import com.palak.journalApp.entity.User;
import com.palak.journalApp.repository.JournalEntryRepository;
import com.palak.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void saveEntry(User user) {
			userRepository.save(user);
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(ObjectId id) {
		return userRepository.findById(id);
	}
	
	public void deleteById(ObjectId id) {
		userRepository.deleteById(id);
	}

	public User findByUserName(String userName){
		return userRepository.findByUserName(userName);
	}

}
