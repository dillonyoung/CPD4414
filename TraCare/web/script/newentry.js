$(document).ready(function () {
    if ($('#map-canvas').length > 0) {
        if (navigator.geolocation)
        {
            navigator.geolocation.getCurrentPosition(showPosition);
        }
    }

    // Register the click listner for the add entry button
    $("#btn_addentry").on('click', function () {
        console.log('yes');
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