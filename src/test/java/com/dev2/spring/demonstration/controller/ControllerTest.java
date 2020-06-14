package com.dev2.spring.demonstration.controller;

import com.dev2.spring.demonstration.SpringFrameworkDemontrationApplication;
import com.dev2.spring.demonstration.dto.ResponseDto;
import com.dev2.spring.demonstration.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringFrameworkDemontrationApplication.class})
@WebAppConfiguration
class ControllerTest {

    @Autowired
    private WebApplicationContext context;
    @MockBean
    private PessoaService pessoaService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        Mockito.when(pessoaService.retornaPessoasCadastradas(anyString()))
                .thenReturn(getResponseDtoConsulta());
    }

    @Test
    public void contextTest() {
        ServletContext servletContext = context.getServletContext();
        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(context.getBean("controller"));
    }

    @Test
    public void helloTest() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/hello-world"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Hello World"))
                .andReturn();
        assertEquals("application/json;charset=UTF-8",
                result.getResponse().getContentType());
    }

    @Test
    void buscaPessoa() throws Exception {
        this.mockMvc.perform(get("/pessoas/{id}", "bdnh566-1d6fv1sd-dv16sdfv"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Renato Portaluppi"))
                .andExpect(jsonPath("$.curso").value("Análise e Desenvolvimento de Sistemas"))
                .andExpect(jsonPath("$.semestre").value(1));
    }

    private ResponseDto getResponseDtoConsulta() {
        return ResponseDto.builder()
                .nome("Renato Portaluppi")
                .curso("Análise e Desenvolvimento de Sistemas")
                .semestre(1)
                .build();
    }

}