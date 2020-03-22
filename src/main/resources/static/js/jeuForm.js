$(function() {
    $(document).on('click', '.form #ajouter', function() {
        const url = $(this).data('url');
        const request = {
            'nom_jeu': $('input[name="nom_jeu"]').val(),
            'id_type': $('select[name="id_type"]').val(),
            'id_genre': $('select[name="id_genre"]').val(),
            'id_theme': $('select[name="id_theme"]').val(),
            'id_editeur': $('select[name="id_editeur"]').val(),
            'age_minimum': $('input[name="age_minimum"]').val(),
            'nombre_joueurs_minimum': $('input[name="nombre_joueurs_minimum"]').val(),
            'nombre_joueurs_maximum': $('input[name="nombre_joueurs_maximum"]').val()
        };

        console.log(url, request);
        $('.alert').addClass('hidden');

        $.post(url, request, function() {
            $('.alert-success').removeClass('hidden');
        }).fail(function() {
            $('.alert-danger').removeClass('hidden');
        });
    });

    $(document).on('input | change', 'input, select', function() {
        $('.alert').addClass('hidden');
    });
});
