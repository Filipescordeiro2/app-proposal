package com.microservice.app_proposal.mapper;

import com.microservice.app_proposal.dto.PropostaRequest;
import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.entity.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target = "usuario.nome",source = "nome")
    @Mapping(target = "usuario.sobrenome",source = "sobrenome")
    @Mapping(target = "usuario.cpf",source = "cpf")
    @Mapping(target = "usuario.telefone",source = "telefone")
    @Mapping(target = "usuario.renda",source = "renda")
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "aprovada",ignore = true)
    @Mapping(target = "integrada",constant = "true")
    @Mapping(target = "observacao",ignore = true)
    Proposta convertDtoToProposta(PropostaRequest request);


    @Mapping(target = "nome",source = "usuario.nome")
    @Mapping(target = "sobrenome",source = "usuario.sobrenome")
    @Mapping(target = "telefone",source = "usuario.telefone")
    @Mapping(target = "cpf",source = "usuario.cpf")
    @Mapping(target = "renda",source = "usuario.renda")
    @Mapping(target = "valorSolicitadoFmt",expression = "java(setValorSolicitadoFmt(proposta))")
    PropostaResponse convertEntityToResponse(Proposta proposta);

    List<PropostaResponse>convertListEntityToListResponse(Iterable<Proposta> propostas);

    default String setValorSolicitadoFmt(Proposta proposta){
        return NumberFormat.getCurrencyInstance().format(proposta.getValorSolicitado());
    }
}
