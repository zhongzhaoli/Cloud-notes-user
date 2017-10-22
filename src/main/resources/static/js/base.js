$(document).ready(function(){
	//form 实例化后的内容
	function string_deal(data,url,type){
		if(url=="http://127.0.0.1:8084/login"){
			var dat={"account":"","password":"","password2":"","_method":""};
		}
		if(url=="http://127.0.0.1:8084/login"){
			var dat={"account":"","password":"","_method":""};
		}
		var q=data.split("&");
		for(var i=0;i<q.length;i++){
			var o=q[i].split("=")[1];
			switch(i){
				case 0:dat.account=o;break;
				case 1:dat.password=o;break;
				case 2:dat.password2=o;break;
			}
		}
		dat._method=type;
		return dat;
	}
	function error_init(){
		if($("[data-error='password2']")){
			$("[data-error='password2']").html("");
		}
		$("[data-error='account']").html("");
		$("[data-error='password']").html("");
	}
	
	$("[name='submit']").on("click",function(){
		var form = $(this).parent();
		var type = form[0].method;
		var url = form[0].action;
		var data = string_deal(form.serialize(),url,type);
		$.ajax({
			url:url,
			data:data,
			type:type,
			success:function(e){
				error_init();
				if(e === "success"){
					succ_an();
					return;
				}
				if(typeof(e)==="string"&&e!="success"){
					var json = $.parseJSON(e);
		            $.each(json, function (idx, obj) {
		                var name = "[data-error='" + obj.field + "']";
		                $(name).html(obj.message);
		            });
				}
				if(typeof(e)==="object"){
					for(var i in e){
						var name = "[data-error='" + i + "']";
						$(name).html(e[i]);
					}
				}
			}
		})
	})
	$("input").on("keydown",function(){
		error_init();
	})
});