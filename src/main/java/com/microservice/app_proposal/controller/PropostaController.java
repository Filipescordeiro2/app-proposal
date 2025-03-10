package com.microservice.app_proposal.controller;

import com.microservice.app_proposal.dto.PropostaRequest;
import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.service.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor
public class PropostaController {

    private final PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponse> criar(@RequestBody PropostaRequest request){
       var response = propostaService.criar(request);
        return ResponseEntity.ok(response);
    }
}
