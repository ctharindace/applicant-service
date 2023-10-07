package com.chethiya.applicant.services.impl;

import com.chethiya.applicant.dto.ApplicantDTO;
import com.chethiya.applicant.dto.PassportDTO;
import com.chethiya.applicant.model.Passport;
import com.chethiya.applicant.services.ApplicantService;
import com.chethiya.applicant.dao.repositoryies.ApplicantRepository;
import com.chethiya.applicant.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private Environment environment;

    @Override
    public ApplicantDTO saveEntity(ApplicantDTO applicantDTO) {
        Applicant applicant = applicantRepository.save(getApplicant(applicantDTO));
        return getApplicantDTO(applicant);
    }

    @Override
    public ApplicantDTO getEntity(String nic) {
        Applicant applicant = applicantRepository.findByNic(nic);
        return getApplicantDTO(applicant);
    }

    @Override
    public ApplicantDTO updateEntity(ApplicantDTO applicant) {
        return saveEntity(applicant);
    }

    private ApplicantDTO getApplicantDTO(Applicant applicant) {
        ApplicantDTO applicantDTO = new ApplicantDTO();
        if (applicant != null) {
            applicantDTO.setFirstName(applicant.getFirstName());
            applicantDTO.setLastName(applicant.getLastName());
            applicantDTO.setDateOfBirth(applicant.getDateOfBirth());
            applicantDTO.setNic(applicant.getNic());
            applicantDTO.setGender(applicant.getGender());
            applicantDTO.setMaritalStatus(applicant.getMaritalStatus());
            applicantDTO.setNoOfChildren(applicant.getNoOfChildren());
            applicantDTO.setWeight(applicant.getWeight());
            applicantDTO.setHeight(applicant.getHeight());
            applicantDTO.setComplexion(applicant.getComplexion());
            applicantDTO.setEduQualificationGrade(applicant.getEduQualificationGrade());
            if (!CollectionUtils.isEmpty(applicant.getPassports())) {
                applicantDTO.setPassports(applicant.getPassports().stream().map(ApplicantServiceImpl::getPassportDTO).collect(Collectors.toSet()));
            }
            applicantDTO.setPort(environment.getProperty("local.server.port"));
        }
        return applicantDTO;
    }

    private Applicant getApplicant(ApplicantDTO applicantDTO) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDTO.getFirstName());
        applicant.setLastName(applicantDTO.getLastName());
        applicant.setDateOfBirth(applicantDTO.getDateOfBirth());
        applicant.setNic(applicantDTO.getNic());
        applicant.setGender(applicantDTO.getGender());
        applicant.setMaritalStatus(applicantDTO.getMaritalStatus());
        applicant.setNoOfChildren(applicantDTO.getNoOfChildren());
        applicant.setWeight(applicantDTO.getWeight());
        applicant.setHeight(applicantDTO.getHeight());
        applicant.setComplexion(applicantDTO.getComplexion());
        applicant.setEduQualificationGrade(applicantDTO.getEduQualificationGrade());
        if (!CollectionUtils.isEmpty(applicantDTO.getPassports())) {
            applicantDTO.getPassports().forEach(pp -> applicant.addPassport(getPassport(pp)));
        }
        return applicant;
    }

    private Passport getPassport(PassportDTO passportDTO) {
        Passport passport = new Passport();
        passport.setPassportNumber(passportDTO.getPassportNumber());
        passport.setDateOfExpiry(passportDTO.getDateOfExpiry());
        passport.setCountryCodeOfIssue(passportDTO.getCountryCodeOfIssue());
        passport.setDateOfIssue(passportDTO.getDateOfIssue());
        return passport;
    }

    private static PassportDTO getPassportDTO(Passport passport) {
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setPassportNumber(passport.getPassportNumber());
        passportDTO.setDateOfExpiry(passport.getDateOfExpiry());
        passportDTO.setCountryCodeOfIssue(passport.getCountryCodeOfIssue());
        passportDTO.setDateOfIssue(passport.getDateOfIssue());
        return passportDTO;
    }
}
