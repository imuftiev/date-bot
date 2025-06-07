package com.project.princeps.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "info")
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "username", length = 50)
    private String username;

}