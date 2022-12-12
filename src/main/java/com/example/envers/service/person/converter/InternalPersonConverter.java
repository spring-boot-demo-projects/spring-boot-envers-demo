package com.example.envers.service.person.converter;

import com.example.envers.core.annotation.InternalConverter;
import com.example.envers.core.base.BaseIdentifiableConverter;
import com.example.envers.model.person.InternalPerson;
import com.example.envers.repository.person.InternalPersonRepository;
import com.example.envers.transfer.person.InternalPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

@InternalConverter
public class InternalPersonConverter extends BaseIdentifiableConverter<InternalPerson, InternalPersonDto> {

    private final InternalPersonRepository repository;

    @Autowired
    public InternalPersonConverter(final InternalPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public InternalPersonRepository repository() {
        return repository;
    }

    @Override
    protected InternalPersonDto convertToDto(@NonNull final InternalPerson source) {
        return InternalPersonDto.builder()
                .middleName(source.getMiddleName())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .id(source.getId())
                .build();
    }

    @Override
    protected InternalPerson convertToNewModel(InternalPersonDto source) {
        return convertToExistingModel(source, new InternalPerson());
    }

    @Override
    public InternalPerson convertToExistingModel(@NonNull final InternalPersonDto source, @NonNull final InternalPerson target) {

        target.setMiddleName(source.middleName());
        target.setFirstName(source.firstName());
        target.setLastName(source.lastName());
        target.setId(source.id());
        return target;
    }

}
