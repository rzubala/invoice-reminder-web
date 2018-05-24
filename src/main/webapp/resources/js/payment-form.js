$(function() {
	var date_input = $('input[name="date"]');
	var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
	date_input.datepicker({
		format : 'dd/mm/yyyy',
		container : container,
		todayHighlight : true,
		autoclose : true,
	});
});
