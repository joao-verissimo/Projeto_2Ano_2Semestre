function submitLoginForm(event) {
    event.preventDefault(); // Prevent form submission

    // Get the form values
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Make an AJAX request to the server for login validation
    var request = new XMLHttpRequest();
    request.onload = function() {
        if (request.status === 200) {
            // Successful login
            document.getElementById("loginForm").style.display = "none";
            refreshBoard(username); // Pass the username to the refreshBoard function
            document.getElementById("votes").style.display = "block";
        } else {
            // Invalid login
            alert("Invalid username or password. Please try again.");
        }
    };
    request.open("POST", "/login", true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify({ username: username, password: password }));
}
