$( document ).ready(function() {
    $(".datepicker").val(new Date());
    $("#animalAge").val(0);
    $("#invoiceId").val(0);
    $(".datepicker").datepicker({});

    var patient;

    $( "#patientId" ).change(function() {
        var url = "/getPatient/" + $( "#patientId").val();
        $.ajax({url: url, success: function(result){
            patient = result;
            console.log(result);
            $("#patientName").val(result.name);
            $("#patientCity").val(result.city);
            $("#patientAddress").val(result.address);
            $("#patientPhoneNumber").val(result.phoneNumber);
            $("#patientEmailAddress").val(result.emailAddress);

            $("#animalId option").remove();

            var animals = result.animal;

            for (var index in animals) {
                $('#animalId').append($("<option></option>")
                        .attr("value",animals[index].animalId)
                        .text(animals[index].name));
            }
            $('#animalId').selectpicker('refresh');
            $("#animalName").val(animals[0].name);
            $("#animalBreed").val(animals[0].breed);
            $("#animalSpecies").val(animals[0].species);
            $("#animalSex").val(animals[0].sex);
            $("#animalAge").val(animals[0].age);
        }});

        $("#animalId").prop('disabled', false);
        $("#animalName").prop('disabled', false);
        $("#animalSpecies").prop('disabled', false);
        $("#animalBreed").prop('disabled', false);
        $("#animalSex").prop('disabled', false);
        $("#animalAge").prop('disabled', false);
    });

    $( "#animalId" ).change(function() {
        var animals = patient.animal;
        for (var index in animals) {
            if (animals[index].animalId == $( "#animalId").val()) {
                $("#animalName").val(animals[index].name);
                $("#animalBreed").val(animals[index].breed);
                $("#animalSpecies").val(animals[index].species);
                $("#animalSex").val(animals[index].sex);
                $("#animalAge").val(animals[index].age);
                break;
            }
        }
    });

    $('#firstInvoiceGroupAdd').click(function() {
        $("#firstGroupElements").find('tbody')
            .append($('<tr>')
                .append($('<td>')
                    .append($('<input>')
                        .attr("type", "text")
                        .val('Image cell')
                    )
                )
                .append($('<td>')
                    .append($('<input>')
                        .attr("type", "number")
                        .val("0")
                    )
                )
            );
    });
});

