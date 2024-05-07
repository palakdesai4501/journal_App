package com.palak.journalApp.controller;

import com.palak.journalApp.entity.JournalEntry;
import com.palak.journalApp.entity.User;
import com.palak.journalApp.service.JournalEntryService;
import com.palak.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAll();
	}

	@PostMapping
	public void createUser(@RequestBody User user){
		userService.saveEntry(user);
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user){
		User userInDb = userService.findByUserName(user.getUserName());
		if (userInDb != null){
			userInDb.setUserName(user.getUserName());
			userInDb.setPassword(user.getPassword());
			userService.saveEntry(userInDb);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}