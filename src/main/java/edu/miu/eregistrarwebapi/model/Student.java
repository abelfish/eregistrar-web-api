package edu.miu.eregistrarwebapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotNull(message = "Please provide student number")
    @NotBlank(message = "Please provide student number")
    private String studentNumber;

    @NotNull(message = "Please provide first name")
    @NotBlank(message = "Please provide first name")
    private String firstName;

    private String middleName;

    @NotNull(message = "Please provide last name")
    @NotBlank(message = "Please provide last name")
    private String lastName;

    private Double cgpa;

    @NotNull(message = "Please provide enrollment date")
    private String enrollmentDate;

    @NotNull(message = "Please provide isInternational")
    private Boolean isInternational;

}
