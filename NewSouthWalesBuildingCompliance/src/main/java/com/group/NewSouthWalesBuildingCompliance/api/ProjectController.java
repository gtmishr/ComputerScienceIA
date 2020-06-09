package com.group.NewSouthWalesBuildingCompliance.api;

import com.group.NewSouthWalesBuildingCompliance.model.Project;
import com.group.NewSouthWalesBuildingCompliance.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequestMapping("api/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // WRITING TO BE FIXED
    @PostMapping
    public void addProject(@NonNull @RequestBody Project project) {
        projectService.addProject(project);

        try {

            FileWriter fileWriter = new FileWriter("data.json");
            PrintWriter printWriter = new PrintWriter("data.json");
            printWriter.print("{projectID: project.getProjectID(), clientName: project.getClientName(), streetAddress: streetAddressInput, suburb: suburbInput, description: descriptionInput};");
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping(path = "{ID}")
    public Project getProjectByID(@PathVariable("ID") String projectID) {
        return projectService.getProjectByID(projectID)
                .orElse(null);
    }

    @DeleteMapping(path = "{ID}")
    public void deleteProjectByID(@PathVariable("ID") String projectID) {
        projectService.deleteProject(projectID);
    }

    @PutMapping(path = "{ID}")
    public void updateProject(@PathVariable("ID") String projectID, @NonNull @RequestBody Project projectToUpdate) {
        projectService.updateProject(projectID, projectToUpdate);
    }

}
