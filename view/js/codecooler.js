function clickCell(index) {
    const id = "index_" + index;
    const subpage = document.getElementById(id);
    
    if (subpage.innerText === 'Classes') {
        document.getElementById('iframe').src = 'my_class_list.html';
    }
    else if (subpage.innerText === 'Teams') {
        document.getElementById('iframe').src = 'my_team_list.html';
    }
    else if (subpage.innerText === 'Quests') {
        document.getElementById('iframe').src = 'quests_menu.html';
    }
    else if (subpage.innerText === 'Items') {
        document.getElementById('iframe').src = 'store_menu.html';
    }
    else if (subpage.innerText === 'My profile') {
        document.getElementById('iframe').src = 'codecooler_profile_page.html';
    }
}

function openList1() {
    let list = document.getElementById("ollist");

    if (list.style.display == "none"){
        list.style.display = "block";
    }else{
        list.style.display = "none";
    }
}