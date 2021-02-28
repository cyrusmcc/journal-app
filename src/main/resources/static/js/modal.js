var modal = document.getElementById("goal-modal-content");

// open finish goal modal
function openModal(form) {

    document.querySelector("#goal-modal-bg").style.display = "flex";

    document.getElementById(form).style.display = "flex";

}

// close finish goal modal
function closeModal(form) {

    document.getElementById("goalForm").style.display = "none";

    document.getElementById("eventForm").style.display = "none";

    document.querySelector("#goal-modal-bg").style.display = "none";

}


