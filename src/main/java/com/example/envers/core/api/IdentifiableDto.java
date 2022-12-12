package com.example.envers.core.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public interface IdentifiableDto {

    UUID id();

    @JsonIgnore
    default boolean isNew() {
        return Objects.isNull(id());
    }

    @JsonIgnore
    default boolean isNotNew() {
        return !isNew();
    }

}
