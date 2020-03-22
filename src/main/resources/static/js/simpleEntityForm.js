$(function() {
    $(document).on('click', '.form #ajouter', function() {
        const url = $(this).data('url');
        const request = $('input[name="name"]').val();

        $('.alert').addClass('hidden');
        console.log(request);
        if(request.length > 0) {
            $.ajax({
                url:url,
                type:"POST",
                data:request,
                contentType:"application/json; charset=utf-8",
                success: function(){
                    $('.alert-success').removeClass('hidden');
                },
                error: function(){
                    $('.alert-danger').removeClass('hidden');
                }
            })
        }
    });

    $(document).on('input | change', 'input, select', function() {
        $('.alert').addClass('hidden');
    });
});
