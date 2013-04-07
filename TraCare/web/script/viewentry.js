$(document).ready(function () {
    if ($('#map-canvas').length > 0) {
        var latitude = $('#latitude').val();
        var longitude = $('#longitude').val();
        console.log(latitude);
        console.log(longitude);
        showMap(latitude, longitude);
    }
});

function showMap(latitude, longitude) {

    var latlon=latitude + "," + longitude;
    var img_url="http://maps.googleapis.com/maps/api/staticmap?center=" + latlon + "&zoom=16&size=600x200&" +
        "markers=color=blue%7Clabel:Position%7C" + latlon + "&sensor=true";
    $('#map-canvas').attr('src', img_url);
}