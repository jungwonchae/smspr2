package com.example.smspr2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {

        @Id
        private String id;

        @Column(nullable = false) //테이블 컬럼에 속성을 주기 위함
        @Setter
        protected String deleted; //자식 클래스에서 사용 가능

        @Column(nullable = true)
        @Setter
        protected String process;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @CreatedDate
        @Column(nullable = false, updatable = false)
        protected LocalDateTime createdAt;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @LastModifiedDate
        @Column(nullable = false)
        protected LocalDateTime modifiedAt;

        @PrePersist
        public void onPrePersist(){
            this.id = UUID.randomUUID().toString().replaceAll("-", "");
            this.deleted = "N";
        }
}
