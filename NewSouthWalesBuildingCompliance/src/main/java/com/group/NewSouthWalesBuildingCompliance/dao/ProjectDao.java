package com.group.NewSouthWalesBuildingCompliance.dao;

import com.group.NewSouthWalesBuildingCompliance.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {

    int insertProject(Project project);

    List<Project> selectAllProjects();

    Optional<Project> selectProjectByID(String projectID);

    int deleteProjectByID(String projectID);

    int updateProjectByID(String projectID, Project project);
}

