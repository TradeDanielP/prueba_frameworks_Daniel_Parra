package com.riwi.riwiMultimedia.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwiMultimedia.api.dto.request.StudentRequest;
import com.riwi.riwiMultimedia.api.dto.response.StudentResponse;
import com.riwi.riwiMultimedia.infrastructure.abstract_services.IStudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
@Tag(name = "Students")
public class StudentController {
    
    private final IStudentService service;

    @Operation(summary = "Create a Student", description = "the info need to be in JSON format")
    @PostMapping
    public ResponseEntity<StudentResponse> create(@Validated @RequestBody StudentRequest request){
        return ResponseEntity.ok(this.service.create(request));
    }

    @Operation(summary = "list a student by id", description = "the id is needed")
    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> get(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.get(id));
    }

}
