package com.projects.rbAuth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //ROLE_USER, ROLE_ADMIN, ROLE_MANAGER
}
