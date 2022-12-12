package com.example.envers.core.base;

import com.example.envers.core.api.Identifiable;
import com.example.envers.core.api.IdentifiableConverter;
import com.example.envers.core.api.IdentifiableDto;

import javax.persistence.EntityNotFoundException;

import static com.example.envers.core.api.IdentifiableService.MODEL_NOT_FOUND;

public abstract class BaseIdentifiableConverter<M extends Identifiable, D extends IdentifiableDto> implements IdentifiableConverter<M, D> {

    @Override
    public D convert(final M source) {
        if (source == null) {
            return null;
        }
        return convertToDto(source);
    }

    @Override
    public M convert(final D source) {
        if (source == null) {
            return null;
        }
        if (source.isNew()) {
            return convertToNewModel(source);
        }
        final M target = repository().findById(source.id())
                .orElseThrow(() -> new EntityNotFoundException(MODEL_NOT_FOUND));
        return convertToExistingModel(source, target);
    }

    protected abstract D convertToDto(M source);

    protected abstract M convertToNewModel(D source);

    protected abstract M convertToExistingModel(D source, M target);

}
