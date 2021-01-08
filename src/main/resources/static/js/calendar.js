var daysInMonth = document.getElementById('daysInMonth').innerText;

var dayOfMonth = document.getElementById('dayOfMonth').innerText;

var childDivs = document.getElementById('calendarGrid')
    .getElementsByTagName('div');

var userEvents = JSON.parse(document.getElementById("userEvents").innerText);

var userTasks = JSON.parse(document.getElementById("userTasks").innerText);

// iterate over calendar grid and assign dates according to number of days in month
for(i=1; i < childDivs.length; i++ ) {

    var divName = "day" + (i);

    if(i <= daysInMonth) {

        document.getElementById(divName).innerText = (i);

    }
    if(i == dayOfMonth) {

        document.getElementById(divName).style.background = '#FCFAF9';

        document.getElementById(divName).style.color = 'black';

        document.getElementById(divName).style.border = "thick solid #586994";

        var numberOfTaskCircle = document.createElement("div");

        numberOfTaskCircle.style.background = '#586994';
        numberOfTaskCircle.style.color = '#FCFAF9';
        numberOfTaskCircle.style.borderRadius = "50%";
        numberOfTaskCircle.style.width = "25px";
        numberOfTaskCircle.style.height = "25px";
        numberOfTaskCircle.style.marginBottom = "5em"
        numberOfTaskCircle.style.marginRight = "1.5em";
        numberOfTaskCircle.style.textAlign = "center";
        numberOfTaskCircle.innerText = userTasks.length;


        document.getElementById(divName).appendChild(numberOfTaskCircle);
    }
}
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
                eventNameForGrid.style.background = '#7a77a9';
                eventNameForGrid.style.fontSize = ".5em";
                eventNameForGrid.style.borderRadius = "10px 10px 10px 10px";
                eventNameForGrid.style.padding= "5px";
                eventNameForGrid.style.alignContent = "end";
                eventNameForGrid.style.display = "flex";
                eventNameForGrid.style.width = "100%";
                eventNameForGrid.style.marginTop = "20px";

                document.getElementById(day).appendChild(eventNameForGrid);

            }
        }
}

