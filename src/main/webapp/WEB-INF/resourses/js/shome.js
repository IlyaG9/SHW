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
    window.location.href="./registration";
    });
    $('#logout').click(function() {
    window.location.href="./logout";
    });
});
