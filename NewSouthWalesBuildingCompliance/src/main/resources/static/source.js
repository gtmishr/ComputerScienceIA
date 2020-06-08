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

    var projectID = document.getElementById("projectIDInput").value;
    var clientName = document.getElementById("clientNameInput").value;
    var streetAddress = document.getElementById("streetAddressInput").value;
    var suburb = document.getElementById("suburbInput").value;
    var description = document.getElementById("descriptionInput").value;

    console.log(projectID);

//    request.send();
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

var request = new XMLHttpRequest()
request.open('GET', 'http://localhost:8080/api/contractor', false)

request.onload = () => {
    var data = JSON.parse(request.response)
    console.log(data);
}

