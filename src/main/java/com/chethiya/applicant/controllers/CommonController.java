package com.chethiya.applicant.controllers;

import com.chethiya.applicant.services.CommonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class CommonController<DTO, ID> {

    @ResponseBody
    @RequestMapping(path = "/put", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DTO add(@RequestBody DTO dto) {
        return getService().saveEntity(dto);
    }

    @ResponseBody
    @RequestMapping(path = "/get/{code}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DTO get(@PathVariable(name = "code") ID id) {
        return getService().getEntity(id);
    }

    @ResponseBody
    @RequestMapping(path = "/post", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DTO update(@RequestBody DTO dto) {
        return getService().updateEntity(dto);
    }

    abstract CommonService<DTO, ID> getService();
}
