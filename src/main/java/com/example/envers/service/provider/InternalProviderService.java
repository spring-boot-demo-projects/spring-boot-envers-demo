package com.example.envers.service.provider;

import com.example.envers.core.api.IdentifiableService;
import com.example.envers.model.provider.InternalProvider;
import com.example.envers.transfer.provider.InternalProviderDto;

import java.util.UUID;

public interface InternalProviderService extends IdentifiableService<InternalProvider, InternalProviderDto> {

    InternalProviderDto loadOne(UUID id);

}
