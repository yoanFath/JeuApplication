$(function() {
    $(document).on('click', '.form #ajouter', function() {
        const url = $(this).data('url');
        const jeudao = {
            'nom_jeu': $('input[name="nom_jeu"]').val(),
            'id_type': $('select[name="id_type"]').val(),
            'id_genre': $('select[name="id_genre"]').val(),
            'id_theme': $('select[name="id_theme"]').val(),
            'id_editeur': $('select[name="id_editeur"]').val(),
            'age_minimum': $('input[name="age_minimum"]').val(),
            'nombre_joueurs_minimum': $('input[name="nombre_joueurs_minimum"]').val(),
            'nombre_joueurs_maximum': $('input[name="nombre_joueurs_maximum"]').val()
        };

        console.log(url, jeudao);
        $('.alert').addClass('hidden');

        // $.post(url, request, function() {
        //
        // }).fail(function() {
        //     $('.alert-danger').removeClass('hidden');
        // });

        $.ajax({
            url:url,
            type:"POST",
            data:JSON.stringify(jeudao),
            contentType:"application/json; charset=utf-8",
            success: function(){
                $('.alert-success').removeClass('hidden');
            },
            error: function(){
                $('.alert-danger').removeClass('hidden');
            }
        })
    });

    $(document).on('input | change', 'input, select', function() {
        $('.alert').addClass('hidden');
    });
});
