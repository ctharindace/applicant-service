package com.chethiya.applicant.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class ApplicantDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String nic;

    private Date dateOfBirth;

    private String gender;

    private String maritalStatus;

    private Integer noOfChildren;

    private Double weight;

    private Double height;

    private String complexion;

    private String eduQualificationGrade;

    private Set<PassportDTO> passports;


}
