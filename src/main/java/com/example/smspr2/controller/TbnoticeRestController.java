package com.example.smspr2.controller;

import com.amazonaws.Response;
import com.example.smspr2.service.TbnoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "2-1. 공지사항 API 안내",
        description = "공지사항 관련 기능 정의한 RestController.")
@RequestMapping("/api/tbnotice")
@RestController
public class TbnoticeRestController {

    private final TbnoticeService tbnoticeService;
    public TbnoticeRestController(TbnoticeService tbnoticeService) {
        this.tbnoticeService = tbnoticeService;
    }

    @Operation(summary = "공지사항 생성",
            description = "공지사항 생성 컨트롤러 <br />"
            + "@param TbnoticeDto.CreateReqDto <br />"
            + "@return HttpStatus.CREATED(201) ResponseEntity\\<Tbpostnotice.CreateResDto\\> <br />"
            + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @PostMapping("")
    public ResponseEntity<TbnoticeDto.CreateResDto> create(@Valid @ResponseBody TbnoticeDto.CreateReqDto param){
        return ResponseEntity.status(HttpStatus.CREATED).body(tbnoticeService.create(param));
    }

}
