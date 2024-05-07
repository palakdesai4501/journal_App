package com.palak.journalApp.repository;

import com.palak.journalApp.entity.JournalEntry;
import com.palak.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    User findByUserName(String username);
}
