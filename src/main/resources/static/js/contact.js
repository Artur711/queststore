const name = document.getElementById('first_name')
const lastname = document.getElementById('last_name')
const mail = document.getElementById('email')
const form = document.getElementById('form')
const comments = document.getElementById('comments')
const errorElement = document.getElementById('error')
const send = document.getElementById('send')
const letters = /^[A-Za-z ]+$/;
const mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

form.addEventListener('submit', (e) => {
    let condition1 = checkName(name.value, name);
    let condition2 = checkName(lastname.value, lastname);
    let condition3 = checkMail(mail.value);
    let condition4 = checkComments(comments.value);

    if (condition1 || condition2 || condition3 || condition4) {
        e.preventDefault();
    } else {
        alert('Success! Your mail was sent.');
    }
})

function checkName(nameValue, name) {
    if (nameValue.length < 3) {
        setMessageFor(name, 'Must be longer than 2 characters')
        return true;
    } else if (!nameValue.match(letters)) {
        setMessageFor(name, 'Alphabet characters only')
        return  true;
    } else if (whiteSpace(nameValue)) {
        setMessageFor(name, 'Cannot contain only spaces')
        return true;
    } else if (!titleCase(nameValue)) {
        setMessageFor(name, 'Start with a capital letter')
        return  true;
    } else if (nameValue.length > 20) {
        setMessageFor(name, "Mustn't be longer than 20 characters")
        return  true;
    }
    else {
        setMessageFor(name, 'Error message');
        return false;
    }
}

function checkMail(mailValue) {
    if (!mailValue.match(mailFormat)) {
        setMessageFor(mail, 'An invalid email address!')
        return true;
    }
    else {
        setMessageFor(mail, 'Error message');
        return false;
    }
}

function checkComments(commentsValue) {
    if (whiteSpace(commentsValue)) {
        setMessageFor(comments, 'Cannot contain only spaces')
        return true;
    } else if (commentsValue.length < 10) {
        setMessageFor(comments, 'Must be longer than 9 characters')
        return true;
    }
    else {
        setMessageFor(comments, 'Error message');
        return false;
    }
}

function whiteSpace(str) {
    return (!str.replace(/\s/g, '').length) ? true : false;
}

function titleCase(str) {
    let splitStr = str.split(' ');
    for (let i = 0; i < splitStr.length; i++) {
        if (!(splitStr[i].charAt(0) == splitStr[i].charAt(0).toUpperCase())) {
            return false;
        }
    }
    return true;
}

function setMessageFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    if (message === 'Error message') {
        formControl.className = 'form-control success';
    }
    else {
        formControl.className = 'form-control error';
    }
}
