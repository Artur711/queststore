const form = document.getElementById('form');
const name = document.getElementById('name');
const description = document.getElementById('description');
const value = document.getElementById('value');
const save = document.getElementById("save");

form.addEventListener('input', () => {
    if (checkName(name.value) && checkDescription(description.value) && checkIfMark() && checkValue(value.value)) {
        save.removeAttribute('disabled');
    }
    else {
        save.setAttribute('disabled', 'disabled');
    }
});

function checkName(name) {
    if (name === 'Name of Item' || name == null || name == "" || name === 'Name of Artifact') {
        return false;
    }
    return true;
}

function checkDescription(description) {
    if (description === 'Description of Item' || description == null || description == "" || description === 'Description of artefact') {
        return false;
    }
    return true;
}

function checkIfMark() {
    const single = document.getElementById("single").checked;
    const team = document.getElementById("team").checked;

    return (single || team) ? true : false;
}

function checkValue(value) {
    if (value === 'Price of items' || value == null || value == "" || value === 'Value of artefact') {
        return false;
    }
    return true;
}