package com.riwi.riwiMultimedia.api.dto.request;


import com.riwi.riwiMultimedia.util.enums.typeEnum;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaRequest {
    
    @NotBlank(message = "file type must not be null")
    @Pattern(regexp = "VIDEO|AUDIO|DOCUMENT", message = "The type must be VIDEO, AUDIO, DOCUMENT")
    private typeEnum type;

    @NotBlank(message = "url must not be null")
    private String url;

    @NotBlank(message = "active must not be null")
    @Pattern(regexp = "true|false", message = "The active must be true or false")
    private boolean active;

     @NotNull(message = "Lesson id is required")
    @Min(value = 1, message = "Lesson id must be greater than 0")
    private Integer lessonId;

}
