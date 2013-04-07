$(document).ready(function () {
    if ($('#map-canvas').length > 0) {
        if (navigator.geolocation)
        {
            navigator.geolocation.getCurrentPosition(showPosition);
        }
    }

    // Register the click listner for the add entry button
    $("#btn_addentry").on('click', function () {
        
        // Reset the error messages so they are not visible
        $('#error_weight').css('display', 'none');
        $('#error_sleep').css('display', 'none');
        $('#error_energy_level').css('display', 'none');
        $('#error_quality_of_sleep').css('display', 'none');
        $('#error_fitness').css('display', 'none');
        $('#error_nutrition').css('display', 'none');
        $('#error_symptom').css('display', 'none');
        $('#error_location').css('display', 'none');
        
        // Check to see if weight is being tracked for this entry
        if ($('#weight').length > 0) {
            
            // Check to see if the weight is set and is numeric
            if ($('#weight').val().length == 0) {
                $('#error_weight').text("* Weight is required and must be a numeric value");
                $('#error_weight').css('display', 'inline-block');
            } else if (isNaN($('#weight').val())) {
                $('#error_weight').text("* Weight must be a numeric value");
                $('#error_weight').css('display', 'inline-block');
            }
        }
        
        // Check to see if sleep is being tracked for this entry
        if ($('#sleep').length > 0) {
            
            // Check to see if the sleep is set and is numeric
            if ($('#sleep').val().length == 0) {
                $('#error_sleep').text("* Sleep is required and must be a numeric value");
                $('#error_sleep').css('display', 'inline-block');
            } else if (isNaN($('#weight').val())) {
                $('#error_sleep').text("* Sleep must be a numeric value");
                $('#error_sleep').css('display', 'inline-block');
            }
        }
        
        // Check to see if fitness activity is being tracked for this entry
        if ($('#fitness').length > 0) {
            
            // Check to see if a value has been entered
            if ($('#fitness').val().length == 0) {
                $('#error_fitness').text("* Please enter a description of your fitness activity");
                $('#error_fitness').css('display', 'inline-block');
            }
        }
        
        // Check to see if nutrition is being tracked for this entry
        if ($('#nutrition').length > 0) {
            
            // Check to see if a value has been entered
            if ($('#nutrition').val().length == 0) {
                $('#error_nutrition').text("* Please enter a description of your nutrition");
                $('#error_nutrition').css('display', 'inline-block');
            }
        }
        
        
        // Get the count of errors displayed and the total possible error count
        var error_count = $('span.error').filter(":hidden").size();
        var form_count = $('span.error').size();

        // Check to see if there are no errors displayed
        if (error_count == form_count) {
            
            // Create an object for the registration
            var newEntryData = new Object();
            newEntryData.weight = -1;
            newEntryData.sleep = -1;
            newEntryData.bloodpressure = -1;
            newEntryData.energylevel = -1;
            newEntryData.qualityofsleep = -1;
            newEntryData.fitness = "<{[blank]}>";
            newEntryData.nutrition = "<{[blank]}>";
            newEntryData.symptom = -1;
            newEntryData.symptomdescription = "<{[blank]}>";
            newEntryData.latitude = 0;
            newEntryData.longitude = 0;
            
            // Get the values entered by the user
            if ($('#weight').length > 0) { newEntryData.weight = $('#weight').val(); }
            if ($('#sleep').length > 0) { newEntryData.sleep = $('#sleep').val(); }
            if ($('#energy_level').length > 0) { newEntryData.energylevel = $('#energy_level').val(); }
            if ($('#quality_of_sleep').length > 0) { newEntryData.qualityofsleep = $('#quality_of_sleep').val(); }
            if ($('#fitness').length > 0) { newEntryData.fitness = $('#fitness').val(); }
            if ($('#nutrition').length > 0) { newEntryData.nutrition = $('#nutrition').val(); }
            if ($('#symptom').length > 0) { newEntryData.symptom = $('#symptom').val(); }
            if ($('#symptom_description').length > 0) { newEntryData.symptomdescription = $('#symptom_description').val(); }
            if ($('#latitude').length > 0) { newEntryData.latitude = $('#latitude').val(); }
            if ($('#longitude').length > 0) { newEntryData.longitude = $('#longitude').val(); }

            // Convert the object to JSON
            var query = JSON.stringify(newEntryData);

            $.ajax({
                type: "POST",
                url: "newentry_process.jsp",
                dataType: "json",
                data: { json: query },
                success: function (data) {
                    var response = data;

                    console.log(response.status);
                        
                    // Check to see if an internal error occurred
                    if (response.status == -2) {
                        displayMessage("An error occurred while saving the entry", 2);
                        
                    } else {
                        displayMessage("The entry has been successfully saved, please wait while you are redirected", 1);
                    }
                }
            });
        } else {
            
            displayMessage("There is an issue with one or more fields", 2);
        }
    });
});

function showPosition(position) {

    var latlon=position.coords.latitude + "," + position.coords.longitude;
    var img_url="http://maps.googleapis.com/maps/api/staticmap?center=" + latlon + "&zoom=16&size=600x200&" +
        "markers=color=blue%7Clabel:Position%7C" + latlon + "&sensor=true";
    $('#map-canvas').attr('src', img_url);
    $('#latitude').val(position.coords.latitude);
    $('#longitude').val(position.coords.longitude);
}