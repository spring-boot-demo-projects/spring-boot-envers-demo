package com.example.envers.web.controller.rest.person.internal;

import com.example.envers.service.person.InternalPersonService;
import com.example.envers.transfer.person.InternalPersonDto;
import com.example.envers.web.controller.rest.person.InternalPersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/persons", produces = APPLICATION_JSON_VALUE)
public class InternalPersonControllerImpl implements InternalPersonController {

    private final InternalPersonService service;

    @Autowired
    public InternalPersonControllerImpl(final InternalPersonService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path = "/{id}")
    public InternalPersonDto getOne(@PathVariable final UUID id) {
        return service.loadOne(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public InternalPersonDto createOne(@Validated @RequestBody final InternalPersonDto dto) {
        return service.createOne(dto);
    }

    @Override
    @PutMapping
    public InternalPersonDto updateOne(@Validated @RequestBody final InternalPersonDto dto) {
        return service.updateOne(dto);
    }

}
