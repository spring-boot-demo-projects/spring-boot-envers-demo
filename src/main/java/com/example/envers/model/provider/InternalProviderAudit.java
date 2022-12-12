package com.example.envers.model.provider;

import com.example.envers.core.base.BaseModel;
import com.example.envers.core.enumeration.InternalProviderStatus;
import org.springframework.data.history.RevisionMetadata.RevisionType;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.EnumType.STRING;

//@Entity
//@Table(name = "internal_provider_audit")
@SuppressWarnings("unused")
public class InternalProviderAudit extends BaseModel {

    @Column(name = "revision", nullable = false)
    private Long revision;
    @Enumerated(ORDINAL)
    @Column(name = "revision_type", nullable = false)
    private RevisionType revisionType;
    @Column(name = "created_by", nullable = false)
    private UUID createdBy;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    @Column(name = "last_modified_by", nullable = false)
    private UUID lastModifiedBy;
    @Column(name = "last_modified_at", nullable = false)
    private Instant lastModifiedAt;
    @Enumerated(STRING)
    @Column(name = "status", nullable = false)
    private InternalProviderStatus status;

    /* Getters and setters */
    public Long getRevision() {
        return revision;
    }

    public void setRevision(Long revision) {
        this.revision = revision;
    }

    public RevisionType getRevisionType() {
        return revisionType;
    }

    public void setRevisionType(RevisionType revisionType) {
        this.revisionType = revisionType;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UUID lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public InternalProviderStatus getStatus() {
        return status;
    }

    public void setStatus(InternalProviderStatus status) {
        this.status = status;
    }

}
