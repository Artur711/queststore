const phone = document.getElementById('phone');
const form = document.getElementById('form');
const password = document.getElementById('password');
const mail = document.getElementById('mail');


function openList1() {
    let list = document.getElementById("ollist");

    if (list.style.display == "none"){
        list.style.display = "block";
    }else{
        list.style.display = "none";
    }
}

form.addEventListener('input', () => {
    if (!checkIsEmpty(phone, '0125548755')) {
        submit_phone.removeAttribute('disabled');
    }
    else {
        submit_phone.setAttribute('disabled', 'disabled');
    }

    if (!checkIsEmpty(password, 'kZj4fv8cV')) {
        submit_password.removeAttribute('disabled');
    }
    else {
        submit_password.setAttribute('disabled', 'disabled');
    }

    if (!checkIsEmpty(mail, 'domink.nowak@gamial.com')) {
        submit_mail.removeAttribute('disabled');
    }
    else {
        submit_mail.setAttribute('disabled', 'disabled');
    }

});

function checkIsEmpty(name, value) {
    return (name.value === value || name.value == null || name.value == "") ? true : false;
}
<<<<<<< Updated upstream
=======


function updateTitle(){
    let input = document.getElementsByClassName('input');

    input.setAttribute('value', input.value);
    
}

function edit(){
    document.getElementById("send-button").disabled = false; 
}
>>>>>>> Stashed changes
