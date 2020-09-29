function clickCell(index) {
    const id = "index_" + index;
    const subpage = document.getElementById(id);

    if (subpage.innerText === 'Classes') {
        document.getElementById('iframe').src = "/mentor_class_list";
    } else if (subpage.innerText === 'Codecoolers') {
        // document.getElementById('iframe').src = 'student_list.html';
        document.getElementById('iframe').src = "/student_list";
    } else if (subpage.innerText === 'Teams') {
        document.getElementById('iframe').src = "/add_new_team";
    } else if (subpage.innerText === 'Expierience Leves') {
        document.getElementById('iframe').src = "/experiences_levels";
    } else if (subpage.innerText === 'Questes') {
        document.getElementById('iframe').src = "/quest_list";
    } else if (subpage.innerText === 'Items') {
        document.getElementById('iframe').src = "/items_list";
    } else if (subpage.innerText === 'Wallets') {
        document.getElementById('iframe').src = "/wallet_list";
    } else if (subpage.innerText === 'My profile') {
        document.getElementById('iframe').src = "/mentor_profile_page";
    }
}

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}