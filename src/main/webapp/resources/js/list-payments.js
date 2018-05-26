$(function() {
	var baseUrl = $('#base_url').text();
    $('#payments').DataTable(/*{
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
    }*/);
});