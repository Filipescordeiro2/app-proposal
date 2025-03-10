package com.microservice.app_proposal.repository;

import com.microservice.app_proposal.entity.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {
}
