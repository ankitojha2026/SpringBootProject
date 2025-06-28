package com.Ankit.general.repository;

import com.Ankit.general.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository <JournalEntry ,String >{



}
