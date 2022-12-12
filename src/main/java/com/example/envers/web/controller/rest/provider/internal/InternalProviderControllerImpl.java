package com.example.envers.web.controller.rest.provider.internal;

import com.example.envers.service.provider.InternalProviderService;
import com.example.envers.transfer.provider.InternalProviderDto;
import com.example.envers.web.controller.rest.provider.InternalProviderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/providers", produces = APPLICATION_JSON_VALUE)
public class InternalProviderControllerImpl implements InternalProviderController {

    private final InternalProviderService service;

    @Autowired
    public InternalProviderControllerImpl(final InternalProviderService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path = "/{id}")
    public InternalProviderDto getOne(@PathVariable final UUID id) {
        return service.loadOne(id);
    }

    @Override
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public InternalProviderDto createOne(@Validated @RequestBody final InternalProviderDto dto) {
        return service.createOne(dto);
    }

    @Override
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public InternalProviderDto updateOne(@Validated @RequestBody final InternalProviderDto dto) {
        return service.updateOne(dto);
    }

}
