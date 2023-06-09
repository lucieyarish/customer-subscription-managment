package com.demo.customersubscriptionmanagement.demo.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "quotation")
@Entity
@Data
public class Quotation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "insurance_began_on", nullable = false)
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date beginningOfInsurance;

    @Column(name = "insured_amount", nullable = false)
    private BigDecimal insuredAmount;

    @Column(name = "mortgage_signed_on", nullable = false)
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date dateOfSigningMortgage;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "quotation", cascade = CascadeType.REMOVE)
    private Subscription subscription;
}
