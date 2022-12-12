package com.example.envers.service.provider.internal;

import com.example.envers.repository.provider.InternalProviderRepository;
import com.example.envers.service.provider.InternalProviderService;
import com.example.envers.service.provider.converter.InternalProviderConverter;
import com.example.envers.transfer.provider.InternalProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class InternalProviderServiceImpl implements InternalProviderService {

    private final InternalProviderConverter converter;
    private final InternalProviderRepository repository;

    @Autowired
    public InternalProviderServiceImpl(final InternalProviderConverter converter,
                                       final InternalProviderRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public InternalProviderConverter converter() {
        return converter;
    }

    @Override
    public InternalProviderRepository repository() {
        return repository;
    }

    @Override
    public InternalProviderDto loadOne(final UUID id) {
        return repository().findById(id)
                .map(converter()::convert)
                .orElseThrow(() -> new EntityNotFoundException(MODEL_NOT_FOUND));
    }

}
