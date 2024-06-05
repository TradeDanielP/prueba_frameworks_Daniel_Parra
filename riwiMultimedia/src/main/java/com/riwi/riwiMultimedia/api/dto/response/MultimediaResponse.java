package com.riwi.riwiMultimedia.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.riwiMultimedia.util.enums.typeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaResponse {
    
    private Integer id;
    private typeEnum type;
    private String url;
    private LocalDateTime createdAt;
    private boolean active;
    private Integer lessonId;

}
