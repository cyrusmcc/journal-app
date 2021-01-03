var localDate = document.getElementById('userLocalDate').innerText;
console.log("User's local date: "  + localDate)

var month = document.getElementById('month').innerText;
console.log(month)

var daysInMonth = document.getElementById('daysInMonth').innerText;
console.log("Days in month: " + daysInMonth)

var dayOfMonth = document.getElementById('dayOfMonth').innerText;
console.log("Day of month: "  + dayOfMonth)

var childDivs = document.getElementById('calendar')
    .getElementsByTagName('div');

console.log("OUTSIDE FOR LOOP")
for(i=1; i < childDivs.length; i++ ) {
    console.log("INSIDE FOR LOOP")
    var childDiv = childDivs[i];
    console.log(childDiv)

    if(i <= daysInMonth) {
        console.log("INSIDE IF LOOP" + i)
        var divName = "day" + (i);
        console.log(divName)
        document.getElementById(divName).innerText = (i);

        if(i == dayOfMonth) {
            document.getElementById(divName).style.background = 'red';
            console.log("Day of month set: " + dayOfMonth)
        }
    }
}

