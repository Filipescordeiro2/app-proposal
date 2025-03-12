package com.microservice.app_proposal.service;

import com.microservice.app_proposal.dto.PropostaRequest;
import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.entity.Proposta;
import com.microservice.app_proposal.mapper.PropostaMapper;
import com.microservice.app_proposal.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final NotificationService notificationService;

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    public PropostaResponse criar(PropostaRequest request){
        var proposta = PropostaMapper.INSTANCE.convertDtoToProposta(request);
        propostaRepository.save(proposta);

        notificarRabbitMQ(proposta);

        return  PropostaMapper.INSTANCE.convertEntityToResponse(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta) {
        try {
            notificationService.notificar(proposta, exchange);
        } catch (RuntimeException e) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponse> obterPropostaPorId() {
      return PropostaMapper.INSTANCE.convertListEntityToListResponse(propostaRepository.findAll());

    }
}
