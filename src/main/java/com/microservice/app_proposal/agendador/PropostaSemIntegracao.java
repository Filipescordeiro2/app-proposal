package com.microservice.app_proposal.agendador;

import com.microservice.app_proposal.entity.Proposta;
import com.microservice.app_proposal.repository.PropostaRepository;
import com.microservice.app_proposal.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class PropostaSemIntegracao {

    private final PropostaRepository propostaRepository;

    private final NotificationService notificationService;

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    @Scheduled(fixedRate = 10,timeUnit = TimeUnit.SECONDS)
    public void buscarPropostasSemIntegracao() {
        propostaRepository.findAllByIntegradaIsFalse().forEach(proposta -> {
            try {
                notificationService.notificar(proposta, exchange);
                atualizarProposta(proposta);
            }catch (RuntimeException e){
                log.error("Erro ao notificar proposta: {} pelo erro: {}", proposta.getId(), e.getMessage());
            }
        });
    }

    private void atualizarProposta(Proposta proposta){
        proposta.setIntegrada(true);
        propostaRepository.save(proposta);
        log.info("Proposta: {} notificada com sucesso", proposta.getId());
    }

}
