package com.example.smspr2.dto;

import com.example.smspr2.domain.Tbpostcmt;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

// 들어오는 데이터를 어떤 형태로 줄지 담당하는 테이블
public class TbpostcmtDto {

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto{
        @Schema(description = "tbuserId", example ="")
        @NotNull
        @NotEmpty
        private String tbuserId;

        @Schema(description = "title", example ="")
        @NotNull
        @NotEmpty
        @Size(max = 400)
        private String title;

        @Schema(description = "content", example ="")
        @Size(max=4000)
        private String content;

        @Schema(description = "tbpostfileTypes", example = "")
        private List<String> tbpostfileTypes;

        @Schema(description = "tbpostfileUrls", example = "")
        private List<String> tbpostfileUrls;

        public Tbpostcmt toEntity(){
            return Tbpostcmt.of(tbuserId, title, content);
        }

    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateResDto{
        private String id;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto{
        @Schema(description = "tbuserId", example="")
        private String tbuserId;
        @Schema(description = "title", example="")
        @Size(max=400)
        private String title;
        @Schema(description = "content", example="")
        @Size(max=4000)
        private String content;
    }


    @Schema
    @Getter
    @Setter
    public static class DetailResDto extends DefaultDto.DetailResDto{
        @Schema(description = "tbuserId", example="")
        private String tbuserId;
        @Schema(description = "title", example="")
        private String title;
        @Schema(description = "content", example="")
        private String content;

        @Schema(description = "tbuserName", example="")
        private String tbuserName;
        @Schema(description = "tbuserNick", example="")
        private String tbuserNick;
        @Schema(description = "tbuserImg", example="")
        private String tbuserImg;

        @Schema(description = "tbpostfiles", example="")
        private List<TbpostfileDto.DetailResDto> tbpostfiles;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto{
        @Schema(description = "tbuserId", example="")
        private String tbuserId;
        @Schema(description = "title", example="")
        private String title;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto{
        @Schema(description = "tbuserId", example="")
        private String tbuserId;
        @Schema(description = "title", example="")
        private String title;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto{
        @Schema(description = "tbuserId", example="")
        private String tbuserId;
        @Schema(description = "title", example="")
        private String title;
    }

}
