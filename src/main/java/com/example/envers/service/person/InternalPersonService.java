package com.example.envers.service.person;

import com.example.envers.core.api.IdentifiableService;
import com.example.envers.model.person.InternalPerson;
import com.example.envers.transfer.person.InternalPersonDto;

import java.util.UUID;

public interface InternalPersonService extends IdentifiableService<InternalPerson, InternalPersonDto> {

    InternalPersonDto loadOne(UUID id);

}
