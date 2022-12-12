package com.example.envers.core.api;

import org.springframework.data.domain.Persistable;

import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("unused")
public interface Identifiable extends Persistable<UUID> {

    String ID = "id";

    default boolean isNew() {
        return Objects.isNull(getId());
    }

    default boolean isNotNew() {
        return !isNew();
    }

    void setId(UUID id);

}
