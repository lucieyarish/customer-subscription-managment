package com.demo.customersubscriptionmanagement.demo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "subscription")
@Entity
@Data
public class Subscription {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "started_on", nullable = false)
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date startDate;

    @Column(name = "valid_to", nullable = false)
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date validUntil;

    @OneToOne
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;
}
