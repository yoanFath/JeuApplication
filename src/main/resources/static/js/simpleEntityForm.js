$(function() {
    $(document).on('click', '.form #ajouter', function() {
        const url = $(this).data('url');
        const request = $('input[name="name"]').val();

        $('.alert').addClass('hidden');

        if(request.length > 0) {
            $.post(url, request, function(response) {
               $('.alert-success').removeClass('hidden');
            }).fail(function() {
                $('.alert-danger').removeClass('hidden');
            });
        }
    });

    $(document).on('input | change', 'input, select', function() {
        $('.alert').addClass('hidden');
    });
});
