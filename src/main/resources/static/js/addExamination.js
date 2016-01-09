$(document).ready(function() {
    $(".datepicker").val(new Date());
    $("#animalAge").val(0);
    $("#invoiceId").val(0);
    $(".datepicker").datepicker({});

    $(":file").filestyle({buttonName: "btn-primary"});

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

            if (animals.length == 0) {
                window.location = "/addAnimal?animalListIsEmpty=" + $("#patientId").val();
            }

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

    $('.show-children').click(function () {
        var $tableDivContainer = $(this).closest(".table-container").find(".group-items");
        $tableDivContainer.removeClass("hidden");
        $(this).next().removeClass('hidden');
        $(this).addClass("hidden");
    });

    $('.hide-children').click(function () {
        var $tableDivContainer = $(this).closest(".table-container").find(".group-items");
        $tableDivContainer.addClass("hidden");
        $(this).prev().removeClass("hidden");
        $(this).addClass("hidden");
    });

    $('.add-invoice-element').click(function() {
        var actIndex = $(this).prev().children('tbody').children('tr').length;
        var groupName = $(this).data("groupname");
        var $groupDataAmount = $(this).parent().parent().find(".invoice-group-amount");
        var tableRow = $('<tr>'),
            tableData1 = $('<td>'),
            tableData2 = $('<td>'),
            inputDescription = $('<input>');
            inputDescription.attr("name", groupName + ".items[" + actIndex + "].description")
                            .attr("type", "text")
                            .val('Image cell');
            inputDescription[0].innerHTML = inputDescription.val();
            inputDescription[0].value = inputDescription.val();
            inputPrice = $('<input>');
            inputPrice.attr("name", groupName + ".items[" + actIndex + "].price")
                      .attr("type", "number")
                      .addClass("firstGroupDatasPrice")
                      .addClass("price")
                      .val('0');
            inputPrice[0].innerHTML = inputPrice.val();
            inputPrice[0].value = inputPrice.val();
            $tableBody = $(this).prev().find('tbody');


            $tableBody.append(
                    tableRow
                        .append(tableData1.append(inputDescription))
                        .append(tableData2.append(inputPrice))
            );

            $(inputPrice).on("change paste keyup input", null, function(e) {
                var $containerDiv = $(this).closest(".table-container").find(".invoice-group-amount-hidden");
                $containerDiv.val(this.value);

                var $containerDiv = $(this).closest(".table-container").find(".invoice-group-amount");
                var $tableBody = $(this).parent().parent().parent();
                var sum = 0;
                $tableBody.find(".firstGroupDatasPrice").each(function( index ) {
                    sum += Number(this.value);
                });
                $containerDiv.text(sum);
        });

    });

    $("body").on("change paste keyup input", ".price", function(e) {
        var sum = 0;
        $('.price').each(function( index ) {
            sum += Number(this.value);
        });
        $('#netSum').text(sum);
    });
});


