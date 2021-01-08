var currentJournalEntry = document.getElementById("journalEntry").innerText;


var tasksCompletedCounter;

var userMonth = document.getElementById("month").innerText;

let userDate = new Date();

var totalTasksComplete = 0;

tasksCompletedCounter = totalTasksComplete + "/" + userTasks.length;

document.getElementById("genStart").innerText = "Today, " + userMonth + " "
                             + userDate.getDate() + "," + " you have completed [";

document.getElementById("genMid").innerText = tasksCompletedCounter;

document.getElementById('genEnd').innerText = "] tasks.";

if(totalTasksComplete == userTasks.length) {
    document.getElementById("genMid").style.color = '#A3C9A8';
} else {
    document.getElementById("genMid").style.color = '#FFD07B';
}