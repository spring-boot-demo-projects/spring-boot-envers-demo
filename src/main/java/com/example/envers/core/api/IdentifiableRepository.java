package com.example.envers.core.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface IdentifiableRepository<M extends Identifiable> extends JpaRepository<M, UUID> {
}
