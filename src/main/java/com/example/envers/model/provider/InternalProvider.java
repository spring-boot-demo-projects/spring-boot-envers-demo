package com.example.envers.model.provider;

import com.example.envers.core.base.BaseVersionedAuditedAuthenticatedModel;
import com.example.envers.core.base.BaseVersionedAuditedModel;
import com.example.envers.core.enumeration.InternalProviderStatus;
import com.example.envers.model.person.InternalPerson;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@AuditTable("internal_provider_audit")
@AuditOverride(name = "lastModifiedAt", forClass = BaseVersionedAuditedModel.class)
@AuditOverride(name = "lastModifiedBy", forClass = BaseVersionedAuditedAuthenticatedModel.class)
@Table(name = "internal_provider", indexes = {@Index(name = "internal_provider_status_index", columnList = "status")})
public class InternalProvider extends BaseVersionedAuditedAuthenticatedModel {

    @ManyToOne(optional = false, cascade = {PERSIST, MERGE})
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private InternalPerson person;
    @Audited
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InternalProviderStatus status;

    /* Getters and setters */
    public InternalPerson getPerson() {
        return person;
    }

    public void setPerson(InternalPerson person) {
        this.person = person;
    }

    public InternalProviderStatus getStatus() {
        return status;
    }

    public void setStatus(InternalProviderStatus status) {
        this.status = status;
    }

}
