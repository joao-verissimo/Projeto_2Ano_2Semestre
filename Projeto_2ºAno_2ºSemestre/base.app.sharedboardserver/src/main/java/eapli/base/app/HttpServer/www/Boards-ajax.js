function refreshBoard(username) {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("votes");

    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "black";
        setTimeout(function () {
            refreshBoard(username);
        }, 2000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(function () {
            refreshBoard(username);
        }, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(function () {
            refreshBoard(username);
        }, 5000);
    };

    var url = "/board";
    var requestBody = "username=" + encodeURIComponent(username);

    request.open("POST", url, true);
    request.timeout = 5000;
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(requestBody);
}
