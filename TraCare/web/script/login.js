$(document).ready(function () {
    $("#btn_login").on('click', function () {
        
        // Reset the error messages so they are not visible
        $('#error_email').css('display', 'none');
        $('#error_password').css('display', 'none');
        
        // Check to see if the email address is set and not valid
        var regex_email = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}/;
        if ($('#email').val().length == 0) {
            $('#error_email').text("* Email address is required");
            $('#error_email').css('display', 'inline-block');
        } else if (!regex_email.test($('#email').val())) {
            $('#error_email').text("* Email address is not valid");
            $('#error_email').css('display', 'inline-block');
        }
        
        // Check to see if the password1 is set
        if ($('#password').val().length == 0) {
            $('#error_password').text("* Password is required");
            $('#error_password').css('display', 'inline-block');
        }

        // Get the count of errors displayed and the total possible error count
        var error_count = $('span.error').filter(":hidden").size();
        var form_count = $('span.error').size();

        // Check to see if there are no errors displayed
        if (error_count == form_count) {
            
            // Create an object for the registration
            var loginData = new Object();
            loginData.email = $('#email').val();
            loginData.password = $('#password').val();

            // Convert the object to JSON
            var query = JSON.stringify(loginData);

            $.ajax({
                type: "POST",
                url: "login_process.jsp",
                dataType: "json",
                data: { json: query },
                success: function (data) {
                    var response = data;

                    // Check to see if an internal error occurred
                    if (response.status == -2) {
                        displayMessage("An internal error has occurred", 2);
                        
                    // Check to see if the login failed
                    } else if (response.status == -1) {
                        displayMessage("The email address or password are invalid", 2);
                        
                    } else {
                        displayMessage("You have been successfully logged in, please wait while you are redirected", 1);
                        window.setTimeout(function () { window.location.href = 'entrylist.jsp'; }, 5000);
                    }
                }
            });
        } else {
            
            displayMessage("There is an issue with one or more fields", 2);
        }
    });
});
