package com.example.smspr2.service.impl;

import com.example.smspr2.domain.Tbpost;
import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.mapper.TbpostMapper;
import com.example.smspr2.repository.TbpostRepository;
import com.example.smspr2.service.TbpostService;
import org.springframework.stereotype.Service;

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
        TbpostDto.SelectResDto selectResDto = new tbpostMapper.detail(param);
        if(selectResDto == null){
            throw new RuntimeException("no data");
        }
        return selectResDto;
    }
}
