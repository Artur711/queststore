const name = document.getElementById('name')
const mail = document.getElementById('mail')
const form = document.getElementById('form')
const comments = document.getElementById('comments')
const errorElement = document.getElementById('error')
const send = document.getElementById('send')

form.addEventListener('submit', (e) => {
    let messages = checkName(name.value);

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
    let letters = /^[A-Za-z ]+$/;

    if (name === 'Enter your name') {
        messages = 'Name is required';
    } else if (name.length < 3) {
        messages = 'Name must be longer than 2 characters';
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
    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (!mail.match(mailformat)) {
        messages = 'MYou have entered an invalid email address!';
    }
    return messages;
}

function checkComments(comments) {
    let messages;

    if (comments === 'Your comments') {
        messages = 'Comment is required';
    } else if (whiteSpace(comments)) {
        messages = 'The comment connot contain only spaces';
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

function checkIfHaveScapces(str) {
    let splitStr = str.split(' ');
    return splitStr.length > 1 ? true : false;
}

function checkIfHaveTwoMembers(str) {
    let splitStr = str.split('@');
    return splitStr.length == 2 ? true : false;
}

function checkIfMonkeyIsBegginingOrEnd(str) {
    if (str.charAt(0) == '@') {
        return true;
    } else if (str.charAt(str.length - 1) == '@') {
        return true;
    }
    return false;
}

function checkIfBegginningvalues() {
    if (name.value === 'Enter your name') {
        return true;
    } else if (mail.value === 'Give your email') {
        return true;
    } else if (comments.value === 'Your comments') {
        return true;
    }
    return false;
}

form.addEventListener('input', () => {
    if (!checkIsEmpty()) {
        send.removeAttribute('disabled');
    } else {
        send.setAttribute('disabled', 'disabled');
    }
});

function checkIsEmpty() {
    let firstField = true;
    let seconfField = true;
    let thirdField = true;

    if (name.value === 'Enter your name' || name.value == null || name.value == "") {
        firstField = false;
    }
    if (mail.value === 'Give your email' || mail.value == null || mail.value == "") {
        seconfField = false;
    }
    if (comments.value === 'Your comments' || comments.value == null || comments.value == "") {
        thirdField = false;
    }

    if (firstField && seconfField && thirdField) {
        return false;
    } else {
        return true;
    }
}