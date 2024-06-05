package com.riwi.riwiMultimedia.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.riwiMultimedia.api.dto.request.StudentRequest;
import com.riwi.riwiMultimedia.api.dto.response.ClassResponse;
import com.riwi.riwiMultimedia.api.dto.response.StudentResponse;
import com.riwi.riwiMultimedia.domain.entities.ClassEntity;
import com.riwi.riwiMultimedia.domain.entities.Student;
import com.riwi.riwiMultimedia.domain.repositories.ClassRepository;
import com.riwi.riwiMultimedia.domain.repositories.StudentRepository;
import com.riwi.riwiMultimedia.infrastructure.abstract_services.IStudentService;
import com.riwi.riwiMultimedia.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final ClassRepository classRepository;
    
    @Override
    public StudentResponse create(StudentRequest request) {

        ClassEntity classEntity = this.classRepository.findById(request.getClassId())
                .orElseThrow(() -> new BadRequestException("There is not found any Class with this id"));

       Student student = this.requestToStudent(request);
       student.setClassEntity(classEntity);
       return this.entityToResp(this.studentRepository.save(student));
    }

    @Override
    public StudentResponse get(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public StudentResponse update(StudentRequest request, Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public StudentResponse disable(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'disable'");
    }

    @Override
    public Page<StudentResponse> getAll(int page, int size) {
        
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.studentRepository.findAll(pagination)
                .map(this::entityToResp);

    }

    private StudentResponse entityToResp(Student entity){

        ClassResponse classResponse = new ClassResponse();
            BeanUtils.copyProperties(entity.getClassEntity(), classResponse);

        return StudentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createdAt(entity.getCreatedAt())
                .active(entity.isActive())
                .classResponse(classResponse)
                .build();
    }

    private Student requestToStudent(StudentRequest request){

        ClassEntity classEntity = new ClassEntity();
            BeanUtils.copyProperties(request.getClassId(), classEntity);

        return Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .createdAt(request.getCreatedAt())
                .active(request.isActive())
                .classEntity(classEntity)
                .build();
    }

    
}
