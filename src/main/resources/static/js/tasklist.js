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

for(i = 0; i < userTasks.length; i++) {

    if(userTasks[i].finished == false) {

        var currentTaskName = userTasks[i].name;

        var currentTask = document.createElement("span");

        currentTask.innerHTML = currentTaskName;
        currentTask.style.color = '#FCFAF9';
        currentTask.style.padding = "5px";
        currentTask.style.justifyContent = "center";
        currentTask.style.alignContent = "center";
        currentTask.style.background = '#586994';
        currentTask.style.margin = "5px";
        currentTask.style.borderRadius = "10px 10px 10px 10px";

        document.getElementById("currentTaskBar").appendChild(currentTask);

        break
    }

}

for(i = 1; i < userTasks.length; i++) {

    if(userTasks[i].finished === false) {

    var taskName = userTasks[i].name;

    var taskDiv = document.createElement("div");

    taskDiv.draggable;
    taskDiv.innerHTML = taskName;
    taskDiv.style.background = '#586994';
    taskDiv.style.color = '#FCFAF9';
    taskDiv.style.borderRadius = "10px 10px 10px 10px";
    taskDiv.style.margin = "1em";
    taskDiv.style.padding = "5px";
    taskDiv.style.border = "thin solid #FCFAF9";

    document.getElementById("taskList").appendChild(taskDiv);
    }
}

