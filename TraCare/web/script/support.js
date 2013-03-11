function displayMessage(message, state) {
    $('#status_message').html(message);
    if (state == 1) {
        $('#status_message').attr('class', 'status_message_valid');
    } else if (state == 2) {
        $('#status_message').attr('class', 'status_message_invalid');
    } else if (state == 3) {
        $('#status_message').attr('class', 'status_message_warn');
    }
    $('#status_message').fadeIn(500).delay(3000).fadeOut(500);
}