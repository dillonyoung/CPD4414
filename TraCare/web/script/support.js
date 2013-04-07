$(document).ready(function () {
    
    // Get the login status of the current user
    $.getJSON('login_status.jsp', function (result) {

        // Check to see if the user is logged in or not
        if (result.status == 0) {

        } else if (result.status == 1) {

            // Display the user name
            $('#login-data').html("Hello, " + result.firstname);
        } else {
            
            //redirectUser('index.jsp');
        }

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