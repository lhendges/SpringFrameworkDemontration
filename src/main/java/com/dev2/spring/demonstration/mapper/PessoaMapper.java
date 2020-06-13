package com.dev2.spring.demonstration.mapper;

import com.dev2.spring.demonstration.domain.Pessoa;
import com.dev2.spring.demonstration.dto.RequestDto;
import com.dev2.spring.demonstration.dto.ResponseDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Objects.nonNull;

@Component
public class PessoaMapper {

    public Pessoa toPessoa(RequestDto requestDto) {
        return Pessoa.builder()
                .aluno(nonNull(requestDto.getCurso()))
                .semestre(requestDto.getSemestre())
                .id(UUID.randomUUID().toString())
                .curso(requestDto.getCurso())
                .nome(requestDto.getNome())
                .build();
    }

    public ResponseDto toResponse(Pessoa pessoa) {
        return ResponseDto.builder()
                .aluno(nonNull(pessoa.getCurso()))
                .semestre(pessoa.getSemestre())
                .curso(pessoa.getCurso())
                .nome(pessoa.getNome())
                .build();
    }

}
