package com.chethiya.applicant.services;

public interface CommonService<DTO, ID> {

    DTO saveEntity(DTO dto);

    DTO getEntity(ID id);

    DTO updateEntity(DTO dto);

}
