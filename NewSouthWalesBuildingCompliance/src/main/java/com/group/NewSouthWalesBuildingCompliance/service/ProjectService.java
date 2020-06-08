package com.group.NewSouthWalesBuildingCompliance.service;

import com.group.NewSouthWalesBuildingCompliance.dao.ProjectDao;
import com.group.NewSouthWalesBuildingCompliance.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectService(@Qualifier("fakeProjectDao") ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public int addProject(Project project) {
        return projectDao.insertProject(project);
    }

    public List<Project> getAllProjects() {
        return projectDao.selectAllProjects();
    }

    public Optional<Project> getProjectByID(String projectID) {
        return projectDao.selectProjectByID(projectID);
    }

    public int deleteProject(String projectID) {
        return projectDao.deleteProjectByID(projectID);
    }

    public int updateProject(String projectID, Project project) {
        return projectDao.updateProjectByID(projectID, project);
    }
}
