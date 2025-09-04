package com.contrato.pdf.ContratoEmPdf.repository;

import com.contrato.pdf.ContratoEmPdf.model.ContractRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractRequestRepository extends JpaRepository<ContractRequest, UUID> {

}
