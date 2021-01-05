var localDate = document.getElementById('userLocalDate').innerText;

var month = document.getElementById('month').innerText;

var daysInMonth = document.getElementById('daysInMonth').innerText;

var dayOfMonth = document.getElementById('dayOfMonth').innerText;

var childDivs = document.getElementById('calendarGrid')
    .getElementsByTagName('div');

var userEvents = JSON.parse(document.getElementById("userEvents").innerText);

for(i=1; i < childDivs.length; i++ ) {
    var divName = "day" + (i);

    if(i <= daysInMonth) {
        document.getElementById(divName).innerText = (i);
    }
    if(i == dayOfMonth) {

        document.getElementById(divName).style.background = '#E0E1DD';

        document.getElementById(divName).style.color = 'black';

        document.getElementById(divName).style.border = "thick solid #778DA9";

    }
    if(i > daysInMonth && i <= 35) {

        var divNameOverDays = "day" + (i);

        document.getElementById(divNameOverDays).style.background = 'black';
    }
}
    for (var i = 0; i < userEvents.length; i++) {

        var eventDate = new Date(userEvents[i].eventDate);

        var currentDate = new Date();

        /* for testing purposes, to be removed

        console.log("event date: " + eventDate + " " + eventDate.getDay());

        console.log("event year: " + eventDate.getFullYear() +
            " current year: " + currentDate.getFullYear() +
            " event month: " + eventDate.getMonth() +
            " current month: " + currentDate.getMonth() +
            " event day: " + eventDate.getDay())

         */

        if (userEvents[i].eventStatus === "FUTURE") {
            if (eventDate.getFullYear() == currentDate.getFullYear()
                && eventDate.getMonth() == currentDate.getMonth()) {

                var day = "day" + (eventDate.getDate() + 1);

                var eventInfo = "eventInfo" + (eventDate.getDate() + 1);

                var eventName = userEvents[i].name;

                document.getElementById(day).style.background = '#415A77';

                if(eventName != null) {
                    document.getElementById(day).style.background = eventName;
                }
            }
        }
}

