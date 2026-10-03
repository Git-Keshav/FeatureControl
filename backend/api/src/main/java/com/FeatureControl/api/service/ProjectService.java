package com.FeatureControl.api.service;

import com.FeatureControl.api.exception.NotFoundException;
import com.FeatureControl.api.model.Organisation;
import com.FeatureControl.api.model.Project;
import com.FeatureControl.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    private final OrganisationService organisationService;

    private final ProjectRepository projectRepository;;

    public ProjectService(OrganisationService organisationService, ProjectRepository projectRepository) {
        this.organisationService = organisationService;
        this.projectRepository = projectRepository;
    }

    public Project create(UUID organisationId, String name){
        Organisation organisation = organisationService.getById(organisationId);
        Project project = new Project(UUID.randomUUID(), organisation.getId(), name);
        return projectRepository.save(project);
    }
    public Project getById(UUID id){
        return projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project" + id + " not found"));
    }

    public List<Project> getAllForOrganisation(UUID organisationId){
        organisationService.getById(organisationId);
        return projectRepository.findByOrganisationId(organisationId);
    }
}
