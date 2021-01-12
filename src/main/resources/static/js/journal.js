var currentDayOfMonth = document.getElementById('dayOfMonth').innerText;

var userMonth = document.getElementById("month").innerText;

var userDate = document.getElementById("userLocalDate").innerText;

var totalTasksComplete = 0;

var totalDailyTasks = 0;

var tasksCompletedCounter;

for(i = 0; i < userTasks.length; i++) {

    // find number of completed tasks
    if((userTasks[i].taskDate == userDate) && (userTasks[i].finished == true)) {
        totalTasksComplete += 1;
    }

    // find total number of completed/uncompleted daily user tasks
    if(userTasks[i].taskDate == userDate) {
        totalDailyTasks += 1;
    }
}

tasksCompletedCounter = totalTasksComplete + "/" + totalDailyTasks;

document.getElementById("genStart").innerText = "Today, " + userMonth + " "
                        + currentDayOfMonth + "," + " you have completed [";

document.getElementById("genMid").innerText = tasksCompletedCounter;

document.getElementById('genEnd').innerText = "] tasks.";


if(totalTasksComplete == userTasks.length) {
    document.getElementById("genMid").style.color = '#A3C9A8';
} else {
    document.getElementById("genMid").style.color = '#FFD07B';
}