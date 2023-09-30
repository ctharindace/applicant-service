package com.chethiya.applicant.controllers;

import com.chethiya.applicant.dto.ApplicantDTO;
import com.chethiya.applicant.services.ApplicantService;
import com.chethiya.applicant.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("applicant")
public class ApplicantController extends CommonController<ApplicantDTO, String> {

    @Autowired
    private ApplicantService applicantService;

    @Override
    CommonService<ApplicantDTO, String> getService() {
        return this.applicantService;
    }
}
