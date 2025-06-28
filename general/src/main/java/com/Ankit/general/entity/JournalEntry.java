package com.Ankit.general.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.jsr310.LocalDateCodec;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Document(collection = "journalEntry")
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;

    private LocalDateTime date;
}