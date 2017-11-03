function succ_an(){
	$('.header_text')[0].removeChild($('.header_text')[0].children[1]);
	$('.header_text')[0].removeChild($('.header_text')[0].children[1]);
	$('form').fadeOut(500);
	if ($('.wrapper')[0]) {
		$('.wrapper').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="欢迎";
		setTimeout(function(){
			var url = window.location.host.split(":")[0];
			location.href="http://"+url+":8085/index";
		},1500)
	}
	else {
		$('.wrapper_register').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="成功";
		setTimeout(function(){
			location.href="/login";
		},1500)
	}
};