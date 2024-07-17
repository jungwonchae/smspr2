package com.example.smspr2.dto;

public class TbpostDto {


    public static class CreateReqDto{
        private String title;
        private String author;
        private String content;
    }

    public static class CreateResDto{
        private String id;
    }

    public static class SelectReqDto{
        private String id;
    }

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
}
