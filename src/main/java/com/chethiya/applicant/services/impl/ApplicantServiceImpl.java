package com.chethiya.applicant.services.impl;

import com.chethiya.applicant.dto.ApplicantDTO;
import com.chethiya.applicant.services.ApplicantService;
import com.chethiya.applicant.dao.repositoryies.ApplicantRepository;
import com.chethiya.applicant.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

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

    private static ApplicantDTO getApplicantDTO(Applicant applicant) {
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
        }
        return applicantDTO;
    }

    private static Applicant getApplicant(ApplicantDTO applicantDTO) {
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
        return applicant;
    }
}
