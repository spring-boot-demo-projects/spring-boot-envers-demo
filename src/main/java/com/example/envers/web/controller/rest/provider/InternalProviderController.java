package com.example.envers.web.controller.rest.provider;

import com.example.envers.transfer.provider.InternalProviderDto;

import java.util.UUID;

@SuppressWarnings("unused")
public interface InternalProviderController {

    InternalProviderDto getOne(UUID id);

    InternalProviderDto createOne(InternalProviderDto dto);

    InternalProviderDto updateOne(InternalProviderDto dto);

}
