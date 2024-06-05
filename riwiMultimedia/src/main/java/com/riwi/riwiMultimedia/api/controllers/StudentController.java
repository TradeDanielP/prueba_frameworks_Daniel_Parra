package com.riwi.riwiMultimedia.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Operation(summary = "list all students", description = "JSON format")
    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size) {

            return ResponseEntity.ok(this.service.getAll(page -1, size));

        }
    

}
