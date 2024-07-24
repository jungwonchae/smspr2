package com.example.smspr2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class DefaultDto {

    @Builder
    @Schema
    @Getter
    @Setter
    public static class FileResDto{
        private String url;
    }
}
