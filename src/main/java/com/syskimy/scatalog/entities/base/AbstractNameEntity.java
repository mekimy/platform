package com.syskimy.scatalog.entities.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractNameEntity extends AbstractBaseEntity {
    private String name;
}
