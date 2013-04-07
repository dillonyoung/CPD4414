$(document).ready(function () {
    
    // Register the click listner for the register button
    $("#btn_register").on('click', function () {
        
        // Reset the error messages so they are not visible
        $('#error_first_name').css('display', 'none');
        $('#error_last_name').css('display', 'none');
        $('#error_gender').css('display', 'none');
        $('#error_weight').css('display', 'none');
        $('#error_height').css('display', 'none');
        $('#error_email').css('display', 'none');
        $('#error_password1').css('display', 'none');
        $('#error_password2').css('display', 'none');
        
        // Check to see if the first name is set
        if ($('#first_name').val().length == 0) {
            $('#error_first_name').text("* First name is required");
            $('#error_first_name').css('display', 'inline-block');
        }
        
        // Check to see if the last name is set
        if ($('#last_name').val().length == 0) {
            $('#error_last_name').text("* Last name is required");
            $('#error_last_name').css('display', 'inline-block');
        }
        
        // Check to see if the gender is set
        if ($('#gender').val().length == 0) {
            $('#error_gender').text("* Gender is required");
            $('#error_gender').css('display', 'inline-block');
        }

        // Check to see if the weight is set and is numeric
        if ($('#weight').val().length == 0) {
            $('#error_weight').text("* Weight is required");
            $('#error_weight').css('display', 'inline-block');
        } else if (isNaN($('#weight').val())) {
            $('#error_weight').text("* Weight must be a numeric value");
            $('#error_weight').css('display', 'inline-block');
        }
        
        // Check to see if the height is set and is numeric
        if ($('#height').val().length == 0) {
            $('#error_height').text("* Height is required");
            $('#error_height').css('display', 'inline-block');
        } else if (isNaN($('#height').val())) {
            $('#error_height').text("* Height must be a numeric value");
            $('#error_height').css('display', 'inline-block');
        }
        
        // Check to see if the email address is set and not valid
        var regex_email = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}/;
        if ($('#email').val().length == 0) {
            $('#error_email').text("* Email address is required");
            $('#error_email').css('display', 'inline-block');
        } else if (!regex_email.test($('#email').val())) {
            $('#error_email').text("* Email address is not valid");
            $('#error_email').css('display', 'inline-block');
        }
        
        // Check to see if the passwords match
        if ($('#password1').val() != $('#password2').val()) {
            $('#error_password1').text("* Passwords do not match");
            $('#error_password1').css('display', 'inline-block');
            $('#error_password2').text("* Passwords do not match");
            $('#error_password2').css('display', 'inline-block');
        }
        
        // Check to see if the password1 is set
        if ($('#password1').val().length == 0) {
            $('#error_password1').text("* Password is required");
            $('#error_password1').css('display', 'inline-block');
        }

        // Check to see if the password2 is set
        if ($('#password2').val().length == 0) {
            $('#error_password2').text("* Password is required");
            $('#error_password2').css('display', 'inline-block');
        }

        // Get the count of errors displayed and the total possible error count
        var error_count = $('span.error').filter(":hidden").size();
        var form_count = $('span.error').size();

        // Check to see if there are no errors displayed
        if (error_count == form_count) {
            
            // Create an object for the registration
            var registerData = new Object();
            registerData.first_name = $('#first_name').val();
            registerData.last_name = $('#last_name').val();
            registerData.gender = $('#gender').val();
            registerData.weight = $('#weight').val();
            registerData.height = $('#height').val();
            registerData.email = $('#email').val();
            registerData.password = $('#password1').val();

            // Convert the object to JSON
            var query = JSON.stringify(registerData);

            $.ajax({
                type: "POST",
                url: "register_process.jsp",
                dataType: "json",
                data: { json: query },
                success: function (data) {
                    var response = data;

                    // Check to see if the email address has already been registered
                    if (response.status == -3) {
                        $('#error_email').text("* Email address has already been registered");
                        $('#error_email').css('display', 'inline-block');
                        displayMessage("Email address has already been registered", 2);
                        
                    // Check to see if an internal error occurred
                    } else if (response.status == -2) {
                        displayMessage("An error occurred while registering", 2);
                        
                    // Check to see if the user could not be added
                    } else if (response.status == -1 || response.status == 0) {
                        displayMessage("An error occurred while registering", 2);
                        
                    } else {
                        displayMessage("Your have successfully registered", 1);
                    }
                }
            });
        } else {
            
            displayMessage("There is an issue with one or more fields", 2);
        }
    });
    
        console.log($("#btn_register"));
});
