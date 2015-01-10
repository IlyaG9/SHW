$(document).ready(function() {
    $('.popup .close_window, .overlay').click(function() {
        $('.popup, .overlay').css('opacity', '0');
        $('.popup, .overlay').css('visibility', 'hidden');
    });
    $('#signin').click(function(e) {
        $('.popup, .overlay').css('opacity', '1');
        $('.popup, .overlay').css('visibility', 'visible');
        e.preventDefault();
    });
    $('#registartion').click(function() {
        window.location.href = "./registration";
    });
    $('#logout').click(function() {
        window.location.href = "./logout";
    });

    var userAgent = navigator.userAgent;
    if (userAgent.search(/Chrome/) > 0 || userAgent.search(/Firefox/) > 0) {
    } else {
          $('#webcam').html("<h3>Веб камера доступна в браузерах Google Chrome‎, Mozilla Firefox, Opera</h3>");
    }
    if (navigator.userAgent.match(/Android/i) || navigator.userAgent.match(/BlackBerry/i) || navigator.userAgent.match(/iPhone|iPad|iPod/i) || navigator.userAgent.match(/Opera Mini/i) || navigator.userAgent.match(/IEMobile/i)) {
        $('#href-webcam').hide();
        $('#menu nav').removeClass('navbar navbar-inverse navbar-fixed-top');
        $('#webcam').html("<h1>Веб камера не доступна для мобильных устройств</h1>");
    }
});
