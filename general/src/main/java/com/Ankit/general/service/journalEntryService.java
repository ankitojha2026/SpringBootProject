package com.Ankit.general.service;

import com.Ankit.general.entity.JournalEntry;
import com.Ankit.general.repository.journalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class journalEntryService {

    @Autowired
    private journalEntryRepository jer;

    // ✅ Save new entry with current date
    public void saveEntry(JournalEntry journalEntry) {
        try {
            journalEntry.setDate(LocalDateTime.now());
            jer.save(journalEntry);
        } catch (Exception e) {
            log.error("Exception while saving entry: ", e);
        }
    }

    public List<JournalEntry> getAllEntry() {
        try {
            return jer.findAll();
        } catch (Exception e) {
            log.error("Error fetching journal entries: ", e);
            return new ArrayList<>();
        }
    }

    // ✅ Get one by ObjectId
    public Optional<JournalEntry> getOne(ObjectId id) {
        return jer.findById(id);
    }

    // ✅ Update by ObjectId
    public Optional<JournalEntry> update(ObjectId id, JournalEntry je) {
        return jer.findById(id).map(existing -> {
            existing.setTitle(je.getTitle());
            existing.setContent(je.getContent());
            existing.setDate(LocalDateTime.now()); // optionally update date
            return jer.save(existing);
        });
    }

    // ✅ Delete by ObjectId
    public boolean deleteById(ObjectId id) {
        if (jer.existsById(id)) {
            jer.deleteById(id);
            return true;
        }
        return false;
    }
}
