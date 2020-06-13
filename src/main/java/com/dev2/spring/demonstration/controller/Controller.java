package com.dev2.spring.demonstration.controller;

import com.dev2.spring.demonstration.dto.RequestDto;
import com.dev2.spring.demonstration.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/hello-world")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/cadastro/pessoa")
    public ResponseEntity<String> cadastrarPessoa(@RequestBody @Valid RequestDto requestDto) {
        return ResponseEntity.ok(pessoaService.getResponse(requestDto));
    }

}
