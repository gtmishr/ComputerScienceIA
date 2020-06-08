package com.group.NewSouthWalesBuildingCompliance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Project {

    // Private for encapsulation
    private final String projectID;
    private final String clientName;
    private final String streetAddress;
    private final String suburb;
    private final String description;
    private List<Contractor> contractorList;
    private final String todoList;

    // All of the attributes appropriate for any given building project

    public Project(@JsonProperty("projectID") String projectID,
                   @JsonProperty("clientName") String clientName,
                   @JsonProperty("streetAddress") String streetAddress,
                   @JsonProperty("suburb") String suburb,
                   @JsonProperty("description") String description,
                   @JsonProperty("contractorList") List<Contractor> contractorList,
                   @JsonProperty("todoList") String todoList) {

        this.projectID = projectID;
        this.clientName = clientName;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.description = description;
        this.contractorList = contractorList;
        this.todoList = todoList;
    }

    public String getProjectID() {
        return projectID;
    }
    public String getClientName() {
        return clientName;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getSuburb() {
        return suburb;
    }
    public String getDescription() {
        return description;
    }
    public List<Contractor> getContractorList() {
        return contractorList;
    }
    public String getTodoList() {
        return todoList;
    }
}
