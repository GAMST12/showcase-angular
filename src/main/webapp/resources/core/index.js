$(document).ready(function() {
    $('#select-category').change(function() {

        var categories = new Array();
    if ($("#select-category option:selected").attr("id") === "all") {
        $("#select-category option").each(function(){
            if ($(this).attr("id") !== "all") {
                categories.push($(this).attr("id"));
            }
        });
    } else {
        categories.push($("#select-category option:selected").attr("id"));
    }
        console.log(categories);

        var producers = new Array();
        if ($("#select-producer option:selected").attr("id") === "all") {
            $("#select-producer option").each(function(){
                if ($(this).attr("id") !== "all") {
                    producers.push($(this).attr("id"));
                }
            });
        } else {
            producers.push($("#select-producer option:selected").attr("id"));
        }
        console.log(producers);

        var priceFrom;
        var priceTo;
        if ($("#price-from").val() === '') {
            priceFrom = 0;
        } else priceFrom = $("#price-from").val();
        if ($("#price-to").val() === '') {
            priceTo = 99999999;
        } else priceTo = $("#price-to").val();

        var availabilities = new Array();
        if ($("#only-available").is(':checked') == true) {
            availabilities.push(true);
        } else {
            availabilities.push(true);
            availabilities.push(false);
        }

        console.log(priceFrom);
        console.log(priceTo);
        console.log(availabilities)


                        $.ajax({
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json'
                            },
                            type: "POST",
                            url: "/filterproducts",
                            contentType: "application/json;charset=utf-8",
                            dataType: "json",
/*
                            data: JSON.stringify({categoriesId: categories, producersId: producers, priceFrom: priceFrom, priceTo: priceTo, availabilities: availabilities}),
*/
                            data: JSON.stringify({priceFrom: priceFrom, priceTo: priceTo}),
                            success: function (data) {
                                console.log(data);
/*
                                if (data.status === "OK") {
                                    alert("Successfully added");
                                } else {
                                    alert("Adding failed");
                                }
*/
                            },
                            error: function(){
                                alert("ERROR!");
                            }
                        });
                        return false;
    });
});