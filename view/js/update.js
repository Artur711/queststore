
function buttonClick(spanId, inputId){
    let newContent = document.getElementById(inputId);
    document.getElementById(spanId).innerHTML = newContent.value;
    newContent.value = "";
}
