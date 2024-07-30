package com.example.smspr2.domain;

import com.example.smspr2.dto.TbpostfileDto;
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
public class Tbpostfile extends AuditingFields {

    @Setter @Column(nullable = false) private String tbpostId;
    @Setter @Column(nullable = false) private String type;
    @Setter @Column(nullable = false, length = 400) private String url;


    //of로만 만들게 하기 위해 protected 로 막기
    protected Tbpostfile() {}
    private Tbpostfile(String tbpostId, String type, String url) {
        this.tbpostId = tbpostId;
        this.type = type;
        this.url = url;
    }

    public static Tbpostfile of(String tbpostId, String type, String url) {
        return new Tbpostfile(tbpostId, type, url);
    }

    public TbpostfileDto.CreateResDto toCreateResDto() {
//        TbpostDto.CreateResDto createResDto1 = new TbpostDto.CreateResDto();
//        createResDto1.setId(this.getId());
        return TbpostfileDto.CreateResDto.builder().id(this.getId()).build();
    }

}