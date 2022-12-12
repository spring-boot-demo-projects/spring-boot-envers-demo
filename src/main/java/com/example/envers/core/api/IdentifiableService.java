package com.example.envers.core.api;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

/**
 * @param <M> model
 * @param <D> data transfer object
 */
public interface IdentifiableService<M extends Identifiable, D extends IdentifiableDto> {

    String MODEL_NOT_FOUND = "Model not found";
    String MODEL_ID_MUST_BE_NULL = "Model id must be null";
    String MODEL_ID_MUST_NOT_BE_NULL = "Model id must not be null";

    IdentifiableConverter<M, D> converter();

    IdentifiableRepository<M> repository();

    @Transactional
    default D createOne(@NonNull final D dto) {
        if (dto.isNotNew()) {
            throw new IllegalArgumentException(MODEL_ID_MUST_BE_NULL);
        }
        return converter().convert(repository().save(converter().convert(dto)));
    }

    default D updateOne(@NonNull final D dto) {
        if (dto.isNew()) {
            throw new IllegalArgumentException(MODEL_ID_MUST_NOT_BE_NULL);
        }
        return converter().convert(repository().save(converter().convert(dto)));
    }

}
