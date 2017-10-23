function succ_an(){
	$('.header_text')[0].children[1].remove();
	$('.header_text')[0].children[1].remove();
	$('form').fadeOut(500);
	if ($('.wrapper')[0]) {
		$('.wrapper').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="欢迎";
	}
	else {
		$('.wrapper_register').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="欢迎";
	}
	};