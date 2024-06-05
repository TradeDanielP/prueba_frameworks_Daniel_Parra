package com.riwi.riwiMultimedia.api.dto.request;


import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "active must not be null")
    private boolean active;

    @NotNull(message = "date is required")
    @FutureOrPresent(message = "It is not possible to enter a date later than the current date.")
    private LocalDateTime createdAt;

}
