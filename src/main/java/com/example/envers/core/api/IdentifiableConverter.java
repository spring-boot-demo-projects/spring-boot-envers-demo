package com.example.envers.core.api;

public interface IdentifiableConverter<M extends Identifiable, D extends IdentifiableDto> {

    D convert(M source);

    M convert(D source);

    IdentifiableRepository<M> repository();

}
