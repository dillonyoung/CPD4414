$(document).ready(function () {
    $("#btn_reg2ister").on('click', function () {
       $.mobile.changePage($('register.jsp'), 'pop', false, true);
    });
    var activePage = $.mobile.activePage[0].id;
alert(activePage);

});