package com.example.smspr2.service.impl;

import com.example.smspr2.domain.Tbpost;
import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.mapper.TbpostMapper;
import com.example.smspr2.repository.TbpostRepository;
import com.example.smspr2.service.TbpostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbpostServiceImpl implements TbpostService {

    private TbpostRepository tbpostRepository;
    private TbpostMapper tbpostMapper;

    public TbpostServiceImpl(
            TbpostRepository tbpostRepository
            ,TbpostMapper tbpostMapper
    ) {
        this.tbpostRepository = tbpostRepository;
        this.tbpostMapper = tbpostMapper;
    }

    @Override
    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param) {
        Tbpost tbpost = tbpostRepository.save(param.toEntity());
        return tbpost.toCreateResDto();
    }

    @Override
    public TbpostDto.CreateResDto update(TbpostDto.UpdateReqDto param) {
        Tbpost tbpost = tbpostRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        if(param.getTitle() != null){
            tbpost.setTitle(param.getTitle());
        }
        if(param.getContent() != null){
            tbpost.setContent(param.getContent());
        }
        tbpostRepository.save(tbpost);
        return tbpost.toCreateResDto();
    }

    @Override
    public TbpostDto.SelectResDto detail(TbpostDto.SelectReqDto param) {

        /*
        Tbpost tbpost = tbpostRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        TbpostDto.SelectResDto selectResDto =  TbpostDto.SelectResDto.builder()
                .id(tbpost.getId())
                .createdAt(tbpost.getCreatedAt() + "")
                .deleted(tbpost.getDeleted())
                .title(tbpost.getTitle())
                .author(tbpost.getAuthor())
                .content(tbpost.getContent())
                .build();
         */
        TbpostDto.SelectResDto selectResDto = tbpostMapper.detail(param);
        if(selectResDto == null){
            throw new RuntimeException("no data");
        }
        return selectResDto;
    }

    @Override
    public List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param) {
        List<TbpostDto.SelectResDto> list = tbpostMapper.list(param);
        //리스트만 넘기는게 아니라 detail에서 상세 정보 가져오기
        List<TbpostDto.SelectResDto> newList = new ArrayList<>();
        for(TbpostDto.SelectResDto each : list){
            newList.add(detail(TbpostDto.SelectReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }

    @Override
    public TbpostDto.PagedListResDto pagedList(TbpostDto.PagedListReqDto param) {

        String orderby = param.getOrderby();
        if(orderby == null || orderby.isEmpty()){
            orderby = "created_at";
        }
        String orderway = param.getOrderway();
        if(orderway == null || orderway.isEmpty()){
            orderway = "desc";
        }
        Integer perpage = param.getPerpage();
        if(perpage == null || perpage<1){ //한번에 조회할 글 갯수
            perpage = 10;
        }
        Integer callpage = param.getCallpage();
        if(callpage == null){ //호출하는 페이지
            callpage = 1;
        }
        if(callpage < 1){
            callpage = 1;
        }

        //offset을 구하기 위해 전체 글 개수 가지고 오기
        int listsize = tbpostMapper.pagedListCount(param);
        int pagesize = listsize / perpage;
        if(listsize % perpage > 0){
            pagesize++;
        }
        if(callpage > pagesize){
            callpage = pagesize;
        }
        int offset = (callpage - 1) * perpage;

        param.setOrderby(orderby);
        param.setOrderway(orderway);
        param.setOffset(offset);
        param.setPerpage(perpage);

        List<TbpostDto.SelectResDto> list = tbpostMapper.pagedList(param);
        List<TbpostDto.SelectResDto> newList = new ArrayList<>();
        for(TbpostDto.SelectResDto each : list){
            newList.add(detail(TbpostDto.SelectReqDto.builder().id(each.getId()).build()));
        }

        TbpostDto.PagedListResDto returnVal =
                TbpostDto.PagedListResDto.builder()
                        .callpage(callpage)
                        .perpage(perpage)
                        .orderby(orderby)
                        .orderway(orderway)
                        .listsize(listsize)
                        .pagesize(pagesize)
                        .list(newList)
                        .build();

        return returnVal;
    }

    @Override
    public List<TbpostDto.SelectResDto> scrollList(TbpostDto.ScrollListReqDto param) {

        String orderby = param.getOrderby();
        if(orderby == null || orderby.isEmpty()){
            orderby = "created_at";
            param.setOrderby(orderby);
        }
        String orderway = param.getOrderway();
        if(orderway == null || orderway.isEmpty()){
            orderway = "desc";
            param.setOrderway(orderway);
        }
        Integer perpage = param.getPerpage();
        if(perpage == null || perpage<1){
            //한 번에 조회할 글 개수
            perpage = 10;
            param.setPerpage(perpage);
        }
        List<TbpostDto.SelectResDto> list = tbpostMapper.scrollList(param);
        List<TbpostDto.SelectResDto> newList = new ArrayList<>();
        for(TbpostDto.SelectResDto each : list){
            newList.add(detail(TbpostDto.SelectReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }
}
