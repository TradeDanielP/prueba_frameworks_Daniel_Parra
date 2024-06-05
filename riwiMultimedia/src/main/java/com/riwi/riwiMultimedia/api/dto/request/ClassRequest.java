package com.riwi.riwiMultimedia.api.dto.request;


import jakarta.validation.constraints.NotBlank;
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
public class ClassRequest {
    
    @NotBlank(message = "Class name must not be null")
    @Size(max = 255, message = "Class name cannot be longer than 255 characters")
    private String name;

    @NotBlank(message = "Class description must not be null")
    @Size(min = 20, max = 800, message = "description must be greater than 20 characters and lower than 800 characters")
    private String description;

    @NotBlank(message = "active must not be null")
    @Pattern(regexp = "true|false", message = "The active must be true or false")
    private boolean active;

}
