var modal = document.getElementById("task-modal-content");

// open finish task modal
function openModal(form) {

    document.querySelector("#task-modal-bg").style.display = "flex";

    document.getElementById(form).style.display = "flex";

}

// close finish task modal
function closeModal(form) {

    document.getElementById("taskForm").style.display = "none";

    document.getElementById("eventForm").style.display = "none";

    document.querySelector("#task-modal-bg").style.display = "none";

}


