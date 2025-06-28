package com.Ankit.general.Controller;

import com.Ankit.general.entity.JournalEntry;
import com.Ankit.general.service.journalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class MainControllerv2 {

@Autowired
private journalEntryService jes;

@GetMapping
public List<JournalEntry> getAll()
{
    List<JournalEntry> entries = jes.getAllEntry();
    System.out.println(entries);
    return entries;
}

@GetMapping("id/{myId}")
public Optional<JournalEntry> getById(@PathVariable String myId)
{
    return jes.getOne(myId);
}
@PostMapping
public void createEntry(@RequestBody JournalEntry myEntry) {
    jes.saveEntry(myEntry);

}
@DeleteMapping("id/{myId}")
public String deleteEntry(@PathVariable String myId)
{
    if(jes.deleteById(myId))
    return (myId+"   deleted Successfully !!");
    return "faild to Delete";
}

@PutMapping("/id/{id}")
public Optional<JournalEntry> updateById(@PathVariable String id , @RequestBody JournalEntry je)
{
    return jes.update(id,je);

}

}
