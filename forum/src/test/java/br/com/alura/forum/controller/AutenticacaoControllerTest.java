package br.com.alura.forum.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
//@WebMvcTest // loads only mvc controller
@SpringBootTest
@AutoConfigureMockMvc // to allow inject MockMvc when not using @WebMvcTest
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

    // Mocks a MVC - like a Insomnia or Postman
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn400IfAuthenticationParamtersAreIncorrect() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"invalido@email.com\", \"senha\":\"123456\"}";
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers
                        .status()
                        .is(400)
        );
    }
}