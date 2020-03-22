$(function () {
    var table;
    createDatable();

    function createDatable() {
        table = $('#example').DataTable({
            "processing": true,
            "ajax": {
                "url": "/api/jeu/all"
            },
            "columnDefs": [
                {"className": "dt-center", "targets": "_all"}
            ],
            "sAjaxDataProp": "",
            "columns": [
                {"data": "nom_jeu"},
                {
                    "data": function (data) {

                        return data.genre ? data.genre.nom_genre : "";
                    }
                },
                {
                    "data": function (data) {

                        return data.editeur ? data.editeur.nom_editeur : "";
                    }
                },
                {
                    "data": function (data) {

                        return data.theme ? data.theme.nom_theme : "";
                    }
                },
                {
                    "data": function (data) {

                        return data.type ? data.type.nom_type : "";
                    }
                },
                {"data": "age_minimum"},
                {"data": "nombre_joueurs_minimum"},
                {"data": "nombre_joueurs_maximum"},
                {
                    "data": function (data) {

                        return "<a href='/jeu/modifier/" + data.id + "' type='button' class='button' onclick='updateEntity()'>Modifier</a>"
                    }
                },
                {
                    "data": function (data) {
                        return "<button type='button' class='red' onclick='deleteEntityGame(" + data.id + ")'>Supprimer</button>"
                    }
                }
            ]
        });
    }

    function deleteEntityGame(id) {
        const url = '/api/jeu/delete/' + id;
        $('.alert').addClass('hidden');
        $.post(url, {}, function () {
            table.ajax.reload();
            $('.alert-success').find('span').html('Votre suppression a bien été effectuée');
            $('.alert-success').removeClass('hidden');
        }).fail(function () {
            $('.alert-danger').find('span').html('Votre suppression a échoué, veuillez réessayer');
            $('.alert-danger').removeClass('hidde');
        });
    }

    $('#genre').keyup(function () {
        table.column(1).search($("#genre").val()).draw();
    });
    $('#editeur').keyup(function () {
        table.column(2).search($("#editeur").val()).draw();
    });
    $('#nom_jeu').keyup(function () {
        table.column(0).search($("#nom_jeu").val()).draw();
    });
});
