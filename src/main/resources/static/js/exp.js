const form = document.getElementById('form')
const exp = document.getElementById('new_exp')
const errorElement = document.getElementById('error')
const send = document.getElementById('send')
const numbers = /^[0-9]+$/;

form.addEventListener('submit', (e) => {
    if (!exp.value.match(numbers) || exp.value == 0) {
        alert("Invalid level of experience!");
        e.preventDefault();
    }
})