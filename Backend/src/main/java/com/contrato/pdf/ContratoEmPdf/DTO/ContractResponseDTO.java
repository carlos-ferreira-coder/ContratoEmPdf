package com.contrato.pdf.ContratoEmPdf.DTO;

import com.contrato.pdf.ContratoEmPdf.model.Contract;

import java.sql.Timestamp;
import java.util.UUID;

public record ContractResponseDTO(
        UUID id,
        Double amount,
        Timestamp startDate,
        Integer duration,
        String city,
        String uf,
        String description,
        UUID contractRequestId
) {
    public ContractResponseDTO(Contract contract) {
        this(
                contract.getId(),
                contract.getAmount(),
                contract.getStartDate(),
                contract.getDuration(),
                contract.getCity(),
                contract.getUf(),
                contract.getDescription(),
                contract.getContractRequest() != null ? contract.getContractRequest().getId() : null
        );
    }
}
