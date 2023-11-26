const dropdownBtn = document.getElementById("user-dropdown-menu-btn");
const dropdownMenu = document.getElementById("user-dropdown-menu");

const toggleDropdown = () => dropdownMenu.classList.toggle("show");

dropdownBtn.addEventListener("click", function (e) {
    e.stopPropagation();
    toggleDropdown();
});

document.documentElement.addEventListener("click", function () {
    if(dropdownMenu.classList.contains("show")) {
        toggleDropdown();
    }
});