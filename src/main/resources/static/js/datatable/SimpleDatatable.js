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
                    return "<a class='button' href='/"+ lien +"/get/" + data.id + "'>Modifier</a>"
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
    $.ajax({
        url:url,
        type:"POST",
        data:newName,
        contentType:"application/json; charset=utf-8",
        success: function(){
            table.ajax.reload();
            $('.alert-success').find('span').html('Votre modification a bien été sauvegardée');
            $('.alert-success').removeClass('hidden');
        },
        error: function(){
            $('.alert-danger').find('span').html('Votre modification a échoué, veuillez réessayer');
            $('.alert-danger').removeClass('hidden');
        }
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
