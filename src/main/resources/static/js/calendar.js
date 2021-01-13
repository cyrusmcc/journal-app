var daysInMonth = document.getElementById('daysInMonth').innerText;

var dayOfMonth = document.getElementById('dayOfMonth').innerText;

var childDivs = document.getElementById('calendarGrid')
    .getElementsByTagName('div');

var userEvents = JSON.parse(document.getElementById("unfinishedDailyUserTasks").innerText);

var activeUserTasks = 0;

for(i = 0; i < userTasks.length; i++) {
    if(userTasks[i].finished === false) {
        activeUserTasks += 1;
    }
}

// iterate over calendar grid and assign dates according to number of days in month
for(i=1; i < childDivs.length; i++ ) {

    var dateNumber = "dateNumber" + (i);

    var dayGridBox = "day" + (i);

    if(i <= daysInMonth) {

        document.getElementById(dateNumber).innerText = (i);
        document.getElementById(dateNumber).style.margin = ".5em";

    }
    if(i == dayOfMonth) {

        document.getElementById(dayGridBox).style.background = '#FCFAF9';

        document.getElementById(dateNumber).style.color = 'black';

        document.getElementById(dayGridBox).style.border = "thick solid #586994";

        // display task bubble on current date
        if(activeUserTasks > 0) {

            console.log(activeUserTasks);
        var numberOfTaskCircle = document.createElement("div");

        numberOfTaskCircle.style.gridArea = "grid-area: 1 / 1 / 3 / 3";
        numberOfTaskCircle.style.textAlign = "center";
        numberOfTaskCircle.style.lineHeight = ""
        numberOfTaskCircle.style.margin = ".5em";
        numberOfTaskCircle.style.background = '#586994';
        numberOfTaskCircle.style.color = '#FCFAF9';
        numberOfTaskCircle.style.borderRadius = "50%";
        numberOfTaskCircle.style.width = "20px";
        numberOfTaskCircle.style.height = "20px";
        numberOfTaskCircle.innerText = activeUserTasks;

        document.getElementById(dayGridBox).appendChild(numberOfTaskCircle);
        }
    }
}

    // display event bubbles on calendar
    for (var i = 0; i < userEvents.length; i++) {

        var eventDate = new Date(userEvents[i].eventDate);

        var currentDate = new Date();

        if (userEvents[i].eventStatus === "FUTURE") {
            if (eventDate.getFullYear() == currentDate.getFullYear()
                && eventDate.getMonth() == currentDate.getMonth()) {

                var day = "day" + (eventDate.getDate() + 1);

                var eventName = userEvents[i].name;

                var eventNameForGrid = document.createElement("div");
                eventNameForGrid.innerText = eventName;

                eventNameForGrid.style.gridArea = "4 / 2 / 5 / 8";
                eventNameForGrid.style.background = '#7a77a9';
                eventNameForGrid.style.marginBottom = "1em";
                eventNameForGrid.style.fontSize = ".5em";
                eventNameForGrid.style.borderRadius = "10px 10px 10px 10px";
                eventNameForGrid.style.padding = "5px";

                document.getElementById(day).appendChild(eventNameForGrid);

            }
        }
}
