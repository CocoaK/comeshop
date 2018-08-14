package com.eshop.serviceapp.common.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	public static JSONObject jsonStringToJsonObject(String jsonString) {
		// JSON格式数据解析对象
		JSONObject jb = JSONObject.parseObject(jsonString);
		return jb;
	}

	public static String getDataFromJsonObject(JSONObject jb, String key) {
		String value = null;
		try {
			value = jb.getString(key);
			if (value != null && !"".equals(value.trim())) {
				value = value.trim();
			} else {
				value = null;
			}
		} catch (Exception e) {

		}
		return value;
	}

}
