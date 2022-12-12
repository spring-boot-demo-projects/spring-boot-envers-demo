package com.example.envers.service.provider.converter;

import com.example.envers.core.annotation.InternalConverter;
import com.example.envers.core.base.BaseIdentifiableConverter;
import com.example.envers.model.provider.InternalProvider;
import com.example.envers.repository.provider.InternalProviderRepository;
import com.example.envers.service.person.converter.InternalPersonConverter;
import com.example.envers.transfer.provider.InternalProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

@InternalConverter
public class InternalProviderConverter extends BaseIdentifiableConverter<InternalProvider, InternalProviderDto> {

    private final InternalProviderRepository repository;
    private final InternalPersonConverter personConverter;

    @Autowired
    public InternalProviderConverter(final InternalProviderRepository repository,
                                     final InternalPersonConverter personConverter) {
        this.repository = repository;
        this.personConverter = personConverter;
    }

    @Override
    public InternalProviderRepository repository() {
        return repository;
    }

    @Override
    public InternalProviderDto convertToDto(@NonNull final InternalProvider source) {
        return InternalProviderDto.builder()
                .person(personConverter.convert(source.getPerson()))
                .lastModifiedAt(source.getLastModifiedAt())
                .lastModifiedBy(source.getLastModifiedBy())
                .createdAt(source.getCreatedAt())
                .createdBy(source.getCreatedBy())
                .version(source.getVersion())
                .status(source.getStatus())
                .id(source.getId())
                .build();
    }

    @Override
    protected InternalProvider convertToNewModel(InternalProviderDto source) {
        return convertToExistingModel(source, new InternalProvider());
    }

    @Override
    public InternalProvider convertToExistingModel(@NonNull final InternalProviderDto source, @NonNull final InternalProvider target) {
        target.setPerson(personConverter.convert(source.person()));
        target.setStatus(source.status());
        return target;
    }

}
