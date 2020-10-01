function clickCell(index) {
    const id = "index_" + index;
    const subpage = document.getElementById(id);

    if (subpage.innerText === 'Classes') {
        document.getElementById('iframe').src = "/my_class_list";
    } else if (subpage.innerText === 'Teams') {
        document.getElementById('iframe').src = "/my_team_list";
    } else if (subpage.innerText === 'Quests') {
        document.getElementById('iframe').src = "/quests_menu";
    } else if (subpage.innerText === 'Items') {
        document.getElementById('iframe').src = "/items_menu";
    } else if (subpage.innerText === 'My profile') {
        document.getElementById('iframe').src = "/codecooler_profile";
    }
}

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}