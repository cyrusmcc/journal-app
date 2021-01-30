var userEvents = JSON.parse(document.getElementById("userEvents").innerText);


for(i = 0; i < userEvents.length; i++) {

    if (userEvents[i].eventStatus === "FUTURE") {

        var eventName = userEvents[i].name;

        var eventDate = userEvents[i].eventDate;

        var eventDiv = document.createElement("div");

        eventDiv.innerHTML = eventName + " on " + eventDate;
        eventDiv.style.background = '#9a7092';
        eventDiv.style.color = '#fbf7f4';
        eventDiv.style.borderRadius = "6px 6px 6px 6px";
        eventDiv.style.margin = "0 0.5em 0.3em";
        eventDiv.style.padding = "5px";
        eventDiv.style.border = "medium solid #FCFAF9";

        document.getElementById("eventListContents").appendChild(eventDiv);
    }
}