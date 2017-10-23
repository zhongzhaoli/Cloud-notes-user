function succ_an(){
	$('form').fadeOut(500);
	if ($('.wrapper')[0]) {
		$('.wrapper').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="欢迎";
	}
	else {
		$('.wrapper_register').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="欢迎";
		setTimeout(function(){
			location.href="/login";
		},2000)
	}
};