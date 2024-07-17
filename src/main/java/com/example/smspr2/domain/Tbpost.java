package com.example.smspr2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table(indexes = { //table annotation 에 대한 상세한 내용
        @Index(columnList = "deleted")
        ,@Index(columnList = "process")
        ,@Index(columnList = "createdAt")
        ,@Index(columnList = "modifiedAt")
}) //인덱스 키가 유니크 키(여러개를 한번에 설정할때) 등을 설정할 수 있음
@Entity
public class Tbpost extends AuditingFields {

//    @Id private String id;
//    @Setter private String deleted;
//    @Setter private String createdAt;
//    @Setter private String modifiedAt;

    @Setter @Column private String title;
    @Setter @Column private String author;
    @Setter @Column private String content;

}
