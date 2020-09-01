"use strict";

window.onload = startPage;

function startPage() {

    const btn = document.getElementById("myBtn");
    const span = document.getElementsByClassName("close")[0];
    const modal = document.getElementById("myModal");

    btn.addEventListener("click", () => openModal(modal));
    span.addEventListener("click", () => closeModalButton(modal));
    window.addEventListener("click", () => closeModalOutScreen(modal));
}

function openModal(modal) {
    modal.setAttribute("class", "modal " + "showAnimation");
    modal.style.display = "block";
}

function closeModalButton(modal) {
    modal.style.display = "none";
}

function closeModalOutScreen(modal) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
}
