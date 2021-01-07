var userTasks = JSON.parse(document.getElementById("userTasks").innerText);
console.log(userTasks);


if(userTasks[0] != null) {

    var currentTaskName = userTasks[0].name;

    var currentTask= document.createElement("span");



    currentTask.innerHTML = currentTaskName;
    currentTask.style.color = '#FCFAF9';
    currentTask.style.padding = "5px";
    currentTask.style.justifyContent = "center";
    currentTask.style.alignContent = "center";
    currentTask.style.background = '#586994';
    currentTask.style.margin = "5px";
    currentTask.style.borderRadius = "10px 10px 10px 10px";

    document.getElementById("currentTaskBar").appendChild(currentTask);
}

for(i = 1; i < userTasks.length; i++) {

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
