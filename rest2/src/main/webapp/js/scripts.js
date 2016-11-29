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
function getData() {
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			var car;
			for(car in data.data)
			console.log(car.engine);
		}
	});
}

$(document).ready(function() {
		getData();
});

