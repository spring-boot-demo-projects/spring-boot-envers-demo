package com.example.envers.model.envers;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

@Entity
@RevisionEntity
@SuppressWarnings("unused")
@Table(name = "envers_revision_info")
public class EnversRevisionModel {

    @Id
    @GeneratedValue
    @RevisionNumber
    @Column(name = "revision", nullable = false)
    private Long revision;

    @RevisionTimestamp
    @Column(name = "revision_timestamp", nullable = false)
    private Long timestamp;

    /* Getters and setters */
    public Long getRevision() {
        return revision;
    }

    public void setRevision(Long rev) {
        this.revision = rev;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
