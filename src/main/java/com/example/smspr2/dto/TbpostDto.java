package com.example.smspr2.dto;

import com.example.smspr2.domain.Tbpost;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

// 들어오는 데이터를 어떤 형태로 줄지 담당하는 테이블
public class TbpostDto {

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto{
        @Schema(description = "title", example ="")
        @NotNull
        @NotEmpty
        @Size(max=400)
        private String title;

        @Schema(description = "author", example ="")
        @NotNull
        @NotEmpty
        @Size(max=400)
        private String author;

        @Schema(description = "content", example ="")
        @Size(max=400)
        private String content;

        //Tbpost 수정 후 추가
        public Tbpost toEntity(){
            return Tbpost.of(title, author, content);
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

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateReqDto{

        @Schema(description = "id", example ="")
        @NotNull
        @NotEmpty
        private String id;

        @Schema(description = "title", example ="")
        @Size(max=400)
        private String title;

        @Schema(description = "author", example ="")
        @Size(max=400)
        private String author;

        @Schema(description = "content", example ="")
        @Size(max=400)
        private String content;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SelectReqDto{
        @Schema(description = "id", example = "")
        @NotNull
        @NotEmpty
        private String id;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SelectResDto{
        private String id;
        private String deleted;
        private String process;
        private String createdAt;
        private String modifiedAt;

        private String title;
        private String author;
        private String content;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListReqDto{
        @Schema(description = "deleted", example="")
        private String deleted;
        @Schema(description="title", example = "")
        private String title;
        @Schema(description="author", example = "")
        private String author;
    }
}
