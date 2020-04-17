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

var isProjectExpandedArray = [false, false]

function expandProject(projectNumber) {

  if (isProjectExpandedArray[projectNumber - 1] == false) {
    document.getElementById("project" + projectNumber).style.height = "800px";
    document.getElementById("project" + projectNumber + "Table").style.display = "block"
    isProjectExpandedArray[projectNumber - 1] = true;
  } else {
    document.getElementById("project" + projectNumber).style.height = "500px";
    document.getElementById("project" + projectNumber + "Table").style.display = "none"
    isProjectExpandedArray[projectNumber - 1] = false;
  }

}
