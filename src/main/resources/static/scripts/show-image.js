const fileUpload = document.getElementById("file-upload");
const dropArea = document.getElementById("file-drop-area");
const img = document.getElementById("file-img");

document.addEventListener("DOMContentLoaded", function() {
    const imgUrl = img.getAttribute("data-url");
    if(imgUrl !== "") {
        img.src = imgUrl;
    }
});

const displayImg = (files) => {
    const [file] = files;
    if(file) img.src = URL.createObjectURL(file);
    fileUpload.files = files;

    dropArea.querySelector("svg").style.display = "none";
    dropArea.querySelectorAll("span").forEach(spanElement => spanElement.style.display = "none");
};

dropArea.addEventListener("dragover", e => {
    e.preventDefault();
    dropArea.classList.add("highlight");
});

dropArea.addEventListener("dragleave", e => {
    e.preventDefault();
    dropArea.classList.remove("highlight");
});

dropArea.addEventListener("drop", e => {
    e.preventDefault();
    dropArea.classList.remove("highlight");
    displayImg(e.dataTransfer.files);
});

fileUpload.addEventListener("change", e => {
    displayImg(e.target.files);
});