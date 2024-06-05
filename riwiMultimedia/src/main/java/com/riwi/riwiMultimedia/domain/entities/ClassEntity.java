package com.riwi.riwiMultimedia.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "class")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 800, nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private boolean active;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "classEntity",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Student> students;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "classEntity",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Lesson> lessons;

}
