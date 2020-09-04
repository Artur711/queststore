const name = document.getElementById('name');
const surname = document.getElementById('surename');
const phone = document.getElementById('phone');
const form = document.getElementById('form');
const password = document.getElementById('password');
const mail = document.getElementById('mail');
const save = document.getElementById("savebutton");

save.addEventListener("mouseenter", myFunction);
save.addEventListener("click", confirm);

form.addEventListener('input', () => {
    if (!checkIsEmpty(name, 'Your Name') && !checkIsEmpty(surname, 'Your Surename')
        && !checkIsEmpty(password, 'Your password')
        && !checkIsEmpty(mail, 'Your email')
        && !checkIsEmpty(phone, 'Your phone')) {
        savebutton.removeAttribute('disabled');

    } else {
        savebutton.setAttribute('disabled', 'disabled');
    }

});

function myFunction() {
    if (save.disabled) {
        alert('Please provide with all information.');
    }
}

function confirm() {
    if (!save.disabled) {
        alert("Entity has been added");

    }
}


function checkIsEmpty(name, value) {
    return (name.value === value || name.value == null || name.value == "") ? true : false;
}
