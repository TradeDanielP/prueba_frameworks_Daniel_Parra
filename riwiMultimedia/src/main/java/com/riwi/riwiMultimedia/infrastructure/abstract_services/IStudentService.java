package com.riwi.riwiMultimedia.infrastructure.abstract_services;

import com.riwi.riwiMultimedia.api.dto.request.StudentRequest;
import com.riwi.riwiMultimedia.api.dto.response.StudentResponse;

public interface IStudentService extends CrudService<StudentRequest, StudentResponse, Integer> {
    
}
