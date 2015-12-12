$('#queryValueHeader').autocomplete({
    /*delay: 500,*/
    source : function(request, response) {
        $.ajax({
            url : '/searchNameJSON',
            data : {
               query : request.term
            },
            success : function(data) {
                var transformed = $
                    .map(
                        data,
                        function(el) {
                            return {
                                label : el.name,
                                id : el.id
                            };
                        });
                response(transformed);
            },
            error : function() {
                response([]);
            }
        });
    },
    select : function(event, ui) {
        if (ui.item == null || ui.item == "") {
            $('#queryValueHeader').val('');
            $('#nodeId').val('');
        } else {
            window.location = "/patient/" + ui.item.id;
        }
    }
});

    $('#queryValueHeader').keypress(function (e) {
        if (e.which == 13) {
            if ($('#queryValueHeader').val() != null && $('#queryValueHeader').val() != "") {
                $('#formSubmit').submit();
            } else {
                e.preventDefault();
            }
        }
    });

