package com.group.NewSouthWalesBuildingCompliance.dao;

import com.group.NewSouthWalesBuildingCompliance.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeProjectDao")
public class FakeProjectDataAccessService implements ProjectDao {

    private static List<Project> ProjectDB = new ArrayList<>();

    @Override
    public int insertProject(Project project) {
        ProjectDB.add(new Project(
                project.getProjectID(),
                project.getClientName(),
                project.getStreetAddress(),
                project.getSuburb(),
                project.getDescription(),
                project.getContractorList(),
                project.getTodoList()));
        return 1;
    }

    @Override
    public List<Project> selectAllProjects() {
        return ProjectDB;
    }

    @Override
    public Optional<Project> selectProjectByID(String projectID) {
        return ProjectDB.stream()
                .filter(project -> project.getProjectID().equals(projectID))
                .findFirst();
    }

    @Override
    public int deleteProjectByID(String projectID) {
        Optional<Project> possibleProject = selectProjectByID(projectID);
        if (possibleProject.isPresent()) {
            ProjectDB.remove(possibleProject.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateProjectByID(String projectID, Project update) {
        return selectProjectByID(projectID)
                .map(project -> {
                    int indexOfProjectToUpdate = ProjectDB.indexOf(project);
                    if (indexOfProjectToUpdate >= 0) {
                        ProjectDB.set(indexOfProjectToUpdate, new Project(projectID, update.getClientName(), update.getStreetAddress(), update.getSuburb(), update.getDescription(), update.getContractorList(), update.getTodoList()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
