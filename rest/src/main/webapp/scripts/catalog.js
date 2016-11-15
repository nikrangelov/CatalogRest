function getData() {
	$.ajax({
		url: "http://localhost:8080/rest/api/cars",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].manufacturer + '</td>');
				tr.append('<td>' + data[index].model + '</td>');
				tr.append('<td>' + data[index].transmission + '</td>');
				tr.append('<td>' + data[index].engine + '</td>');
				tr.append('<td>' + data[index].year + '</td>');
				tr.append('<td>' + data[index].milleage  + '</td>');
				tr.append('<td>' + data[index].price  + '</td>');
				tr.append('</tr>');
				$('#carsTable').append(tr);
			});
		}
	});
}

$(document).ready(function() {
	//$('#button').click(function() {
		//alert('button clicked');
		getData();
	//});
});






