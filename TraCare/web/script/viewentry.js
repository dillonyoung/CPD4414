$(document).ready(function () {
    if ($('#map-canvas').length > 0) {
        var latitude = $('#latitude').val();
        var longitude = $('#longitude').val();

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
                    window.setTimeout(function () { window.location.href = 'entrylist.jsp'; }, 5000);
                }
            }
        });
    });
});

function showMap(latitude, longitude) {

    var latlon=latitude + "," + longitude;
    var img_url="http://maps.googleapis.com/maps/api/staticmap?center=" + latlon + "&zoom=16&size=600x200&" +
        "markers=color=blue%7Clabel:Position%7C" + latlon + "&sensor=true";
    $('#map-canvas').attr('src', img_url);
}