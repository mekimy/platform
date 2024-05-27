package com.syskimy.scatalog.entities;

import com.syskimy.scatalog.entities.base.AbstractNameEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sys_product")
@Data
public class ProductEntity extends AbstractNameEntity {
    private Long price;

    @ManyToOne
    private CategoryEntity category;
}
