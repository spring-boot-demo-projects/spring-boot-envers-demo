package com.example.envers.web.controller.rest.provider.internal;

import com.example.envers.model.provider.InternalProvider;
import com.example.envers.service.provider.InternalProviderRevisionService;
import com.example.envers.web.controller.rest.provider.InternalProviderRevisionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/provider-revisions", produces = APPLICATION_JSON_VALUE)
public class InternalProviderRevisionControllerImpl implements InternalProviderRevisionController {

    private final InternalProviderRevisionService revisionService;

    @Autowired
    public InternalProviderRevisionControllerImpl(final InternalProviderRevisionService revisionService) {
        this.revisionService = revisionService;
    }

    @Override
    @GetMapping("/{id}")
    public Page<Revision<Long, InternalProvider>> getRevisions(@PathVariable final UUID id) {
        return revisionService.loadRevisions(id);
    }

    @Override
    @GetMapping("/{id}/last-change-revision")
    public Revision<Long, InternalProvider> getLastChangeRevision(@PathVariable final UUID id) {
        return revisionService.loadLastChangeRevision(id);
    }

}
