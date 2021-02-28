var dayOfMonth = document.getElementById('dayOfMonth').innerText;

var daysInMonth = document.getElementById('daysInMonth').innerText;

var month = document.getElementById('month').innerText;

var childDivs = document.getElementById('calendarGrid')
    .getElementsByTagName('div');

var userEvents = JSON.parse(document.getElementById("userEvents").innerText);

var d = new Date();

var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September",
              "October", "November", "December"];

var calendarTitle = days[d.getDay()] + ", " + months[d.getMonth()] + " " + dayOfMonth + ", " + d.getFullYear();
document.getElementById('dateDisplay').innerText = calendarTitle;

var activeUserGoals = 0;

for(i = 0; i < userGoals.length; i++) {
    if(userGoals[i].finished === false) {
        activeUserGoals += 1;
    }
}

// iterate over calendar grid and assign dates according to number of days in month
for(i=1; i < childDivs.length; i++ ) {

    var dateNumber = "dateNumber" + (i);

    var dayGridBox = "day" + (i);

    if(i <= daysInMonth) {

        document.getElementById(dayGridBox).style.position = "relative";

        document.getElementById(dateNumber).innerText = (i);
        document.getElementById(dateNumber).style.fontSize = ".7em";
        document.getElementById(dateNumber).style.color = "#fbf7f4";
        document.getElementById(dateNumber).style.width = "fit-content";
        document.getElementById(dateNumber).style.float = "right";
        document.getElementById(dateNumber).style.margin = "0.3em";

    }

    if(i < dayOfMonth) {
        document.getElementById(dayGridBox).style.background = "#1b1b1b";
    }

    if(i == dayOfMonth) {

        // display goal bubble on current date
        if(activeUserGoals > 0) {

            var numberOfGoalCircle = document.createElement("div");

            numberOfGoalCircle.style.justifySelf = "flex-start";
            numberOfGoalCircle.style.gridArea = "grid-area: 1 / 1 / 3 / 3";
            numberOfGoalCircle.style.textAlign = "center";
            numberOfGoalCircle.style.marginBottom = "1em";
            numberOfGoalCircle.style.background = '#fbf7f4';
            numberOfGoalCircle.style.color = '#1b1b1b';
            numberOfGoalCircle.style.borderRadius = "50%";
            numberOfGoalCircle.style.fontSize = ".8em";
            numberOfGoalCircle.style.fontWeight = "bold";
            numberOfGoalCircle.style.width = "1.2em";
            numberOfGoalCircle.style.height = "1.2em";
            numberOfGoalCircle.style.margin = "0.3em";
            numberOfGoalCircle.style.paddingBottom = "0.15em";
            numberOfGoalCircle.innerText = activeUserGoals;

            document.getElementById(dayGridBox).appendChild(numberOfGoalCircle);
        }

        document.getElementById(dayGridBox).style.background = '#4a94b7';

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

                eventNameForGrid.style.position = "absolute";
                eventNameForGrid.style.bottom = "0";
                eventNameForGrid.style.right = "0";
                eventNameForGrid.style.left = "0";
                eventNameForGrid.style.width = "85%";
                eventNameForGrid.style.margin = "auto";
                eventNameForGrid.style.marginBottom = "0.3em";

                eventNameForGrid.style.background = '#9a7092';
                eventNameForGrid.style.color = '#fbf7f4';
                eventNameForGrid.style.fontSize = ".5em";
                eventNameForGrid.style.borderRadius = "8px";
                eventNameForGrid.style.padding = "2px";
                eventNameForGrid.style.textAlign = "center";
                eventNameForGrid.style.maxHeight = "3em";
                eventNameForGrid.style.overflow = "hidden";
                eventNameForGrid.style.wordBreak = "break-word";

                document.getElementById(day).appendChild(eventNameForGrid);

            }
        }
}
