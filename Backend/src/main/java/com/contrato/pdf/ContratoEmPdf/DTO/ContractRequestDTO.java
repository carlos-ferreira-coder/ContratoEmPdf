package com.contrato.pdf.ContratoEmPdf.DTO;

import java.sql.Timestamp;
import java.util.UUID;

public record ContractRequestDTO (
        Double amount,
        Timestamp startDate,
        Integer duration,
        String city,
        String uf,
        String description,
        UUID contractRequestId
) {
}
