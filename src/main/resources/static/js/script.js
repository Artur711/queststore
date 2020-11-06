const form = document.getElementById('form');
const errorElement = document.getElementById('error');

const send = document.getElementById('send')
const firstName = document.getElementById('first_name')
const lastName = document.getElementById('last_name')
const email = document.getElementById('email');
const password = document.getElementById('password');
const phone = document.getElementById('phone_number');
const level = document.getElementById('loe_id');
const coins = document.getElementById('codecool_coins')
const numbers = /^[0-9]+$/;
const letters = /^[A-Za-z ]+$/;
const mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

form.addEventListener('submit', (e) => {
    let messages = checkNames(firstName.value);

    if (messages == null) {
        messages = checkNames(lastName.value);
    }

    if (messages == null) {
        messages = checkMail(email.value);
    }

    if (messages == null) {
        messages = checkPassword(password.value);
    }

    if (messages == null) {
        messages = checkPhone(phone.value);
    }

    if (messages == null) {
        messages = checkLevel(level.value);
    }

    if (messages == null) {
        messages = checkCoins(coins.value);
    }

    if (messages != null) {
        alert(messages);
        e.preventDefault();
    }
})


function checkNames(name) {
   let messages;

    if (name.length < 3) {
        messages = 'Name and last name must be longer than 2 characters';
    } else if (!name.match(letters)) {
        messages = 'Name and last name must be alphabet characters only';
    } else if (whiteSpaces(name)) {
        messages = 'The name cannot contain only spaces';
    } else if (!name.match(letters)) {
        messages = 'Please input alphabet characters only';
    } else if (!titleCases(name)) {
        messages = 'Each word in name and last name must start with a capital letter';
    } else if (name.length > 20) {
        messages = "Name mustn't be longer than 20 characters";
    }
    return messages;
}

function whiteSpaces(str) {
    return (!str.replace(/\s/g, '').length) ? true : false;
}

function titleCases(str) {
    let splitStr = str.split(' ');
    for (let i = 0; i < splitStr.length; i++) {
        if (!(splitStr[i].charAt(0) == splitStr[i].charAt(0).toUpperCase())) {
            return false;
        }
    }
    return true;
}

function checkMail(mail) {
    let messages;

    if (!mail.match(mailFormat)) {
        messages = 'You have entered an invalid email address!';
    }
    return messages;
}

function checkPassword(password) {
    let messages;
    if (password.length < 5) {
        messages = "Password must be longer than 4 signs!";
    }
    else if (password.length >= 20) {
        messages = "Password must be shorter than twenty signs!";
    }
    return messages;
}

function checkPhone(phone) {
    let messages;

    if (!phone.match(numbers)) {
        messages = 'You have entered an invalid phone number!';
    }
    return messages;
}

function checkLevel(level) {
    let messages;

    if (!level.match(numbers)) {
        messages = 'You have entered an invalid level!'
    }
    return messages;
}

function checkCoins(coin) {
    let messages;

    if (!coin.match(numbers)) {
        messages = 'You have entered an invalid coins!'
    }
    return messages;
}