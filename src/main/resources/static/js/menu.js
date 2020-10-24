function clickCell(index) {
    const id = "index_" + index;
    const subpage = document.getElementById(id);
    const userType = document.getElementById('user')

    if (userType.innerText == 3) {
        adminMenu(subpage);
    }
    else if (userType.innerText == 2) {
        mentorMenu(subpage);
    }
    else {
        codeCoolerMenu(subpage)
    }

}

function adminMenu(subpage) {
    if (subpage.innerText === 'Admins') {
        //to implement
        document.getElementById('iframe').src = "/admins_list";
    } else if (subpage.innerText === 'Classes') {
        //to implement
        document.getElementById('iframe').src = "/all_classes";
    } else if (subpage.innerText === 'Mentors') {
        document.getElementById('iframe').src = "/mentors_list";
    } else if (subpage.innerText === 'Codecoolers') {
        document.getElementById('iframe').src = "/student_list";
    } else if (subpage.innerText === 'Teams') {
        document.getElementById('iframe').src = "/add_new_team";
    } else if (subpage.innerText === 'Expierience Leves') {
        document.getElementById('iframe').src = "/experiences";
    } else if (subpage.innerText === 'Quests') {
        document.getElementById('iframe').src = "/quest_list";
    } else if (subpage.innerText === 'Items') {
        document.getElementById('iframe').src = "/item_list";
    } else if (subpage.innerText === 'Wallets') {
        document.getElementById('iframe').src = "/wallet_list";
    } else if (subpage.innerText === 'My profile') {
        document.getElementById('iframe').src = "/profile/admin_profile";
    }
}

function mentorMenu(subpage) {
    if (subpage.innerText === 'Classes') {
        document.getElementById('iframe').src = "/all_classes";
    } else if (subpage.innerText === 'Codecoolers') {
        // document.getElementById('iframe').src = 'student_list.html';
        document.getElementById('iframe').src = "/student_list";
    } else if (subpage.innerText === 'Teams') {
        document.getElementById('iframe').src = "/add_new_team";
    } else if (subpage.innerText === 'Expierience Leves') {
        document.getElementById('iframe').src = "/experiences";
    } else if (subpage.innerText === 'Quests') {
        document.getElementById('iframe').src = "/quest_list";
    } else if (subpage.innerText === 'Items') {
        document.getElementById('iframe').src = "/item_list";
    } else if (subpage.innerText === 'Wallets') {
        document.getElementById('iframe').src = "/wallet_list";
    } else if (subpage.innerText === 'My profile') {
        document.getElementById('iframe').src = "/profile/mentor_profile";
    }
}

function codeCoolerMenu(subpage) {
    if (subpage.innerText === 'Classes') {
        document.getElementById('iframe').src = "/my_class_list";
    } else if (subpage.innerText === 'Teams') {
        document.getElementById('iframe').src = "/my_team_list";
    } else if (subpage.innerText === 'Quests') {
        document.getElementById('iframe').src = "/quests_menu";
    } else if (subpage.innerText === 'Items') {
        document.getElementById('iframe').src = "/items_menu";
    } else if (subpage.innerText === 'My profile') {
        document.getElementById('iframe').src = "/profile/codecooler_profile";
    }
}

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}