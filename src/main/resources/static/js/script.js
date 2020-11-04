const form = document.getElementById('form_inside');
const errorElement = document.getElementById('error');

// const send = document.getElementById('send')
// const firstName = document.getElementById('firstName')
// const lastName = document.getElementById('lastName')
// const email = document.getElementById('email');
// const password = document.getElementById('password');
// const phone = document.getElementById('phoneNumber');
// const level = document.getElementById('loe_id');
// const coins = document.getElementById('codecool_coins')
const numbers = /^[0-9]+$/;
const letters = /^[A-Za-z ]+$/;
const mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

form.addEventListener('submit', (e) => {
    alert("Sorry");
})

function myFunction() {
    alert("DOM DOM DOM")
}

// function checkNames(name) {
//     let messages;
//
//     if (name.length < 3) {
//         messages = 'Name and last name must be longer than 2 characters';
//     } else if (!name.match(letters)) {
//         messages = 'Please input alphabet characters only';
//     } else if (whiteSpace(name)) {
//         messages = 'The name cannot contain only spaces';
//     } else if (!titleCase(name)) {
//         messages = 'Each word must start with a capital letter';
//     } else if (name.length > 20) {
//         messages = "Name mustn't be longer than 20 characters";
//     }
//     return messages;
// }
//
// function checkMail(mail) {
//     let messages;
//
//     if (!mail.match(mailFormat)) {
//         messages = 'You have entered an invalid email address!';
//     }
//     return messages;
// }
//
// function checkPassword(password) {
//     let messages;
//
//     if (password.length < 5 && password.length > 20) {
//         messages = "Password must be longer than 5 signs and shorter than twenty signs!"
//     }phone.length
//     return messages;
// }
//
// function checkPhone(phone) {
//     let messages;
//
//     if (phone.length < 9 && phone.length > 13 && !phone.match(numbers)) {
//         messages = 'You have entered an invalid phone number!'
//     }
//     return messages;
// }
//
// function checkLevel(level) {
//     let messages;
//
//     if (!level.match(numbers)) {
//         messages = 'You have entered an invalid level!'
//     }
//     return messages;
// }
//
// function checkCoins(coin) {
//     let messages;
//
//     if (!coin.match(numbers)) {
//         messages = 'You have entered an invalid coins!'
//     }
//     return messages;
// }