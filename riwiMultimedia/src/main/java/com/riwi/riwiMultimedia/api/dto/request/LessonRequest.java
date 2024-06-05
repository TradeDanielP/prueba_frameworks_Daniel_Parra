package com.riwi.riwiMultimedia.api.dto.request;


import java.util.List;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {

    @NotBlank(message = "Lesson title must not be null")
    @Size(max = 255, message = "Lesson title cannot be longer than 255 characters")
    private String title;

    @NotBlank(message = "Lesson content must not be null")
    private List<MultimediaRequest> content;

    @NotBlank(message = "active must not be null")
    @Pattern(regexp = "true|false", message = "The active must be true or false")
    private boolean active;

    @NotNull(message = "Class id is required")
    @Min(value = 1, message = "Class id must be greater than 0")
    private int classId;
}
