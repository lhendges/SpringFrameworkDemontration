package com.dev2.spring.demonstration.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class RequestDto {

    @NotBlank(message = "O nome deve ser informado!")
    @Size(max = 10, message = "O tamanho máximo do nome deve ser 10 caracteres")
    String nome;

    String curso;
}
