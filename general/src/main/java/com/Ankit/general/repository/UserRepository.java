package com.Ankit.general.repository;

import com.Ankit.general.entity.JournalEntry;
import com.Ankit.general.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

}
