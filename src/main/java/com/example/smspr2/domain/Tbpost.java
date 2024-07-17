package com.example.smspr2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table
@Entity
public class Tbpost extends AuditingFields {

//    @Id private String id;
//    @Setter private String deleted;
//    @Setter private String createdAt;
//    @Setter private String modifiedAt;

    @Setter private String title;
    @Setter private String author;
    @Setter private String content;

}
