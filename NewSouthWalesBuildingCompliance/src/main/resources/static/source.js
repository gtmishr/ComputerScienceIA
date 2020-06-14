var isProjectExpandedArray = [false]

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

    createNewButtonHTML(postProjectRequest);

    var templateButtonQuery = document.querySelector("#project0");
    var templateButtonClone = templateButtonQuery.cloneNode(true);
    isProjectExpandedArray.push(false);

    templateButtonClone.id = "project" + isProjectExpandedArray.length +;

}

// DOESN'T CURRENTLY WORK
function deleteProject() {

    var projectIDInputToDelete = document.getElementById("projectIDInputToDelete").value;

//    console.log(projectIDInputToDelete);

    var deleteProjectRequest = new XMLHttpRequest();
    deleteProjectRequest.open('DELETE', 'http://localhost:8080/api/project/ ' + projectIDInputToDelete, true);
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

// DOESN'T CURRENTLY WORK
function deleteContractor() {

    var contractorLicenceID = document.getElementById("contractorLicenceIDToDelete").value;

//    console.log(contractorLicenceID);

    var deleteContractorRequest = new XMLHttpRequest();
    deleteContractorRequest.open('DELETE', 'http://localhost:8080/api/contractor/ ' + contractorLicenceID, true);
    deleteContractorRequest.send(contractorLicenceIDToDelete);

    deleteContractorRequest.onreadystatechange = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status === 200) {
            console.log("deleteContractorRequest successfully completed.");
        }
    }
}

function expandProject(projectNumber) {

  if (isProjectExpandedArray[projectNumber] == false) {
    document.getElementById("project" + projectNumber).style.height = "900px";
    document.getElementById("project" + projectNumber).style.width = "900px";
    document.getElementById("project" + projectNumber + "TodoItemsTable").style.display = "inherit";
    document.getElementById("project" + projectNumber + "ContractorTable").style.display = "inherit";
    isProjectExpandedArray[projectNumber] = true;
  } else {
    document.getElementById("project" + projectNumber).style.height = "500px";
    document.getElementById("project" + projectNumber).style.width = "400px";
    document.getElementById("project" + projectNumber + "TodoItemsTable").style.display = "none";
    document.getElementById("project" + projectNumber + "ContractorTable").style.display = "none";
    isProjectExpandedArray[projectNumber] = false;
  }

}

var getContractorRequest = new XMLHttpRequest();
getContractorRequest.open('GET', 'http://localhost:8080/api/contractor', true);

getContractorRequest.onload = () => {
    var getContractorData = JSON.parse(getContractorRequest.response);
    console.log("getContractorRequest successfully completed.");
}