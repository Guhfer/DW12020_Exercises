"use strict";

window.onload = startPage;

function startPage() {
    const form = document.forms[0];
    const button = form.elements[form.length - 1];

    button.addEventListener("click", () => managerTables(form));
}

function managerTables(form) {
    let lines = form["linhas"].value;
    let columns = form["colunas"].value;

    if (lines < 1 || lines === !NaN || columns < 1 || columns === !NaN) {
        alert("Números inválidos.")
    } else {
        let table = document.getElementById("tabela");
        if (table != null) {
            removeTable(table);
        }
        createTable(lines, columns);
    }
}

function createTable(lines, columns) {
    let section = document.getElementById("s1");

    let tabble = createElement("table", section);

    createAttribute("id", tabble, "tabela");
    createAttribute("class", tabble, "tabela");

    for (let nLines = 0; nLines < lines; nLines++) {
        const tr = createElement("tr", tabble);
        for (let nColumns = 0; nColumns < columns; nColumns++) {
            if (nLines === 0) {
                createElement("th", tr);
            } else {
                createElement("td", tr);
            }
        }
    }

    console.log(section);
}

function createElement(tag, element) {
    const elementCreated = document.createElement(tag);
    element.appendChild(elementCreated);
    return elementCreated;
}

function createAttribute(attribute, element, value) {
    const createdAttribute = document.createAttribute(attribute);
    createdAttribute.nodeValue = value;
    element.setAttributeNode(createdAttribute);
}

function removeTable(element) {
    element.parentNode.removeChild(element);
}