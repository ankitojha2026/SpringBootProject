package com.Ankit.general.Controller;

import com.Ankit.general.entity.JournalEntry;
import com.Ankit.general.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class MainControllerv2 {

@Autowired
private journalEntryService jes;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAll() {
        List<JournalEntry> entries = jes.getAllEntry();
        return entries.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(entries);
    }


    @PostMapping
public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {

    try {
        jes.saveEntry(myEntry);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable String myId) {
        try {
            ObjectId objectId = new ObjectId(myId);
            Optional<JournalEntry> entry = jes.getOne(objectId);
            return entry.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // invalid ObjectId format
        }
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<String> deleteEntry(@PathVariable String myId) {
        try {
            ObjectId objectId = new ObjectId(myId);
            if (jes.deleteById(objectId)) {
                return ResponseEntity.ok(myId + " deleted Successfully!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete. ID not found.");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid ID format", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<JournalEntry> updateById(@PathVariable String id, @RequestBody JournalEntry je) {
        try {
            ObjectId objectId = new ObjectId(id);
            Optional<JournalEntry> updated = jes.update(objectId, je);
            return updated.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
