$(document).ready(function () {
    
    // Get the login status of the current user
    $.getJSON('login_status.jsp', function (result) {

        // Check to see if the user is logged in or not
        if (result.status == 0) {

        } else if (result.status == 1) {

            // Display the user name
            $('#login-data').html("Welcome, " + result.firstname);
        } else {
            
            //redirectUser('index.jsp');
        }

    });


    // Register the click listner for the logout button
    $("#btn_logout").on('click', function () {
        
        // Create an object for the registration
        var entryData = new Object();
        entryData.status = 0;
        entryData.userid = 0;
        entryData.firstname = "";

        // Convert the object to JSON
        var query = JSON.stringify(entryData);

        $.ajax({
            type: "POST",
            url: "logout_process.jsp",
            dataType: "json",
            data: { json: query },
            success: function (data) {
                var response = data;

                // Check to see if an internal error occurred
                if (response.status == -1) {
                    displayMessage("An error occurred while logging you out", 2);

                } else {
                    displayMessage("You have been successfully logged out, please wait while you are redirected", 1);
                    window.setTimeout(function () { window.location.href = 'index.jsp'; }, 5000);
                }
            }
        });
    });
});

function displayMessage(message, state) {
    $('#status_message').html(message);
    if (state == 1) {
        $('#status_message').attr('class', 'status_message_valid');
    } else if (state == 2) {
        $('#status_message').attr('class', 'status_message_invalid');
    } else if (state == 3) {
        $('#status_message').attr('class', 'status_message_warn');
    }
    $('#status_message').fadeIn(500).delay(3000).fadeOut(500);
}


function redirectUser(url) {
    window.location.href = url;
}