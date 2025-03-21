package com.eventos.dto;

import com.eventos.models.Cidade;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EnderecoDTO {
    private Long id;
    private String numero;
    private String cep;
    private String rua;
    private String bairro;
    private String complemento;
    private Cidade cidade;
}
