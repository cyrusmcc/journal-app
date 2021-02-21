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
        eventDiv.style.margin = "0 0.5em 1em";
        eventDiv.style.padding = "5px";

        document.getElementById("eventListContents").appendChild(eventDiv);
    }
}