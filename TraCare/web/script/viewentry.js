/* 
    Document...: viewentry.js
    Author.....: Dillon Young
    Description: The javascript file for the view entry process
*/

$(document).ready(function () {
    
    // Check to see if the map canvas should be shown
    if ($('#map-canvas').length > 0) {
        
        // Get the latitude and longitude values
        var latitude = $('#latitude').val();
        var longitude = $('#longitude').val();

        // Show the location on a static Google map
        showMap(latitude, longitude);
    }
    
    // Register the click listner for the delete button
    $("#btn_deleteentry").on('click', function () {
        
        // Create an object for the registration
        var entryData = new Object();
        entryData.status = $('#pageid').val();
        entryData.userid = 0;
        entryData.firstname = "";

        // Convert the object to JSON
        var query = JSON.stringify(entryData);

        // Attempt to delete the selected entry
        $.ajax({
            type: "POST",
            url: "delete_process.jsp",
            dataType: "json",
            data: { json: query },
            success: function (data) {
                var response = data;

                // Check to see if an internal error occurred
                if (response.status == -2) {
                    displayMessage("An error occurred while deleting the entry", 2);

                } else {
                    displayMessage("The entry has been successfully deleted, please wait while you are redirected", 1);
                    window.setTimeout(function () { window.location.href = 'entrylist.jsp'; }, 3000);
                }
            }
        });
    });
});


/**
 * Shows the location on a static Google map
 */
function showMap(latitude, longitude) {

    // Declare variables
    var latlon=latitude + "," + longitude;
    var img_url="http://maps.googleapis.com/maps/api/staticmap?center=" + latlon + "&zoom=16&size=600x200&" +
        "markers=color=blue%7Clabel:Position%7C" + latlon + "&sensor=true";
    
    // Update the image URL
    $('#map-canvas').attr('src', img_url);
}