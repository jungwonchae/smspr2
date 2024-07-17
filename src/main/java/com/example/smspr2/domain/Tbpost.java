package com.example.smspr2.domain;

import com.example.smspr2.dto.TbpostDto;
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

    @Setter @Column(nullable = false, length = 400) private String title;
    @Setter @Column(nullable = false, length = 400) private String author;
    @Setter @Column(nullable = true, length = 10000) @Lob private String content;
    //@Lob -> Binary Large Object(BLOB), Character Large Object(CLOB) 매핑


    //of로만 만들게 하기 위해 protected 로 막기
    protected Tbpost() {}
    private Tbpost(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
    public static Tbpost of(String title, String author, String content) {
        return new Tbpost(title, author, content);
    }
    public TbpostDto.CreateResDto toCreateResDto() {
        TbpostDto.CreateResDto createResDto1 = new TbpostDto.CreateResDto();
        createResDto1.setId(this.getId());
        return TbpostDto.CreateResDto.builder().id(this.getId()).build();
    }

}
