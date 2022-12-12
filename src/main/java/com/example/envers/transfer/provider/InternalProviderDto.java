package com.example.envers.transfer.provider;

import com.example.envers.core.api.IdentifiableDto;
import com.example.envers.core.enumeration.InternalProviderStatus;
import com.example.envers.transfer.person.InternalPersonDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

public record InternalProviderDto(
        @JsonProperty("id") UUID id,
        @JsonProperty("version") Long version,
        @JsonProperty("createdBy") UUID createdBy,
        @JsonProperty("createdAt") Instant createdAt,
        @NotNull @Validated
        @JsonProperty("person") InternalPersonDto person,
        @JsonProperty("lastModifiedBy") UUID lastModifiedBy,
        @JsonProperty("lastModifiedAt") Instant lastModifiedAt,
        @NotNull
        @JsonProperty("status") InternalProviderStatus status
) implements IdentifiableDto {

    /* Builder */
    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID id;
        private Long version;
        private UUID createdBy;
        private Instant createdAt;
        private UUID lastModifiedBy;
        private Instant lastModifiedAt;
        private InternalPersonDto person;
        private InternalProviderStatus status;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder createdBy(UUID createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder person(InternalPersonDto person) {
            this.person = person;
            return this;
        }

        public Builder lastModifiedBy(UUID lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public Builder lastModifiedAt(Instant lastModifiedAt) {
            this.lastModifiedAt = lastModifiedAt;
            return this;
        }

        public Builder status(InternalProviderStatus status) {
            this.status = status;
            return this;
        }

        @NonNull
        public InternalProviderDto build() {
            return new InternalProviderDto(id, version, createdBy, createdAt, person, lastModifiedBy, lastModifiedAt, status);
        }

    }

}
