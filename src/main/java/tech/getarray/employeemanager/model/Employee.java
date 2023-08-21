package tech.getarray.employeemanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    @Column(nullable = false,updatable = false)
    private String employeeCode;

}
