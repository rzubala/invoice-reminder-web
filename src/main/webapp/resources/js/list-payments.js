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

$(function() {
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
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );    
});