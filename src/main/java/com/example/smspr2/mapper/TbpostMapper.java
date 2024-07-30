package com.example.smspr2.mapper;

import com.example.smspr2.dto.DefaultDto;
import com.example.smspr2.dto.TbpostDto;
import java.util.List;

public interface TbpostMapper {
    TbpostDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<TbpostDto.DetailResDto> list(TbpostDto.ListReqDto param);

    List<TbpostDto.DetailResDto> scrollList(TbpostDto.ScrollListReqDto param);
    List<TbpostDto.DetailResDto> pagedList(TbpostDto.PagedListReqDto param);
    int pagedListCount(TbpostDto.PagedListReqDto param);
}