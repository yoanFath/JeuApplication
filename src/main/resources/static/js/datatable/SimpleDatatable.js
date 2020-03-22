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
                    return "<input type='button' value='Modifier' onclick='updateEntity(" + '"' + lien + '"' + "," + data.id + ",\"PROUT\"" +")'>"
                }},
            {"data": function(data){
                    return "<input type='button' value='Supprimer' onclick='deleteEntity(" + '"' + lien + '"' + "," + data.id + ")'>"
                }}

        ]
    });
}

function updateEntity(lien, id, newName) {
    $.ajax({
        type:"POST",
        url: "http://localhost:8080/api/" + lien + "/modifier/" + id,
        data: newName,
        success:function (responsedata) {
            table.ajax.reload();
            alert(responsedata);
        }
    })
}

function deleteEntity(lien, id) {
    $.ajax({
        type:"POST",
        url: "http://localhost:8080/api/" + lien + "/delete/" + id,
        success:function (responsedata) {
            table.ajax.reload();
            alert(responsedata);
        }
    })
}