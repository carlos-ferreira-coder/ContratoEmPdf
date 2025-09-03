package com.contrato.pdf.ContratoEmPdf.repository;

import com.contrato.pdf.ContratoEmPdf.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
