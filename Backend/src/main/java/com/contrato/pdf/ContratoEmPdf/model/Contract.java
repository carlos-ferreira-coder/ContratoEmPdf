package com.contrato.pdf.ContratoEmPdf.model;

import com.contrato.pdf.ContratoEmPdf.DTO.ContractRequestDTO;
import com.contrato.pdf.ContratoEmPdf.repository.ContractRequestRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "contract", schema = "contract_pdf")
@Entity(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    private ContractRequest contractRequest;

    public Contract(ContractRequestDTO data, ContractRequestRepository requestRepository){
        this.amount = data.amount();
        this.startDate = data.startDate();
        this.duration = data.duration();
        this.city = data.city();
        this.uf = data.uf();
        this.description = data.description();
        this.contractRequest = requestRepository.findById(data.contractRequestId())
                .orElseThrow(() -> new RuntimeException("Contract Request not found"));
    }
}
