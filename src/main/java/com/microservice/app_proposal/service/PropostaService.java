package com.microservice.app_proposal.service;

import com.microservice.app_proposal.dto.PropostaRequest;
import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository propostaRepository;

    public PropostaResponse criar(PropostaRequest request){

        return null;
    }
}
