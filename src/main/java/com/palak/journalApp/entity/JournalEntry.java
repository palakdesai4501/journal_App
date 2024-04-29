package com.palak.journalApp.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
@Data
public class JournalEntry {
	
	@Id
	private ObjectId id;
	
	private String title;
	
	private String content;
	
	private LocalDateTime date;

}
