package com.contrato.pdf.ContratoEmPdf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "signer", schema = "contract_pdf")
@Entity(name = "signer")
public class Signer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf_cnpj", nullable = false)
    private String cpfCnpj;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
    private List<ContractRequest> contractors;

    @OneToMany(mappedBy = "contractee", fetch = FetchType.LAZY)
    private List<ContractRequest> contractees;
}
