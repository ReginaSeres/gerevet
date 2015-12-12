$( document ).ready(function() {
    $('#editAnimal').click(function() {
        $('.edit-content .edit').addClass('hidden');
        $('.edit-content input').removeClass('hidden');

        $('#editAnimal').addClass("hidden");
        $('#updateAnimal').removeClass("hidden");
    });

    $('#updateAnimal').click(function() {
        var csrfToken = $('#_csrf').attr("content");
        var csrfHeader = $('#_csrf_header').attr("content");
        var data = {};
        $('.edit-content input').each(function(index, elem){
            data[$(elem).attr('name')]=$(elem).val();
        });
        $.ajax({
            type: "POST",
            beforeSend: function(xhr){
                xhr.setRequestHeader(csrfHeader, csrfToken);
            },
            dataType: 'json',
            mimeType : "application/json",
            contentType: 'application/json',
            data: JSON.stringify(data),
            url: "/updateAnimal",
            success : function(response) {

                $.each(response, function(key, value){
                    $('.edit-content input[name=' + key + ']').val(value);
                    $('.edit-content .edit[data-update=' + key + ']').text(value);
                });


                $('#editAnimal').removeClass("hidden");
                $('#updateAnimal').addClass("hidden");

                $('.edit-content .edit').removeClass('hidden');
                $('.edit-content input').addClass('hidden');
                console.log("aaaaa");
            }
        });
    });
});