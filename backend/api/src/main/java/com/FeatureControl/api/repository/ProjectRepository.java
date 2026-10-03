package com.FeatureControl.api.repository;

import com.FeatureControl.api.model.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {
    Project save(Project project);

    Optional<Project> findById(UUID id);

    List<Project> findByOrganisationId(UUID organisationId);
}
