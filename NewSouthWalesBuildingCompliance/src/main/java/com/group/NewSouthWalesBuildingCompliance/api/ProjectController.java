package com.group.NewSouthWalesBuildingCompliance.api;

import com.group.NewSouthWalesBuildingCompliance.model.Project;
import com.group.NewSouthWalesBuildingCompliance.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import org.json.JSONArray;


@RequestMapping("api/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public void addProject(@NonNull @RequestBody Project project) throws IOException {
        projectService.addProject(project);

        File projectData = new File("src/main/resources/static/projectData.txt");
        FileWriter projectFileWriter = new FileWriter(projectData, true);
        PrintWriter projectPrintWriter = new PrintWriter(projectFileWriter);

        projectPrintWriter.println("{\"projectID\": \"" + project.getProjectID() + "\", \"clientName\": \"" + project.getClientName() + "\", \"streetAddress\": \"" + project.getStreetAddress() + "\", \"suburb\": \"" + project.getSuburb() + "\", \"description\": \"" + project.getDescription() +"\"}");
        projectPrintWriter.close();
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
    public void deleteProjectByID(@PathVariable("ID") String projectID) throws IOException {
        projectService.deleteProject(projectID);

        File inputFile = new File("src/main/resources/static/projectData.txt");
        File temporaryFile = new File("src/main/resources/static/temporaryProjectFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(temporaryFile));

        String currentLine = reader.readLine();

        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.contains(projectID)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

        boolean deleteSuccessful = temporaryFile.renameTo(inputFile);
        writer.close();
    }

    @PutMapping(path = "{ID}")
    public void updateProject(@PathVariable("ID") String projectID, @NonNull @RequestBody Project projectToUpdate) {
        projectService.updateProject(projectID, projectToUpdate);
    }

}
