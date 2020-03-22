$(function() {
    $(document).on('change', 'input[name="nombre_joueurs_minimum"]', function() {
        $('input[name="nombre_joueurs_maximum"]').val($(this).val());
    });

    $(document).on('click', 'button[type="submit"]', function(event) {
        event.preventDefault();
        if($('input[name="age_minimum"]').val().length === 0) {
            $('input[name="age_minimum"]').val(100000);
        }
        if($('input[name="nombre_joueurs_minimum"]').val().length === 0) {
            $('input[name="nombre_joueurs_minimum"]').val(100000);
            $('input[name="nombre_joueurs_maximum"]').val(0);
        }
        $(this).parents('form').first().submit();
    });
});