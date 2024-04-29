package com.palak.journalApp.entity;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
public class User {

		@Id
		private ObjectId id;
		@Indexed(unique = true)
		@NonNull
		private String userName;
		@NonNull
		private String password;
}
