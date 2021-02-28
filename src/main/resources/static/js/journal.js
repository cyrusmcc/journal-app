var currentDayOfMonth = document.getElementById('dayOfMonth').innerText;

var userMonth = document.getElementById("month").innerText;

var userDate = document.getElementById("userLocalDate").innerText;

var username = document.getElementById("username").innerText;

var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September",
    "October", "November", "December"];

var totalGoalsComplete = 0;

var totalDailyGoals = 0;

var goalsCompletedCounter;

function onClickJournal() {

    document.getElementById("tab1").style.opacity = "1";
    document.getElementById("tab1").style.height = "4vh";

    document.getElementById("tab2").style.opacity = "0.5";
    document.getElementById("tab2").style.height = "3vh";

    document.getElementById("tab3").style.opacity = "0.5";
    document.getElementById("tab3").style.height = "3vh";

    document.getElementById("eventList").style.display = "none";
    document.getElementById("goalList").style.display = "none";
    document.getElementById("journal").style.display = "block";
}

for(i = 0; i < userGoals.length; i++) {

    // find number of completed goals
    if((userGoals[i].goalDate == userDate) && (userGoals[i].finished == true)) {
        totalGoalsComplete += 1;
    }

    // find total number of completed/uncompleted daily user goals
    if(userGoals[i].goalDate == userDate) {
        totalDailyGoals += 1;
    }
}

goalsCompletedCounter = totalGoalsComplete + "/" + totalDailyGoals;

document.getElementById("genStart").innerText = "Hey, "+ username + "! Today, " + months[d.getMonth()] + " "
                        + currentDayOfMonth + "," + " you have completed [";

document.getElementById("genStart").style.color = "#fbf7f4";

document.getElementById("genMid").innerText = goalsCompletedCounter;

document.getElementById('genEnd').innerText = "] goals.";

document.getElementById("genEnd").style.color = "#fbf7f4";

if(totalGoalsComplete == userGoals.length) {
    document.getElementById("genMid").style.color = '#A3C9A8';
} else {
    document.getElementById("genMid").style.color = '#FFD07B';
}


var noteText = document.getElementById("dailyGoalSummary").innerText;

noteText.split("###");

console.log(noteText);

