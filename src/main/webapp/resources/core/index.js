$(document).ready(function() {
    $('#select-category').change(function() {
        filterChange();
    });
    $('#select-producer').change(function() {
        filterChange();
    });
    $('#price-from').focusout(function() {
        filterChange();
    });
    $('#price-to').focusout(function() {
        filterChange();
    });
    $('#only-available').change(function() {
        filterChange();
    });


    var filterChange = function() {
        var category;
    if ($("#select-category option:selected").attr("id") === "all") {
        category = 0;
    } else category = $("#select-category option:selected").attr("id");

    var producer;
    if ($("#select-producer option:selected").attr("id") === "all") {
        producer = 0;
    } else {
        producer = $("#select-producer option:selected").attr("id");
    }

    var priceFrom;
    var priceTo;
    if ($("#price-from").val() === '') {
        priceFrom = 0;
    } else priceFrom = $("#price-from").val();
    if ($("#price-to").val() === '') {
        priceTo = 99999999;
    } else priceTo = $("#price-to").val();

    var onlyAvailable = $("#only-available").is(':checked');

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            url: "/filterproducts",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: JSON.stringify({categoryId: category, producerId: producer, priceFrom: priceFrom, priceTo: priceTo, onlyAvailable: onlyAvailable}),
            success: function (products) {
                console.log(products);
                $(".table tbody tr").remove();
                if (products != null) {
                    $.each(products, function(){
                        console.log(this.producer.name);
                        var isAvailable;
                        if (this.available) {
                            isAvailable = 'Yes';
                        } else isAvailable = 'No';
                        $(".table").append('<tr><td>'+this.name+'</td><td>'+this.producer.name+'</td><td>'+this.category.name+'</td><td>'+this.category.mainCategory.name+'</td><td>' +this.description+ '</td><td>'+this.price+'</td><td>'+ isAvailable +'</td></tr>');
                    });

                }
            },
            error: function(){
                alert("ERROR!");
            }
        });
        return false;
    };
});