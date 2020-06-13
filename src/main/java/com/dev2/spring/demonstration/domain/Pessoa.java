package com.dev2.spring.demonstration.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Pessoa {

    private String id;

    @NotNull
    private String nome;
    
    private String curso;

    private Boolean aluno;

    private Integer semestre;

}
