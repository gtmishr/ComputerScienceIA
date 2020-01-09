function createNewButton() {
    console.log("this is cool");
}

function searchBar() {

  var input, filter, searchMenu, searchList, link, i;

  input = document.getElementById("searchBar");
  filter = input.value.toUpperCase();
  searchMenu = document.getElementById("searchMenu");
  searchList = searchMenu.getElementsByTagName("li");

  for (i = 0; i < searchList.length; i++) {
    link = searchList[i].getElementsByTagName("a")[0];

    if (link.innerHTML.toUpperCase().indexOf(filter) > - 1) {
      searchList[i].style.display = "";
    } else {
      searchList[i].style.display = "none";
    }

  }

}
