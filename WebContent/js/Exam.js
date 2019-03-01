var isShowSubmitButton = false;

buttonControl();

$('.examResult').blur(judgeIsSelected);

function judgeIsSelected() {
	for(var i = 0; i < 10; i++) {
		var inputValue = $('*[name=result'+ i +']').val();

		if(inputValue != null && inputValue != "") {
			isShowSubmitButton = true;
		} else {
			isShowSubmitButton = false;
			break;
		}
	}

	buttonControl();
}

function buttonControl() {
	if(isShowSubmitButton) {
		$('#registSubmit').prop('disabled', false);
	} else {
		$('#registSubmit').prop('disabled', true);
	}
}