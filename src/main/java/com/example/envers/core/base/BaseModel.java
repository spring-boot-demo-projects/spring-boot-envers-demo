package com.example.envers.core.base;

import com.example.envers.core.api.Identifiable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Identifiable {

    @Id
    @GeneratedValue
    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(final UUID id) {
        this.id = id;
    }

}
