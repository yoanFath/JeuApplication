$(function() {
    $(document).on('change', 'input[name="nombre_joueurs_minimum"]', function() {
        $('input[name="nombre_joueurs_maximum"]').val($(this).val());
    });
});