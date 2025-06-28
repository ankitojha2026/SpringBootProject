package com.Ankit.general.service;

import com.Ankit.general.entity.JournalEntry;
import com.Ankit.general.repository.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
