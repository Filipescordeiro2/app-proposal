package com.microservice.app_proposal.service;

import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.entity.Proposta;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    public void notificar(Proposta proposta, String exchange){
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }

}
