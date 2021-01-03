var month = document.getElementById('month').innerText;
console.log(month)

var daysInMonth = document.getElementById('daysInMonth').innerText;
console.log("Days in month: " + daysInMonth)

var dayOfMonth = document.getElementById('dayOfMonth').innerText;
console.log("Day of month: "  + dayOfMonth)

var childDivs = document.getElementById('calendar')
    .getElementsByTagName('div');

console.log("OUTSIDE FOR LOOP")
for(i=0; i< childDivs.length; i++ )
{
    console.log("INSIDE FOR LOOP")
    var childDiv = childDivs[i];
    console.log(childDiv)

    if(i < daysInMonth) {
        console.log("INSIDE IF LOOP" + i)
        var divName = "day" + (i + 1);
        console.log(divName)
        document.getElementById(divName).innerText = (i + 1);

        if(i == dayOfMonth) {
            document.getElementById(divName).style.background = 'blue';
        }

    }

}

