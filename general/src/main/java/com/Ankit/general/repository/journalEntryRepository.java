package com.Ankit.general.repository;

import com.Ankit.general.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
