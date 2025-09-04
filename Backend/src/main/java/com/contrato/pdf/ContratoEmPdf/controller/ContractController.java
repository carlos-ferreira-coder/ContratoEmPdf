package com.contrato.pdf.ContratoEmPdf.controller;

import com.contrato.pdf.ContratoEmPdf.DTO.ContractRequestDTO;
import com.contrato.pdf.ContratoEmPdf.DTO.ContractResponseDTO;
import com.contrato.pdf.ContratoEmPdf.model.Contract;
import com.contrato.pdf.ContratoEmPdf.repository.ContractRepository;
import com.contrato.pdf.ContratoEmPdf.repository.ContractRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractRequestRepository contractRequestRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ContractResponseDTO> getAll() {

        List<ContractResponseDTO> contractList = contractRepository.findAll().stream().map(ContractResponseDTO::new).collect(Collectors.toList());;

        return contractList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveContract(@RequestBody ContractRequestDTO data) {
        Contract contractData = new Contract(data, contractRequestRepository);

        contractRepository.save(contractData);

        return;
    }

}
