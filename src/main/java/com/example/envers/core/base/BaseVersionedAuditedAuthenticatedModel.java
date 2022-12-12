package com.example.envers.core.base;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseVersionedAuditedAuthenticatedModel extends BaseVersionedAuditedModel {

    @CreatedBy
    @Column(name = "created_by")
    private UUID createdBy;
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private UUID lastModifiedBy;

    /* Getters and setters */
    public UUID getCreatedBy() {
        return createdBy;
    }

    public UUID getLastModifiedBy() {
        return lastModifiedBy;
    }

}
