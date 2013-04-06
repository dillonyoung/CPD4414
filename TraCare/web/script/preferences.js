$(document).ready(function () {
    
    // Register a change listener on the weight slider
    $("#weight").on('change', function () {
        var value = $(this).val() / 10;
        $('#weight-display').html(value + " Lbs");
    });
    
    // register a click listener for the save preferences button
    $('#btn_save').on('click', function () {
        
        // Create a new request object
        var prefData = new Object();
        prefData.userID = -1;
        prefData.trackWeight = $('#slideWeight').val();
        prefData.trackSleep = $('#slideSleep').val();
        prefData.trackBloodPressure = $('#slideBloodPressure').val();
        prefData.trackEnergyLevel = $('#slideEnergyLevel').val();
        prefData.trackQualityofSleep = $('#slideQualityofSleep').val();
        prefData.trackFitness = $('#slideFitness').val();
        prefData.trackNutrition = $('#slideNutrition').val();
        prefData.trackSymptom = $('#slideSymptom').val();
        prefData.trackLocation = $('#slideLocation').val();
        
        
        // Convert the object to json
        var query = JSON.stringify(prefData);

        // Attempt to submit the preferences
        $.ajax({
            type: "POST",
            url: "preferences_process.jsp",
            dataType: "json",
            data: { json: query },
            success: function (data) {

                // Get the reponse data
                var response = data;

                // Check to see if there was an error
                if (response.status <= 0) {
                    displayMessage("An error occurred while saving your preferences", 2);

                } else {
                    displayMessage("Your preferences have been saved", 1);
                }
            }
        });
    });
});