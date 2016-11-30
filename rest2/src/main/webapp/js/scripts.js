/*$(document).ready(function() {
	$("#button").click(function (){
		$.get({
			url: "http://localhost:8081/rst/api/users",
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td> " + data[index].name + "</td>");
					$("#usersTable").append(tr);
				});
			}

		});
	});
});

*/
/*
 * 
 *  <tr>
      <th>Manufacturer</th>
      <th>Model</th>
      <th>Transmission</th>
      <th>Engine</th>
      <th>Year</th>
      <th>Milleage</th>
      <th>Price</th>
    </tr>
 */

/*
 * 			@DefaultValue("0") @QueryParam("page") int page, 
			@DefaultValue("5") @QueryParam("perPage") int perPage, 
			@DefaultValue("") @QueryParam("maker") String withManufacturer,
			@DefaultValue("") @QueryParam("model") String withModel, 
			@DefaultValue("") @QueryParam("transm") String  withTransmission,
			@DefaultValue("") @QueryParam("engine") String withEngine,
			@DefaultValue("0") @QueryParam("minYear") int withMinYear,
			@DefaultValue("0") @QueryParam("maxY") int withMaxYear,
			@DefaultValue("0") @QueryParam("minKm") int withMinMilleage,
			@DefaultValue("1000000000") @QueryParam("maxKm") int withMaxMilleage,
			@DefaultValue("0") @QueryParam("minPrice") int withMinPrice,
			@DefaultValue("1000000000")@QueryParam("maxPrice") int withMaxPrice) {
			
 */
var gpage = 0;
var gperPage = 2;
var jdata;

function getData() {
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
		type: "GET",
		 data: { 
			 page: gpage,
			 perPage: gperPage, 
			 maker: $('#maker').val(),
			 model: $('#model').val(),
			 transm: $('#transm').val(),
			 engine: $('#engine').val(),
			 minYear: $('#maxYear').val(),
			 minKm: $('#minKm').val()
		 },
		dataType: "json",
		success: function(data) {
			console.log(data);
			jdata = data;
			$.each(data.data, function(index){
				console.log(data.data[index].engine);
				var tr = $('<tr>');
				tr.append("<td> " + data.data[index].manufacturer + "</td>");
				tr.append("<td> " + data.data[index].model + "</td>");
				tr.append("<td> " + data.data[index].transmission  + "</td>");
				tr.append("<td> " + data.data[index].engine + "</td>");
				tr.append("<td> " + data.data[index].year + "</td>");
				tr.append("<td> " + data.data[index].milleage + "</td>");
				tr.append("<td> " + data.data[index].price + "</td>");
				tr.append("</tr>");
				$("#carsTable").append(tr);
			});
		}
	});
}

$(document).ready(function() {
		getData();
		$("#page-display").append("Page: " + gpage);
		$("#filter_btn").click(function (){
			$( "#carsTable" ).empty();
			getData();
		});
		
		$("#prev_btn").click(function (){
			$( "#carsTable" ).empty();
			if(gpage >= 1){
				gpage--;
			}
			$( "#page-display" ).empty();
			$("#page-display").append("Page: " + gpage);
			getData();
		});
		
		$("#next_btn").click(function (){
			$( "#carsTable" ).empty();
			$( "#page-display" ).empty();
			console.log(jdata.totalPages);
			if((gpage + 1) < jdata.totalPages){
				gpage++;
			}
			$("#page-display").append("Page: " + gpage);
			getData();
		});
});


