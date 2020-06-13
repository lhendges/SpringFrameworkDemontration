package com.dev2.spring.demonstration.mapper;

import com.dev2.spring.demonstration.dto.RequestDto;
import com.dev2.spring.demonstration.dto.ResponseDto;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class PessoaMapper {

    public ResponseDto toResponse(RequestDto requestDto) {
        return ResponseDto.builder()
                .aluno(nonNull(requestDto.getCurso()))
                .curso(requestDto.getCurso())
                .nome(requestDto.getNome())
                .build();
    }
}
