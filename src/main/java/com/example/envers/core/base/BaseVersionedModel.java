package com.example.envers.core.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseVersionedModel extends BaseModel {

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    /* Getters and setters */
    public Long getVersion() {
        return version;
    }

}
