package com.microservice.app_proposal.controller;

import com.microservice.app_proposal.dto.PropostaRequest;
import com.microservice.app_proposal.dto.PropostaResponse;
import com.microservice.app_proposal.service.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor
public class PropostaController {

    private final PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponse> criar(@RequestBody PropostaRequest request){
       var response = propostaService.criar(request);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponse>>obterPropostaPorId(){
        return ResponseEntity.ok(propostaService.obterPropostaPorId());
    }
}
