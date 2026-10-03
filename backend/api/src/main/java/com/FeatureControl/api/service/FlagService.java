package com.FeatureControl.api.service;

import com.FeatureControl.api.exception.ConflictException;
import com.FeatureControl.api.exception.NotFoundException;
import com.FeatureControl.api.model.Flag;
import com.FeatureControl.api.model.Project;
import com.FeatureControl.api.repository.FlagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlagService {
    private final ProjectService projectService;
    private final FlagRepository flagRepository;

    public FlagService(ProjectService projectService, FlagRepository flagRepository) {
        this.projectService = projectService;
        this.flagRepository = flagRepository;
    }

    public Flag create(UUID projectId, String key, String name) {
        Project project = projectService.getById(projectId);

        if(flagRepository.existesByProjectIdAndKey(projectId, key)) {
            throw new ConflictException("A flag with key: " + key + " already exists in this project");
        }

        Flag flag = new Flag(UUID.randomUUID(), project.organisationId(), project.getId(), key, project.getName(), false);
        return flagRepository.save(flag);
    }

    public Flag getById(UUID id){
        return flagRepository.findById(id).orElseThrow(() -> new NotFoundException("Flag with id: " + id + " not found"));
    }

    public List<Flag> getAllForProject(UUID flagId, boolean enabled) {
        Flag flag = getById(flagId);
        flag.setEnabled(enabled);
        return flagRepository.findByProjectId(flag.getProjectId());
    }
    public Flag setEnabled(UUID flagId, boolean enabled) {
        Flag flag = getById(flagId);
        flag.setEnabled(enabled);
        return flagRepository.save(flag);
    }
}
