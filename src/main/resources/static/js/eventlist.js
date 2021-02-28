
function onClickEventList() {

    document.getElementById("tab1").style.opacity = "0.5";
    document.getElementById("tab1").style.height = "3vh";

    document.getElementById("tab2").style.opacity = "0.5";
    document.getElementById("tab2").style.height = "3vh";

    document.getElementById("tab3").style.opacity = "1";
    document.getElementById("tab3").style.height = "4vh";

    document.getElementById("journal").style.display = "none";
    document.getElementById("goalList").style.display = "none";
    document.getElementById("eventList").style.display = "block";

}

var userEvents = JSON.parse(document.getElementById("userEvents").innerText);

for(i = 0; i < userEvents.length; i++) {

    if (userEvents[i].eventStatus === "FUTURE") {

        var eventName = userEvents[i].name;

        var eventDate = userEvents[i].eventDate;

        var eventDiv = document.createElement("div");

        eventDiv.innerHTML = eventName + " on " + eventDate;
        eventDiv.style.background = '#9a7092';
        eventDiv.style.color = '#0d0d0e';
        eventDiv.style.fontWeight = "bold";
        eventDiv.style.borderRadius = "3px"
        eventDiv.style.margin = "1em 0.5em 0.5em 1em";
        eventDiv.style.padding = "5px";
        eventDiv.style.textAlign = "center";

        document.getElementById("eventList").appendChild(eventDiv);
    }
}