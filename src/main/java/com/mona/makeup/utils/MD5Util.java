package com.mona.makeup.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util{
	public static String md5Hex(String password) {
		if(password != null){
			return DigestUtils.md5Hex(password);
		}
		return null;
	}
}
