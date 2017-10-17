function post(url,type,data,form){
	$.ajax({
		url:url,
		type:"post",
		data:data,
		success:function(e){
			error_init();
			if(e==="success"){
				location.href="/userlist";
				return;
			}
			if(e==="hasno_account"){
				$("[data-error='account']").html("没有此账号");
				return;
			}
			if(e==="password_is_error"){
				$("[data-error='pass']").html("密码错误");
			}
            var json = $.parseJSON(e);
            $.each(json, function (idx, obj) {
                var name = "[data-error='" + obj.field + "']";
                $(name).html(obj.message);
            });
		}
	})
}
function string_deal(data,type){
	var dat={"account":"","pass":"","_method":""};
	var q=data.split("&");
	for(var i=0;i<q.length;i++){
		var o=q[i].split("=")[1];
		switch(i){
			case 0:dat.account=o;break;
			case 1:dat.pass=o;break;
		}
	}
	dat._method=type;
	return dat;
}
function error_init(){
	$("[data-error='account']").html("");
	$("[data-error='pass']").html("");
}
$(document).on("click", "[name='submit']", function(e) {
	var form = $(this).parents("form");
    var url = form.attr("action");
    var type= form[0].method;
    var data = string_deal(form.serialize(),type);
    $('form').find('#account_error').html("");
    $('form').find('#password_error').html("");
    post(url,type,data,form);
});
