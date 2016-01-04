$( document ).ready(function() {
    $.fn.editable.defaults.mode = 'inline';
    $.fn.editable.defaults.send = 'never';
    $('.editable').editable();
    $('.editable').on('save', function(){
        activateSaveButton();
    });

    function activateSaveButton() {
        $('#updatePatient').removeClass('disabled');
    }

    $('#updatePatient').click(function() {
        var csrfToken = $('#_csrf').attr("content");
        var csrfHeader = $('#_csrf_header').attr("content");
        var data = {};
        $('.updatable').each(function(index, elem){
            data[$(elem).data('name')]=$(elem).text();
        });
        $.ajax({
            type: "POST",
            beforeSend: function(xhr){
                xhr.setRequestHeader(csrfHeader, csrfToken);
            },
            dataType: 'json',
            mimeType : "application/json",
            contentType: 'application/json',
            url: "/updatePatient",
            data: JSON.stringify(data),
            success : function(response) {
                $('.editable').removeClass('editable-unsaved');
                $('#updatePatient').addClass('disabled');
                console.log("aaaaa");
            }
        });
    });
});