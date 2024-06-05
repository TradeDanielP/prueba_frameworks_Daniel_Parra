package com.riwi.riwiMultimedia.api.dto.request;



import jakarta.validation.constraints.Email;
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
public class StudentRequest {
    

    @NotBlank(message = "Student name must not be null")
    @Size(max = 255, message = "Student name cannot be longer than 255 characters")
    private String name;

    @Email(message = "The email must be a valid email (email_example@mail.com)")
    private String email;

    @NotBlank(message = "active must not be null")
    @Pattern(regexp = "true|false", message = "The active must be true or false")
    private boolean active;

    @NotNull(message = "Class id is required")
    @Min(value = 1, message = "Class id must be greater than 0")
    private int classId;

}
