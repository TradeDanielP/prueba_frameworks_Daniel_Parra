package com.riwi.riwiMultimedia.infrastructure.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.riwiMultimedia.api.dto.request.ClassRequest;
import com.riwi.riwiMultimedia.api.dto.response.ClassResponse;
import com.riwi.riwiMultimedia.api.dto.response.StudentResponse;
import com.riwi.riwiMultimedia.domain.entities.ClassEntity;
import com.riwi.riwiMultimedia.domain.entities.Student;
import com.riwi.riwiMultimedia.domain.repositories.ClassRepository;
import com.riwi.riwiMultimedia.infrastructure.abstract_services.IClassService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {
    
    @Autowired
    private final ClassRepository classRepository;

    @Override
    public ClassResponse create(ClassRequest request) {
        ClassEntity classEntity = this.requestToClass(request);
        classEntity.setStudents(new ArrayList<>());
        classEntity.setLessons(new ArrayList<>());
        return this.entityToResp(this.classRepository.save(classEntity));
    }

    @Override
    public ClassResponse disable(Integer id) {
        return null;
    }

    @Override
    public ClassResponse get(Integer id) {
        return null;
    }

    @Override
    public Page<ClassResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public ClassResponse update(ClassRequest request, Integer id) {
        return null;
    }

    private ClassResponse entityToResp(ClassEntity entity){

 /*        List<StudentResponse> students = entity.getStudents()
            .stream()
            .map(this::entityToResponseStudent)
            .collect(Collectors.toList()); */

            return ClassResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .active(entity.isActive())
                .build();
    }
/* 
    private StudentResponse entityToResponseStudent(Student entity){
        return StudentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createdAt(entity.getCreatedAt())
                .active(entity.isActive())
                .classId(entity.getClassEntity())
                .build();
    } */
    

    private ClassEntity requestToClass(ClassRequest request){
        return ClassEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .active(request.isActive())
                .createdAt(request.getCreatedAt())
                .build();
    }



}
