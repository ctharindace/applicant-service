package com.chethiya.applicant.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PassportDTO implements Serializable {

    private String passportNumber;

    private Date dateOfIssue;

    private Date dateOfExpiry;

    private String countryCodeOfIssue;

}
