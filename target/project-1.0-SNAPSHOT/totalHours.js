function totalHours() {
    var total = parseInt(document.getElementById("p1").value) + parseInt(document.getElementById("p2").value) + parseInt(document.getElementById("p3").value) + parseInt(document.getElementById("p10").value) + parseInt(document.getElementById("p20").value) + parseInt(document.getElementById("p30").value);
    console.info("total: " + total);
        if(total > 40) {
        alert("The total hours cannot be more than 40 hrs");
        return false;
    }

}
