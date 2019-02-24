$('input:button').on('click',function() {
	var buttonId = $(this).attr('name');

	$('#' + buttonId).css('visibility','visible');
});