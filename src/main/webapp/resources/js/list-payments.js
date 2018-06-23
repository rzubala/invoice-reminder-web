function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Name:</td>'+
            '<td>'+d[1]+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Description:</td>'+
            '<td>'+d[2]+'</td>'+
        '</tr>'+
    '</table>';
}

function filterPayments() {
	var showPaid = $('#show_paid').is(":checked");
	var showFrom = $('#show_from').val();
	var params = { show_paid:showPaid, show_from: showFrom};
	var str = jQuery.param( params );
	console.log(str);
	
	if (!window.location.origin){
	  // For IE
		window.location.origin = window.location.protocol + "//" + (window.location.port ? ':' + window.location.port : '');      
	}
	var url = window.location.origin + window.location.pathname;
	console.log(url);
	
	window.location.href = url + "?" + str;
	
}

$(function() {
	var date_input = $('input[name="show_from"]');
	var container = $('#filters').length > 0 ? $('#filters').parent() : "body";
	date_input.datepicker({
		format : 'dd/mm/yyyy',
		container : container,
		todayHighlight : true,
		autoclose : true,
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
        changeYear: true,
        orientation: "top",		
	});
	
	//date_input.datepicker("setDate", new Date());	
	//$('#show_paid').prop('checked', true);
	
	var baseUrl = $('#base_url').text();
	var table = $('#payments').DataTable({
		"order": [],
		"columnDefs": [{ "targets": [0], "searchable": false, "orderable": false, "visible": true }]
	
	/*{
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": baseUrl+"/grid/listPayments",
            "type": "GET"
        },
        "columns": [
            { "data": "name" },
            { "data": "description" },
            { "data": "dateStr" }
        ],
    */
    });
   
	//temporary hide column
    var column = table.column(0);
    column.visible(!column.visible());
	
    // Add event listener for opening and closing details
    $('#payments').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } ); 
   
    $('#show_from').change(function() {
    	filterPayments();
    });
    
    $('#show_paid').change(function() {
    	filterPayments();
    });
});