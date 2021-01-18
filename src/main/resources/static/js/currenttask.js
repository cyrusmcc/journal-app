const selected = document.querySelector("#selectedTask");
const optionsContainer = document.querySelector(".optionsContainer");

const optionsList = document.querySelectorAll(".option");

if(theCurrentTask == null) {

    document.getElementById("noCurrentTask").style.display = "block";

} else if(theCurrentTask != null) {

    document.getElementById("noCurrentTask").style.display = "none";

}

selected.addEventListener("click", () => {
    optionsContainer.classList.toggle("active");
})

optionsList.forEach( o => {
    o.addEventListener("click", () => {
        selected.innerHTML = o.querySelector("label").innerHTML;
        optionsContainer.classList.remove("active");
    })
})


