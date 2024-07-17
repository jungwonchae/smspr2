package com.example.smspr2.service.impl;

import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.repository.TbpostRepository;
import com.example.smspr2.service.TbpostService;
import org.springframework.stereotype.Service;

@Service
public class TbpostServiceImpl implements TbpostService {

    private TbpostRepository tbpostRepository;
    public TbpostServiceImpl(TbpostRepository tbpostRepository) {
        this.tbpostRepository = tbpostRepository;
    }

    @Override
    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param) {

        return null;
    }

    @Override
    public TbpostDto.CreateResDto update(TbpostDto.UpdateReqDto param) {
        return null;
    }

    @Override
    public TbpostDto.SelectResDto detail(TbpostDto.SelectReqDto param) {
        return null;
    }
}
