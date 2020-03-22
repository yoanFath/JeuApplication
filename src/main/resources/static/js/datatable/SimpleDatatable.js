var table;

function creerSimpleDatatable(lien){
    table = $('#example').DataTable({
        "processing": true,
        "ajax": {
            "url": "/api/"+ lien + "/all"
        },
        "columnDefs": [
            {"className": "dt-center", "targets": "_all"}
        ],
        "sAjaxDataProp": "",
        "columns": [
            {"data": "nom_"+lien},
            {"data": function(data){
                    return "<button type='button' onclick='updateEntity(" + '"' + lien + '"' + "," + data.id + ",\"PROUT\"" +")'>Modifier</button>"
                }},
            {"data": function(data){
                    return "<button type='button' class='red' onclick='deleteEntity(" + '"' + lien + '"' + "," + data.id + ")'>Supprimer</button>"
                }}

        ]
    });
}

function updateEntity(lien, id, newName) {
    const url = '/api/' + lien + '/modifier/' + id;
    $('.alert').addClass('hidden');
    $.post(url, newName, function() {
        table.ajax.reload();
        $('.alert-success').find('span').html('Votre modification a bien été sauvegardée');
        $('.alert-success').removeClass('hidden');
    }).fail(function() {
        $('.alert-danger').find('span').html('Votre modification a échoué, veuillez réessayer');
        $('.alert-danger').removeClass('hidden');
    });
}

function deleteEntity(lien, id) {
    const url = '/api/' + lien + '/delete/' + id;
    $('.alert').addClass('hidden');
    $.post(url, {}, function() {
        table.ajax.reload();
        $('.alert-success').find('span').html('Votre suppression a bien été effectuée');
        $('.alert-success').removeClass('hidden');
    }).fail(function() {
        $('.alert-danger').find('span').html('Votre suppression a échoué, veuillez réessayer');
        $('.alert-danger').removeClass('hidden');
    });
}
