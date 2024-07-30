package com.example.smspr2.domain;

import com.example.smspr2.dto.TbuserDto;
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
public class Tbuser extends AuditingFields {


    @Setter @Column(nullable = false, unique = true) private String username;
    @Setter @Column(nullable = false) private String password;
    @Setter @Column(nullable = true) private String name;
    @Setter @Column(nullable = true) private String nick;
    @Setter @Column(nullable = true) private String phone;
    @Setter @Column(nullable = true) private String gender;
    @Setter @Column(nullable = true, length = 10000) @Lob private String content;
    @Setter @Column(nullable = true) private String img;


    //of로만 만들게 하기 위해 protected 로 막기
    protected Tbuser() {}
    private Tbuser(String username, String password, String name, String nick, String phone, String gender, String content, String img) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nick = nick;
        this.phone = phone;
        this.gender = gender;
        this.content = content;
        this.img = img;
    }
    public static Tbuser of(String username, String password, String name, String nick, String phone, String gender, String content, String img) {
        return new Tbuser(username, password, name, nick, phone, gender, content, img);
    }

    public TbuserDto.CreateResDto toCreateResDto() {
        return TbuserDto.CreateResDto.builder().id(this.getId()).build();
    }

}
