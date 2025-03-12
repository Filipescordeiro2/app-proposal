package com.microservice.app_proposal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_proposta")
@NoArgsConstructor
@AllArgsConstructor
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference
    private Usuario usuario;
}
