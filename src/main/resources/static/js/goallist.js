function onClickGoalList() {

    document.getElementById("tab1").style.opacity = "0.5";
    document.getElementById("tab1").style.height = "3vh";

    document.getElementById("tab2").style.opacity = "1";
    document.getElementById("tab2").style.height = "4vh";

    document.getElementById("tab3").style.opacity = "0.5";
    document.getElementById("tab3").style.height = "3vh";

    document.getElementById("journal").style.display = "none";
    document.getElementById("eventList").style.display = "none";
    document.getElementById("goalList").style.display = "block";

}


for(i = 0; i < userGoals.length; i++) {

    //if (userGoals[i].goalPeriod === "DAILY") {

        var goalName = userGoals[i].name;

        var goalDiv = document.createElement("div");

        goalDiv.innerHTML = goalName;
        goalDiv.style.background = '#4a94b7';
        goalDiv.style.color = '#0d0d0e';
        goalDiv.style.fontWeight = "bold";
        goalDiv.style.borderRadius = "3px"
        goalDiv.style.margin = "1em 0.5em 0.5em 1em";
        goalDiv.style.padding = "5px";
        goalDiv.style.textAlign = "center";

        document.getElementById("goalList").appendChild(goalDiv);
   // }
}