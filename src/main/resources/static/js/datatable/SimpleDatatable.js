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
                    // TODO appel ajax on click avec une image ou jsp
                    return "appeler : api/"+lien+"/modifier/" + data.id + " avec le nom dans le body";
                }},
            {"data": function(data){
                    // TODO appel ajax on click avec une image ou jsp
                    return "appeler api/"+ lien +"/delete/" + data.id;
                }}

        ]
    });

}