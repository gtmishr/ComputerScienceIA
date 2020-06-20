var isProjectExpandedArray = [false]

function addWrittenContractors(file) {

    var rawFile = new XMLHttpRequest();
    var splitWritten = [];
    
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status == 0) {
                var allText = rawFile.responseText;
                splitWritten = allText.split("\n");
                console.log(splitWritten);
            }
        }
    }
    
    rawFile.send(null);
    
    var i;
    for (i = 0; i < splitWritten.length; i++) {
        
        var postContractorRequest = new XMLHttpRequest();
        postContractorRequest.open('POST', 'http://localhost:8080/api/contractor', true);

        postContractorRequest.setRequestHeader("Content-Type", 'application/json');
        postContractorRequest.send(splitWritten[i]);

        postContractorRequest.onreadystatechange = function() {
            if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
             console.log("postContractorRequest successfully completed.");
            }
        }     
    }
}

function addWrittenProjects(file) {

    var rawFile = new XMLHttpRequest();
    var splitWritten = [];
    
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status == 0) {
                var allText = rawFile.responseText;
                splitWritten = allText.split("\n");
                console.log(splitWritten);
            }
        }
    }
    
    rawFile.send(null);
    
    var i;
    for (i = 0; i < splitWritten.length; i++) {
        
        var postContractorRequest = new XMLHttpRequest();
        postContractorRequest.open('POST', 'http://localhost:8080/api/project', true);

        postContractorRequest.setRequestHeader("Content-Type", 'application/json');
        postContractorRequest.send(splitWritten[i]);

        postContractorRequest.onreadystatechange = function() {
            if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
             console.log("postProject successfully completed.");
            }
        }     
    }

}

function addNewHTMLElements() {

    var toDuplicate = document.getElementById("project0");
    var clone = toDuplicate.cloneNode(true);

    clone.id = "project" + isProjectExpandedArray.length;
    clone.setAttribute("onclick", "expandProject(" + isProjectExpandedArray.length + ")");
    isProjectExpandedArray.push(false);

    document.getElementById("searchMenu").appendChild(clone);

}

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

    var templateButtonQuery = document.querySelector("#project0");
    var templateButtonClone = templateButtonQuery.cloneNode(true);
    isProjectExpandedArray.push(false);
    templateButtonClone.id = "project" + isProjectExpandedArray.length;
}

function deleteProject() {

    var projectIDInputToDelete = document.getElementById("projectIDInputToDelete").value;

    var deleteProjectRequest = new XMLHttpRequest();
    deleteProjectRequest.open('DELETE', 'http://localhost:8080/api/project/' + projectIDInputToDelete);
    deleteProjectRequest.send(projectIDInputToDelete);

    deleteProjectRequest.onreadystatechange = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
            console.log("deleteProjectRequest successfully completed.");
        }
    }

}

function createNewContractor() {

    var contractorLicenceID = document.getElementById("contractorLicenceID").value;
    var contractorLicenceNumber = document.getElementById("contractorLicenceNumber").value; 
    var contractorBusinessNames = document.getElementById("contractorBusinessNames").value;
    var contractorCategories = document.getElementById("contractorCategories").value;
    var contractorClasses = document.getElementById("contractorClasses").value;
    var contractorLicenceName = document.getElementById("contractorLicenceName").value;
    var contractorLicenceType = document.getElementById("contractorLicenceType").value;
    var contractorLicensee = document.getElementById("contractorLicensee").value;
    var contractorPostcode = document.getElementById("contractorPostcode").value;
    var contractorStatus = document.getElementById("contractorStatus").value;
    var contractorSuburb = document.getElementById("contractorSuburb").value;

    var rawContractorInput = {licenceID: contractorLicenceID, licenceNumber: contractorLicenceNumber, businessNames: contractorBusinessNames, categories: contractorCategories, classes: contractorClasses, licenceName: contractorLicenceName, licenceType: contractorLicenceType, licensee: contractorLicensee, postcode: contractorPostcode, status: contractorStatus, suburb: contractorSuburb};
    var inputContractorParsed = JSON.stringify(rawContractorInput);
    
    var postContractorRequest = new XMLHttpRequest();
    postContractorRequest.open('POST', 'http://localhost:8080/api/contractor', true);

    postContractorRequest.setRequestHeader("Content-Type", 'application/json');
    postContractorRequest.send(inputContractorParsed);

    postContractorRequest.onreadystatechange = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
            console.log("postContractorRequest successfully completed.");
        }
    }
    
}

function deleteContractor() {

    var contractorLicenceIDToDelete = document.getElementById("contractorLicenceIDToDelete").value;

    var deleteContractorRequest = new XMLHttpRequest();
    deleteContractorRequest.open('DELETE', 'http://localhost:8080/api/contractor/' + contractorLicenceIDToDelete);
    deleteContractorRequest.send(contractorLicenceIDToDelete);
    console.log(deleteContractorRequest);

    deleteContractorRequest.onreadystatechange = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
            console.log("deleteContractorRequest successfully completed.");
        }
    }
}

function expandProject(projectNumber) {

  if (isProjectExpandedArray[projectNumber] == false) {
    document.getElementById("project" + projectNumber).style.height = "700px";
    document.getElementById("project" + projectNumber).style.width = "700px";
    document.getElementById("project" + projectNumber + "Table").style.display = "inherit";
    document.getElementById("project" + projectNumber + "ContractorTable").style.display = "inherit";
    isProjectExpandedArray[projectNumber] = true;
  } else {
    document.getElementById("project" + projectNumber).style.height = "500px";
    document.getElementById("project" + projectNumber).style.width = "400px";
    document.getElementById("project" + projectNumber + "Table").style.display = "none";
    document.getElementById("project" + projectNumber + "ContractorTable").style.display = "none";
    isProjectExpandedArray[projectNumber] = false;
  }

}

function getContractorRequest() {

    var getContractorRequest = new XMLHttpRequest();
    getContractorRequest.open('GET', 'http://localhost:8080/api/contractor', true);

    getContractorRequest.onload = () => {
        var getContractorData = JSON.parse(getContractorRequest.response);
        console.log("getContractorRequest successfully completed.");
    }

}

addWrittenContractors("contractorData.txt");
addWrittenProjects("projectData.txt");