const page = document.getElementById("page").value;
const category = document.getElementById("category").value;

const pageActiveElement = document.querySelector(".row .pagination .active")
if (pageActiveElement)
	pageActiveElement.classList.remove("active")
const pageElement = document.querySelector(`.row .pagination-page-${page}`)
pageElement.classList.add("active")