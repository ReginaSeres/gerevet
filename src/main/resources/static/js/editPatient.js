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
/*
    $('#editPatient').click(function() {
        $('#patientName').addClass("hidden");
        $('#patientName').next().removeClass("hidden");

        $('#patientCity').addClass("hidden");
        $('#patientCity').next().removeClass("hidden");

        $('#patientAddress').addClass("hidden");
        $('#patientAddress').next().removeClass("hidden");

        $('#patientPhoneNumber').addClass("hidden");
        $('#patientPhoneNumber').next().removeClass("hidden");

        $('#patientEmailAddress').addClass("hidden");
        $('#patientEmailAddress').next().removeClass("hidden");

        $('#editPatient').addClass("hidden");
        $('#updatePatient').removeClass("hidden");
    });
*/
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
/*
        $('#patientName').removeClass("hidden");
        $('#patientName').next().addClass("hidden");

        $('#patientCity').removeClass("hidden");
        $('#patientCity').next().addClass("hidden");

        $('#patientAddress').removeClass("hidden");
        $('#patientAddress').next().addClass("hidden");

        $('#patientPhoneNumber').removeClass("hidden");
        $('#patientPhoneNumber').next().addClass("hidden");

        $('#patientEmailAddress').removeClass("hidden");
        $('#patientEmailAddress').next().addClass("hidden");

        $('#editPatient').removeClass("hidden");
        $('#updatePatient').addClass("hidden");*/
    });
});