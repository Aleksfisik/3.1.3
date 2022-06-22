$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');


            $.get(href, function (user, status) {
                $('.myForm #id').val(user.id);
                $('.myForm #name').val(user.name);
                $('.myForm #age').val(user.age);
                $('.myForm #email').val(user.email);
            });
            $('.myForm #exampleModal').modal();

    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});