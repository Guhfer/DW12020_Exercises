"use strict";

window.onload = () => {
    let section = document.getElementById("erros");

    let forms = document.forms;
    forms.noValidate = true;

    for (let i = 0; i < forms.length; i++) {
        let form = forms[i];
        form.addEventListener("submit", (event) => {
            let validate;
            validateData(form);
            validate = applyValidation(form, section);
            if (!validate)
                event.preventDefault();
        });
    }

    function validateData(form) {
        let name, lastName, age;

        name = form.elements["nome"]; //Acessa pela posição, nome ou id do elemento do form
        lastName = form.elements["sobrenome"];
        age = form.elements["idade"];

        if (name.value.length < 3 || lastName.value.length < 3) {
            name.setCustomValidity("Nome ou sobrenome com menos de 3 caracteres");
            lastName.setCustomValidity("Nome ou sobrenome com menos de 3 caracteres");
        } else {
            name.setCustomValidity("");
            lastName.setCustomValidity("");
        }

        if (age.value < 2) {
            age.setCustomValidity("Idade inválida, informe um número maior que 1");
        } else {
            age.setCustomValidity("");
        }

        if (name.value === lastName.value) {
            alert("Os dois campos não podem ser iguais");
        }

    }

    function applyValidation(form, secao) {
        let elements = form.elements;
        let errors = [];
        let valid = true;

        for (let i = 0; i < elements.length; i++) {
            if (!elements[i].validity.valid) {
                errors.push("Nome do campo: " + elements[i].name + " Mensagem de erro: " + elements[i].validationMessage)
            }
        }

        if (errors.length > 0) {
            valid = false;
        }

        secao.innerHTML = errors.join("<br/>");
        return valid;
    }
};
