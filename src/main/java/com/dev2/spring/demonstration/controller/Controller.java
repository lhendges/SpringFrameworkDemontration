package com.dev2.spring.demonstration.controller;

import com.dev2.spring.demonstration.dto.RequestDto;
import com.dev2.spring.demonstration.dto.ResponseDto;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPessoa(@RequestBody @Valid RequestDto requestDto) {
        pessoaService.registraPessoa(requestDto);
    }

    @GetMapping("/pessoas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity buscaPessoasCadastradas() {
        return ResponseEntity.ok(pessoaService.retornaPessoasCadastradas());
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<ResponseDto> buscaPessoa(@PathVariable String id) {
        return ResponseEntity.ok(pessoaService.retornaPessoasCadastradas(id));
    }

    @DeleteMapping("pessoas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluirPessoa(@PathVariable String id) {
        pessoaService.excluirPessoa(id);
    }

    @GetMapping("/exception")
    public void throwException() {
        throw new RuntimeException("TESTE");
    }

}
