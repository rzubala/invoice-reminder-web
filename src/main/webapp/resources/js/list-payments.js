$(function() {
	$('#payments').DataTable();
	
	$('#my_test').html("before")	

	var baseUrl = $('#base_url').text();
    $.ajax({
    	url: baseUrl+"/api/listPayments",
		type : "GET",
		contentType : "application/json",
		timeout : 100000,
    	success: function(result){
    		$("#my_test").text(JSON.stringify(result));
    		console.log("SUCCESS: ", result);
    	}, 
    	error : function(e) {
    		console.log("ERROR: ", e);
    	}
    });
});