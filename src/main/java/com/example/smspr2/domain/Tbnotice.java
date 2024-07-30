package com.example.smspr2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Tbnotice extends AuditingFields{

    @Setter @Column(nullable = false, length = 400) private String title;
    @Setter @Column(nullable = false, length = 400) private String author;
    @Setter @Column(nullable = true) @Lob private String content;

    protected Tbnotice(){}
    private Tbnotice(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public static Tbnotice of(String title, String author, String content) {
        return new Tbnotice(title, author, content);
    }
}
