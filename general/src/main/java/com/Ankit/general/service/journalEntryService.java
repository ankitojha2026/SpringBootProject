package com.Ankit.general.service;

import com.Ankit.general.entity.JournalEntry;
import com.Ankit.general.repository.journalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {
@Autowired
private journalEntryRepository jer;

public void saveEntry(JournalEntry journalEntry)
{
    jer.save(journalEntry);
}


public List<JournalEntry> getAllEntry()
{
    return jer.findAll();

}

public Optional<JournalEntry> getOne(String id)
{
    return jer.findById(id);
}


public Optional<JournalEntry> update(String id , JournalEntry je)
{
    jer.save(je);
    return jer.findById(id);
}

public boolean deleteById(String id)
{
    jer.deleteById(id);
    return true;
}

}
// controller --> service --> repo