

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