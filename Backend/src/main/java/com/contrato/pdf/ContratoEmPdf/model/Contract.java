package com.contrato.pdf.ContratoEmPdf.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "contracts")
@Entity(name = "contracts")
public class Contract {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Timestamp startDate;
    private Timestamp duration;
    private String city;
    private String description;

}
