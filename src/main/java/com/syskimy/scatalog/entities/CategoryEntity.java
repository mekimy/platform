package com.syskimy.scatalog.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sys_category")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
