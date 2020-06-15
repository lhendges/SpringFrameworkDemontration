package com.dev2.spring.demonstration.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDefaultResponseDto {

    private String exceptionMessage;

    private String handlerMessage;
}
