package com.FeatureControl.api.repository;

import com.FeatureControl.api.model.Flag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlagRepository {
    Flag save(Flag flag);

    Optional<Flag> findById(UUID id);

    List<Flag> findByProjectId(UUID projectId);

    boolean existesByProjectIdAndKey(UUID projectId, String key);


}
