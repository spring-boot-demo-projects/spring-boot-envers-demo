package com.example.envers.transfer.person;

import com.example.envers.core.api.IdentifiableDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record InternalPersonDto(
        @JsonProperty("id") UUID id,
        @Min(3) @NotBlank
        @JsonProperty("lastName") String lastName,
        @Min(3) @NotBlank
        @JsonProperty("firstName") String firstName,
        @Min(3) @NotBlank
        @JsonProperty("middleName") String middleName
) implements IdentifiableDto {

    /* Builder */
    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private UUID id;
        private String lastName;
        private String firstName;
        private String middleName;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        @NonNull
        public InternalPersonDto build() {
            return new InternalPersonDto(id, lastName, firstName, middleName);
        }

    }

}
