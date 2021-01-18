var activeUserTasks = 0;

// open finish task modal
document.getElementById("finishTaskButton").addEventListener("click",
    function() {
        document.querySelector("#task-modal-bg").style.display = "flex";
    });

// close finish task modal
document.getElementById("task-modal-close").addEventListener("click",
    function() {
        document.querySelector("#task-modal-bg").style.display = "none";
    });

for(i = 0; i < userTasks.length; i++) {
    if(userTasks[i].finished === false) {
        activeUserTasks += 1;
    }
}

for(i = 1; i < userTasks.length; i++) {

    if(userTasks[i].finished === false) {

    var taskName = userTasks[i].name;

    var taskDiv = document.createElement("div");

    taskDiv.draggable;
    taskDiv.innerHTML = taskName;
    taskDiv.style.background = '#a698da';
    taskDiv.style.color = '#fbf7f4';
    taskDiv.style.borderRadius = "6px 6px 6px 6px";
    taskDiv.style.margin = "0 1em 0.3em 1em";
    taskDiv.style.padding = "5px";
    taskDiv.style.border = "medium solid #FCFAF9";

    document.getElementById("taskListContents").appendChild(taskDiv);
    }
}

