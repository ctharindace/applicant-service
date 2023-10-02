package com.chethiya.applicant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "APPLICANT_T_PASSPORT")
public class Passport {

    @Id
    @Column(name = "PASSPORT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICANT_S_PASSPORT")
    @SequenceGenerator(name = "APPLICANT_S_PASSPORT", sequenceName = "APPLICANT_S_PASSPORT", allocationSize = 1)
    private Integer passportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "APPLICANT_ID")
    private Applicant applicant;

    @Column(name = "PASSPORT_NO")
    private String passportNumber;

    @Column(name = "DATE_OF_ISSUE")
    private Date dateOfIssue;

    @Column(name = "DATE_OF_EXPIRY")
    private Date dateOfExpiry;

    @Column(name = "COUNTRY_CODE")
    private String countryCodeOfIssue;

}
