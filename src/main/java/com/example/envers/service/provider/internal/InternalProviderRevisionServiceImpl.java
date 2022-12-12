package com.example.envers.service.provider.internal;

import com.example.envers.model.provider.InternalProvider;
import com.example.envers.repository.provider.InternalProvoderRevisionRepository;
import com.example.envers.service.provider.InternalProviderRevisionService;
import com.example.envers.service.provider.converter.InternalProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class InternalProviderRevisionServiceImpl implements InternalProviderRevisionService {

    private final InternalProviderConverter converter;
    private final InternalProvoderRevisionRepository revisionRepository;

    @Autowired
    public InternalProviderRevisionServiceImpl(final InternalProviderConverter converter,
                                               final InternalProvoderRevisionRepository revisionRepository) {
        this.converter = converter;
        this.revisionRepository = revisionRepository;
    }

    @Override
    public Page<Revision<Long, InternalProvider>> loadRevisions(final UUID id) {
        return revisionRepository.findRevisions(id, PageRequest.of(0, 50));
    }

    @Override
    public Revision<Long, InternalProvider> loadLastChangeRevision(final UUID id) {
        return revisionRepository.findLastChangeRevision(id)
                .orElse(null);
    }

}
