currentTaskName = document.getElementById("currentTaskName").innerText;

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

    if(currentTaskName != null) {

        var currentTaskBarDisplay = document.createElement("span");

        currentTaskName = document.getElementById("currentTaskName").innerText;

        currentTaskBarDisplay.innerHTML = currentTaskName;
        currentTaskBarDisplay.style.color = '#FCFAF9';
        currentTaskBarDisplay.style.padding = "5px";
        currentTaskBarDisplay.style.justifyContent = "center";
        currentTaskBarDisplay.style.alignContent = "center";
        currentTaskBarDisplay.style.background = '#586994';
        currentTaskBarDisplay.style.margin = "5px";
        currentTaskBarDisplay.style.borderRadius = "3px 3px 3px 3px";

        document.getElementById("currentTaskBar").appendChild(currentTaskBarDisplay);

    } else if(currentTaskName == null) {

        var currentTaskBarDisplay = document.createElement("span");

        currentTaskBarDisplay.innerHTML = "N/A";
        currentTaskBarDisplay.style.color = '#FCFAF9';
        currentTaskBarDisplay.style.padding = "5px";
        currentTaskBarDisplay.style.justifyContent = "center";
        currentTaskBarDisplay.style.alignContent = "center";
        currentTaskBarDisplay.style.background = '#586994';
        currentTaskBarDisplay.style.margin = "5px";
        currentTaskBarDisplay.style.borderRadius = "3px 3px 3px 3px";

        document.getElementById("currentTaskBar").appendChild(currentTaskBarDisplay);

    }

for(i = 1; i < userTasks.length; i++) {

    if(userTasks[i].finished === false) {

    var taskName = userTasks[i].name;

    var taskDiv = document.createElement("div");

    taskDiv.draggable;
    taskDiv.innerHTML = taskName;
    taskDiv.style.background = '#586994';
    taskDiv.style.color = '#FCFAF9';
    taskDiv.style.borderRadius = "3px 3px 3px 3px";
    taskDiv.style.margin = "1em";
    taskDiv.style.padding = "5px";
    taskDiv.style.border = "medium solid #FCFAF9";

    document.getElementById("taskList").appendChild(taskDiv);
    }
}

