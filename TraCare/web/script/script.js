$(document).ready(function () {
    $("#btn_register").on('click', function () {
       $.mobile.changePage($('register.jsp'), 'pop', false, true);
    });
    var activePage = $.mobile.activePage[0].id;

});