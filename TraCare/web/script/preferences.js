// Dialog opened 
$('#preferences').on("pageshow", function() {
	alert("Opened");
});

// Dialog closed 
$('#myDialog').on("pagehide", function() {
	alert("Closed");
});

$(document).ready(function () {
    $('#preferences').css('height', 300);
});