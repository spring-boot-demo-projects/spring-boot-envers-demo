package com.example.envers.service.person.internal;

import com.example.envers.repository.person.InternalPersonRepository;
import com.example.envers.service.person.InternalPersonService;
import com.example.envers.service.person.converter.InternalPersonConverter;
import com.example.envers.transfer.person.InternalPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class InternalPersonServiceImpl implements InternalPersonService {

    private final InternalPersonConverter converter;
    private final InternalPersonRepository repository;

    @Autowired
    public InternalPersonServiceImpl(final InternalPersonConverter converter,
                                     final InternalPersonRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public InternalPersonConverter converter() {
        return converter;
    }

    @Override
    public InternalPersonRepository repository() {
        return repository;
    }

    @Override
    public InternalPersonDto loadOne(final UUID id) {
        return repository().findById(id)
                .map(converter()::convert)
                .orElseThrow(() -> new EntityNotFoundException(MODEL_NOT_FOUND));
    }

}
