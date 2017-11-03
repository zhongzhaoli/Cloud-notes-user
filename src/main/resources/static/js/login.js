function succ_an(){
	$('.header_text')[0].removeChild($('.header_text')[0].children[1]);
	$('.header_text')[0].removeChild($('.header_text')[0].children[1]);
	$('form').fadeOut(500);
	if ($('.wrapper')[0]) {
		$('.wrapper').addClass('form-success');
		$("#head_banner_h1")[0].innerHTML="欢迎";
		var ip = location.origin.split("http://")[1].split(":8084")[0];
		setTimeout(function(){
<<<<<<< HEAD
			location.href="http://"+ip+":8085/index";
=======
			var url = window.location.host.split(":")[0];
//			location.href="http://127.0.0.1:8085/index";
			location.href="http://"+url+":8085/index";
>>>>>>> 1af62ea9f6d2fad7fe400df151d77eb6dfce5e3d
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