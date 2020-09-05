function clickCell(index) {
    const id = "index_" + index;
    const item = document.getElementById(id);
    item.innerText = "USED";
    item.style.backgroundColor = "red";
    item.style.borderColor = "black";
    item.setAttribute('disabled', 'disabled');
}