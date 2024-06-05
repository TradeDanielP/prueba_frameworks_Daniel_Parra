package com.riwi.riwiMultimedia.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwiMultimedia.api.dto.request.ClassRequest;
import com.riwi.riwiMultimedia.api.dto.response.ClassResponse;
import com.riwi.riwiMultimedia.infrastructure.abstract_services.IClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
@Tag(name = "Classes")
public class ClassController {
    private final IClassService service;

    @Operation(summary = "Create a class", description = "the info need to be in JSON format")
    @PostMapping
    public ResponseEntity<ClassResponse> create(@Validated @RequestBody ClassRequest request){
        return ResponseEntity.ok(this.service.create(request));
    }

}
