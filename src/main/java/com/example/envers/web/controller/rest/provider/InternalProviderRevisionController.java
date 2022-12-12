package com.example.envers.web.controller.rest.provider;

import com.example.envers.model.provider.InternalProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.history.Revision;

import java.util.UUID;

@SuppressWarnings("unused")
public interface InternalProviderRevisionController {

    Page<Revision<Long, InternalProvider>> getRevisions(UUID id);

    Revision<Long, InternalProvider> getLastChangeRevision(UUID id);

}
