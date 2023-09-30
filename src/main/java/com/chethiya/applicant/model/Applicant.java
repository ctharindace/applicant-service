package com.chethiya.applicant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "APP_T_APPLICANT")
public class Applicant {

    @Id
    @Column(name = "APPLICANT_ID")
    @GeneratedValue(generator = "APP_S_APPLICANT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "APP_S_APPLICANT", sequenceName = "APP_S_APPLICANT", allocationSize = 1)
    private int applicantId;

    @Column(name = "NIC", unique = true)
    private String nic;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name="GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "NO_OF_CHILDREN")
    private Integer noOfChildren;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "HEIGHT")
    private Double height;

    @Column(name = "COMPLEXION")
    private String complexion;

    @Column(name = "EDU_QUALIFICATION_GRADE")
    private String eduQualificationGrade;

}
