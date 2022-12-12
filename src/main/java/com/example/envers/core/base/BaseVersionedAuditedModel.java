package com.example.envers.core.base;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
public class BaseVersionedAuditedModel extends BaseVersionedModel {

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;

    /* Getters and setters */
    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

}
