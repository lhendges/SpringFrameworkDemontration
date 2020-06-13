package com.dev2.spring.demonstration.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private String nome;

    private String curso;

    private Boolean aluno;

    private Integer semestre;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("É aluno? " + aluno);
        builder.append("\n");
        builder.append("Nome da pessoa: " + nome);
        builder.append("\n");
        builder.append("Nome do curso: " + curso);
        return builder.toString();
    }
}
