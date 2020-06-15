package com.dev2.spring.demonstration.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class RequestDto {

    @NotBlank
    @Size(max = 10)
    String nome;

    String curso;

    Integer semestre;
}
