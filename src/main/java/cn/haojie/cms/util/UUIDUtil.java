package cn.haojie.cms.util;

import java.util.UUID;

/*
* UUID生成器
* @date 2017/10/19
*/
public class UUIDUtil {
	
	private UUIDUtil() {}

	public static final String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}