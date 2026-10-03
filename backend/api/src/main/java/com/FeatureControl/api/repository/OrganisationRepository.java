package com.FeatureControl.api.repository;

import com.FeatureControl.api.model.Organisation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationRepository {
    Organisation save(Organisation organisation);

    Optional<Organisation> findById(UUID id);

    List<Organisation> findAll();
}