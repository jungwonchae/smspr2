package com.example.smspr2.domain;

import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.dto.TbpostcmtDto;
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
public class Tbpostcmt extends AuditingFields {

    @Setter @Column(nullable = false) private String tbpostId;
    @Setter @Column(nullable = false) private String tbuserId;
    @Setter @Column(nullable = false, length = 400) private String content;

    //of로만 만들게 하기 위해 protected 로 막기
    protected Tbpostcmt() {}
    private Tbpostcmt(String tbpostId, String tbuserId, String content) {
        this.tbpostId = tbpostId;
        this.tbuserId = tbuserId;
        this.content = content;
    }

    public static Tbpostcmt of(String tbpostId, String tbuserId, String content) {
        return new Tbpostcmt(tbpostId, tbuserId, content);
    }

    public TbpostcmtDto.CreateResDto toCreateResDto() {
        return TbpostcmtDto.CreateResDto.builder().id(this.getId()).build();
    }

}