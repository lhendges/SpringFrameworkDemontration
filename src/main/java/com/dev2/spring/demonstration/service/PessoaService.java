package com.dev2.spring.demonstration.service;

import com.dev2.spring.demonstration.domain.Pessoa;
import com.dev2.spring.demonstration.dto.RequestDto;
import com.dev2.spring.demonstration.dto.ResponseDto;
import com.dev2.spring.demonstration.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaMapper pessoaMapper;
    List<Pessoa> pessoasCadastradas = new ArrayList();

    public void registraPessoa(RequestDto requestDto) {
        Pessoa pessoa = pessoaMapper.toPessoa(requestDto);
        pessoasCadastradas.add(pessoa);
    }

    public List<Pessoa> retornaPessoasCadastradas() {
        return pessoasCadastradas;
    }

    public ResponseDto retornaPessoasCadastradas(String id) {
        Optional<Pessoa> pessoaEncontrada = pessoasCadastradas.stream().filter(pessoa -> id.equals(pessoa.getId())).findFirst();
        if (pessoaEncontrada.isPresent()) {
            return pessoaMapper.toResponse(pessoaEncontrada.get());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void excluirPessoa(String id) {
        pessoasCadastradas.removeIf(pessoa -> id.equals(pessoa.getId()));
    }

}
