var userTasks = JSON.parse(document.getElementById("userTasks").innerText);
console.log(userTasks);




for(i = 0; i < userTasks.length; i++) {

    var taskName = userTasks[i].name;

    var taskDiv = document.createElement("div");

    taskDiv.innerHTML = taskName;
    taskDiv.style.background = '#586994';
    taskDiv.style.color = '#FCFAF9';
    taskDiv.style.borderRadius = "10px 10px 10px 10px";
    taskDiv.style.margin = "1em";
    taskDiv.style.padding = "5px";

    document.getElementById("taskList").appendChild(taskDiv);
}
