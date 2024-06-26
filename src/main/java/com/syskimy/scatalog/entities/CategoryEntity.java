package com.syskimy.scatalog.entities;

import com.syskimy.scatalog.entities.base.AbstractBaseEntity;
import com.syskimy.scatalog.entities.base.AbstractNameEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sys_category")
@Data
public class CategoryEntity extends AbstractNameEntity {
}
