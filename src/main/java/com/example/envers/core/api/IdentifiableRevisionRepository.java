package com.example.envers.core.api;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.UUID;

@NoRepositoryBean
public interface IdentifiableRevisionRepository<M extends Identifiable>
        extends IdentifiableRepository<M>, RevisionRepository<M, UUID, Long> {
}
