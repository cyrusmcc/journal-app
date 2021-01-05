var localDate = document.getElementById('userLocalDate').innerText;
console.log("User's local date: "  + localDate)

var month = document.getElementById('month').innerText;
console.log(month)

var daysInMonth = document.getElementById('daysInMonth').innerText;
console.log("Days in month: " + daysInMonth)

var dayOfMonth = document.getElementById('dayOfMonth').innerText;
console.log("Day of month: "  + dayOfMonth)

var childDivs = document.getElementById('calendarGrid')
    .getElementsByTagName('div');

var userEvents = JSON.parse(document.getElementById("userEvents").innerText);
console.log(userEvents);

for(i=1; i < childDivs.length; i++ ) {
    var divName = "day" + (i);

    if(i <= daysInMonth) {
        document.getElementById(divName).innerText = (i);
    }
    if(i == dayOfMonth) {
        document.getElementById(divName).style.background = 'red';
    }
    if(i > daysInMonth && i <= 35) {
        console.log(i)
        var divNameOverDays = "day" + (i);
        console.log(divNameOverDays)

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

                document.getElementById(day).style.background = 'blue';
            }
        }
}

