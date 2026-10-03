package com.FeatureControl.api.model;

import java.util.UUID;

public class Project {
    final private UUID id;
    final private String name;
    final private UUID organisationId;

    public Project(UUID id, UUID organisationId, String name){
        this.id = id;
        this.organisationId = organisationId;
        this.name = name;
    }

    public UUID getId() {return id;}

    public UUID organisationId() {return organisationId;}

    public String getName() {return name;}
}
