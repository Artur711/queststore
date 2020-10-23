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
    let messages = checkName(name.value);

    if (messages == null) {
        messages = checkName(lastname.value);
    }

    if (messages == null) {
        messages = checkMail(mail.value);
    }

    if (messages == null) {
        messages = checkComments(comments.value);
    }

    if (messages == null) {
        alert('Success! Your mail was sent.');
    } else if (messages.length > 0) {
        alert(messages);
        e.preventDefault();
    }
})

function checkName(name) {
    let messages;

    if (name.length < 3) {
        messages = 'Name and last name must be longer than 2 characters';
    } else if (!name.match(letters)) {
        messages = 'Please input alphabet characters only';
    } else if (whiteSpace(name)) {
        messages = 'The name cannot contain only spaces';
    } else if (!titleCase(name)) {
        messages = 'Each word must start with a capital letter';
    } else if (name.length > 20) {
        messages = "Name mustn't be longer than 20 characters";
    }
    return messages;
}

function checkMail(mail) {
    let messages;

    if (!mail.match(mailFormat)) {
        messages = 'You have entered an invalid email address!';
    }
    return messages;
}

function checkComments(comments) {
    let messages;

    if (comments === 'Your comments') {
        messages = 'Comment is required';
    } else if (whiteSpace(comments)) {
        messages = 'The comment cannot contain only spaces';
    } else if (comments.length < 10) {
        messages = 'Comment must be longer than 9 characters';
    }
    return messages;
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