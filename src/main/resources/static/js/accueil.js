$(function() {
    $(document).on('change', 'input[name="nombre_joueurs_minimum"]', function() {
        $('input[name="nombre_joueurs_maximum"]').val($(this).val());
    });

    $(document).on('click', 'button[type="submit"]', function(event) {
        event.preventDefault();
        $('input[name="age_minimum"]').val(100000);
        $(this).parents('form').first().submit();
    });
});