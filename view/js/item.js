function clickCell(index) {
    const id = "index_" + index;
    const item = document.getElementById(id);
    item.innerText = "USED";
    item.style.backgroundColor = "red";
    item.style.borderColor = "black";
    item.setAttribute('disabled', 'disabled');
}

function clickCellByMenthor(index) {
    const id = "index_" + index;
    const item = document.getElementById(id);
    if (item.innerText === "CAN USE") {
        item.innerText = "USED";
        item.style.backgroundColor = "red";
        item.style.borderColor = "black";
    }
    else {
        item.innerText = "CAN USE";
        item.style.backgroundColor = "#e2d7d7";
        item.style.borderColor = '#73AD21';
    }
}