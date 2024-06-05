package com.riwi.riwiMultimedia.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.riwiMultimedia.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Integer id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private boolean active;
    private ClassEntity classId;
    
}
