package com.contrato.pdf.ContratoEmPdf.controller;

import com.contrato.pdf.ContratoEmPdf.model.Contract;
import com.contrato.pdf.ContratoEmPdf.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractRepository repository;

    @GetMapping
    public List<Contract> getAll() {
        List<Contract> contractList = repository.findAll();
        return contractList;
    }

}
