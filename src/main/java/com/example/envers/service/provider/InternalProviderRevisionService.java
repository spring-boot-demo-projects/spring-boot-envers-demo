package com.example.envers.service.provider;

import com.example.envers.model.provider.InternalProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.history.Revision;

import java.util.UUID;

public interface InternalProviderRevisionService {

    Page<Revision<Long, InternalProvider>> loadRevisions(UUID id);

    Revision<Long, InternalProvider> loadLastChangeRevision(UUID id);
}
