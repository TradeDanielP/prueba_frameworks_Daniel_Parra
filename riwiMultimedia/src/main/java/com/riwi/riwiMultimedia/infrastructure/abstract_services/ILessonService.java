package com.riwi.riwiMultimedia.infrastructure.abstract_services;

import com.riwi.riwiMultimedia.api.dto.request.LessonRequest;
import com.riwi.riwiMultimedia.api.dto.response.LessonResponse;

public interface ILessonService extends CrudService<LessonRequest, LessonResponse, Integer>  {
    
}
