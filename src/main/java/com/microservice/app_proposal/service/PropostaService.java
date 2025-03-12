package com.microservice.app_proposal.service;

import com.microservice.app_proposal.dto.PropostaRequest;
import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.mapper.PropostaMapper;
import com.microservice.app_proposal.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository propostaRepository;

    public PropostaResponse criar(PropostaRequest request){
        var proposta = PropostaMapper.INSTANCE.convertDtoToProposta(request);
        propostaRepository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToResponse(proposta);
    }

    public List<PropostaResponse> obterPropostaPorId() {
      return PropostaMapper.INSTANCE.convertListEntityToListResponse(propostaRepository.findAll());

    }
}
