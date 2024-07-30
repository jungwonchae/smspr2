package com.example.smspr2.dto;

import com.example.smspr2.domain.Tbpostfile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

// 들어오는 데이터를 어떤 형태로 줄지 담당하는 테이블
public class TbpostfileDto {

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto{
        @Schema(description = "tbpostId", example ="")
        @NotNull
        @NotEmpty
        private String tbpostId;

        @Schema(description = "type", example ="")
        @NotNull
        @NotEmpty
        @Size(max = 100)
        private String type;

        @Schema(description = "url", example ="")
        @Size(max=400)
        private String url;

        public Tbpostfile toEntity(){
            return Tbpostfile.of(tbpostId, type, url);
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
        @Schema(description = "tbpostId", example="")
        private String tbpostId;
        @Schema(description = "type", example="")
        @Size(max=100)
        private String type;
        @Schema(description = "url", example="")
        @Size(max=400)
        private String url;
    }


    @Schema
    @Getter
    @Setter
    public static class DetailResDto extends DefaultDto.DetailResDto{
        @Schema(description = "tbpostId", example="")
        private String type;
        @Schema(description = "url", example="")
        private String url;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto{
        @Schema(description = "tbpostId", example="")
        private String tbpostId;
        @Schema(description = "type", example="")
        private String type;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto{
        @Schema(description = "tbpostId", example="")
        private String tbpostId;
        @Schema(description = "type", example="")
        private String type;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto{
        @Schema(description = "tbpostId", example="")
        private String tbpostId;
        @Schema(description = "type", example="")
        private String type;
    }

}
