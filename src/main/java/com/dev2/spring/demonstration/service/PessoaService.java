package com.dev2.spring.demonstration.service;

import com.dev2.spring.demonstration.dto.RequestDto;
import com.dev2.spring.demonstration.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaMapper pessoaMapper;


    public String getResponse(RequestDto requestDto) {
        return pessoaMapper.toResponse(requestDto).toString();
    }
}
