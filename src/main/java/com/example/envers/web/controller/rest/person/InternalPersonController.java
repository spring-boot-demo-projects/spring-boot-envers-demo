package com.example.envers.web.controller.rest.person;

import com.example.envers.transfer.person.InternalPersonDto;

import java.util.UUID;

@SuppressWarnings("unused")
public interface InternalPersonController {

    InternalPersonDto getOne(UUID id);

    InternalPersonDto createOne(InternalPersonDto dto);

    InternalPersonDto updateOne(InternalPersonDto dto);

}
