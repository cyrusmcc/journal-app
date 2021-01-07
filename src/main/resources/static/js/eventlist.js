var userEvents = JSON.parse(document.getElementById("userEvents").innerText);
console.log(userEvents);

for(i = 0; i < userEvents.length; i++) {

    var eventName = userEvents[i].name;

    var eventDate = userEvents[i].eventDate;

    var eventDiv = document.createElement("div");

    eventDiv.innerHTML = eventName + " on " + eventDate;
    eventDiv.style.background = '#7a77a9';
    eventDiv.style.borderRadius = "10px 10px 10px 10px";
    eventDiv.style.margin = "1em";
    eventDiv.style.padding = "5px";
    eventDiv.style.border = "thin solid #FCFAF9";

    document.getElementById("eventList").appendChild(eventDiv);
}