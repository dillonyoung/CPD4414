/* 
    Document...: summary.js
    Author.....: Dillon Young
    Description: The javascript file for the summary process
*/

$(document).ready(function () {

    // Register the click listner for the run summary button
    $("#btn_runsummary").on('click', function () {
        
        // Reset the error messages so they are not visible
        $('#error_start_date').css('display', 'none');
        $('#error_end_date').css('display', 'none');
        
        // Check to ensure a start date has been selected
        if ($('#start_date').val() == "") {
            $('#error_start_date').text("* Start date is required");
            $('#error_start_date').css('display', 'inline-block');
        }
        
        // Check to ensure an end date has been selected
        if ($('#end_date').val() == "") {
            $('#error_end_date').text("* End date is required");
            $('#error_end_date').css('display', 'inline-block');
        }
        
        // Get the count of errors displayed and the total possible error count
        var error_count = $('span.error').filter(":hidden").size();
        var form_count = $('span.error').size();

        // Check to see if there are no errors displayed
        if (error_count == form_count) {
        
            // Build the request
            var request = "report.jsp?start=" + $('#start_date').val() +
                "&end=" + $('#end_date').val();
            
            redirectUser(request);
        } else {
            displayMessage("There is an issue with one or more fields", 2);
        }
    });
});

function showMap(latitude, longitude) {

    var latlon=latitude + "," + longitude;
    var img_url="http://maps.googleapis.com/maps/api/staticmap?center=" + latlon + "&zoom=16&size=600x200&" +
        "markers=color=blue%7Clabel:Position%7C" + latlon + "&sensor=true";
    $('#map-canvas').attr('src', img_url);
}