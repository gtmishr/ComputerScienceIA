function searchBar() {

  var query = document.getElementById("searchBar").value.toUpperCase();
  var searchMenu = document.getElementById("searchMenu");
  var searchList = searchMenu.getElementsByTagName("li");
  var i;

  for (i = 0; i < searchList.length; i++) {
    var link = searchList[i].getElementsByTagName("a")[0];

    if (link.innerHTML.toUpperCase().indexOf(query) > - 1) {
      searchList[i].style.display = "";
    } else {
      searchList[i].style.display = "none";
    }

  }

}

function createNewButton() {
    createNewProject();
    // Implement write to file
}

function createNewProject() {

    var projectIDInput = document.getElementById("projectIDInput").value;
    var clientNameInput = document.getElementById("clientNameInput").value;
    var streetAddressInput = document.getElementById("streetAddressInput").value;
    var suburbInput = document.getElementById("suburbInput").value;
    var descriptionInput = document.getElementById("descriptionInput").value;

    var rawProjectInput = {projectID: projectIDInput, clientName: clientNameInput, streetAddress: streetAddressInput, suburb: suburbInput, description: descriptionInput};
    var inputProjectParsed = JSON.stringify(rawProjectInput);

    console.log(inputProjectParsed);

    var postProjectRequest = new XMLHttpRequest();
    postProjectRequest.open('POST', 'http://localhost:8080/api/project', true);

    postProjectRequest.setRequestHeader("Content-Type", 'application/json');
    postProjectRequest.send(inputProjectParsed);

    postProjectRequest.onreadystatechange = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
            console.log("postProjectRequest successfully completed.");
        }
    }

}

var isProjectExpandedArray = [false, false]

function expandProject(projectNumber) {

  if (isProjectExpandedArray[projectNumber - 1] == false) {
    document.getElementById("project" + projectNumber).style.height = "900px";
    document.getElementById("project" + projectNumber).style.width = "900px";
    document.getElementById("project" + projectNumber + "TodoItemsTable").style.display = "inherit";
    document.getElementById("project" + projectNumber + "ContractorTable").style.display = "inherit";
    isProjectExpandedArray[projectNumber - 1] = true;
  } else {
    document.getElementById("project" + projectNumber).style.height = "500px";
    document.getElementById("project" + projectNumber).style.width = "400px";
    document.getElementById("project" + projectNumber + "TodoItemsTable").style.display = "none";
    document.getElementById("project" + projectNumber + "ContractorTable").style.display = "none";
    isProjectExpandedArray[projectNumber - 1] = false;
  }

}

var getContractorRequest = new XMLHttpRequest();
getContractorRequest.open('GET', 'http://localhost:8080/api/contractor', true);

getContractorRequest.onload = () => {
    var getContractorData = JSON.parse(getContractorRequest.response);
    console.log(getContractorData);
    console.log("getContractorRequest successfully completed.");
}

