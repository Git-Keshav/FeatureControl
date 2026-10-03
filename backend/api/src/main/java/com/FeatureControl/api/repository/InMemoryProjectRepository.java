package com.FeatureControl.api.repository;

import com.FeatureControl.api.model.Project;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProjectRepository implements ProjectRepository{
    private final Map<UUID, Project> store = new ConcurrentHashMap<>();

    @Override
    public Project save(Project project) {
        store.put(project.getId(), project);
        return project;
    }

    @Override
    public Optional<Project> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Project> findByOrganisationId(UUID organisationId) {
        return store.values().stream().filter((Project project) -> project.organisationId().equals(organisationId)).toList();
    }
}
