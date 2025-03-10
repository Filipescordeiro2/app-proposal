package com.microservice.app_proposal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropostaResponse {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Double renda;
    private Double valorSolicitado;
    private int prazoPagament;
    private Boolean aprovado;
    private String observacao;
}
