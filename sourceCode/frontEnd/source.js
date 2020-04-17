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
  console.log("this is cool");
}

var isProjectExpanded = false;

function expandProject(projectNumber) {

  if (document.getElementById("project" + projectNumber).style.height == "250px") {
    document.getElementById("project" + projectNumber).style.height = "800px";
    isProjectExpanded = true;
  } else {
    document.getElementById("project" + projectNumber).style.height = "250px";
    isProjectExpanded = false;
  }

}
