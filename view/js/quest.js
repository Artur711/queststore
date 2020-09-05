function clickCell(index) {
    const id = "index_" + index;
    const item = document.getElementById(id);
    if (item.innerText === "TO DO") {
        item.innerText = "DONE";
        item.style.backgroundColor = "red";
        item.style.borderColor = "black";
    }
    else {
        item.innerText = "TO DO";
        item.style.backgroundColor = "#e2d7d7";
        item.style.borderColor = '#73AD21';
    }

}