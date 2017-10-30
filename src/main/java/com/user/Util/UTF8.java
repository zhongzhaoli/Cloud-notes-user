package com.user.Util;

import java.io.UnsupportedEncodingException;

public class UTF8 {
	public static String toUtf8(String request) throws UnsupportedEncodingException{
		if(request!=null){
			String str=new String(request.getBytes("iso8859-1"),"utf-8");
			return str;
		}else{
			return null;
		}		
		
	}

}
