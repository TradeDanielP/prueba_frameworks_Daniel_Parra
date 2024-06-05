package com.riwi.riwiMultimedia.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    
    private int id;
    private String title;
    private List<MultimediaResponse> content;
    private LocalDateTime createdAt;
    private boolean active;

}
