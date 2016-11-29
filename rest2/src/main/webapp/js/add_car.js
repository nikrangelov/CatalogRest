
function getData() {
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
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

function postData() {
	/*var car = " {
					\"manufacturer\":"'+ $("#manufacturer").val() +'",
					"model":"' +$("#model").val() + '",
					"transmission":"' + $("#transmission").val()+'",
					"engine":" '+ $("#engine").val()+' ",
					"year": ' + $('#year').val() + ',
					"milleage":'+ $('#milleage').val() +',
					"price":' + $('#price').val() +',
					"urlImage":" ' + $('#urlImage').val() + ' "
				}";*/
	
	var car = 	'{ "manufacturer":"' + $("#manufacturer").val() + '", '  + 
				' "model":"' + $("#model").val() + '", '  +
				' "transmission": "' + $("#transmission").val() + '", '  +
				' "engine":"' + $("#engine").val() + '", '  +
				' "year":' + $("#year").val() + ', '  +
				' "milleage":' + $("#milleage").val() + ', '  +
				' "price":' + $("#price").val() + 
				'}';
	
	
	//var car ='{"manufacturer":"Mercedes","model":"S Class 65 AMG","transmission":"Automatic","engine":"Disel","year":2016,"milleage":20,"price":160000}';
	//console.log(car);
	
	var obj = JSON.parse(car);
	$.ajax({
	    type: "POST",
	    url: "http://localhost:8080/rst2/api/cars",
	    // The key needs to match your method's input parameter (case-sensitive).
	    data: car,
	    contentType: "application/json",
	    dataType: "json",
	    success: function(data){alert(data);},
	    failure: function(errMsg) {
	        alert(errMsg);
	    }
	});
	
}

$(document).ready(function() {
	$('#add_btn').click(function() {
		alert('button clicked');
		postData();
	});
});
