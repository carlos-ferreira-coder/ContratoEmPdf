package com.contrato.pdf.ContratoEmPdf.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "contract_request", schema = "contract_pdf")
@Entity(name = "contract_request")
public class ContractRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "pdf_path")
    private String pdfPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id", nullable = false)
    private Signer contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractee_id", referencedColumnName = "id", nullable = false)
    private Signer contractee;

    @OneToMany(mappedBy = "contractRequest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
