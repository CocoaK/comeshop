/*
 * Copyright 2017-2018 the original author(https://github.com/wj596)
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package com.eshop.serviceapp.common.filter;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.util.JwtTokenUtil;
import com.eshop.serviceapp.service.IRedisService;
import com.eshop.serviceapp.service.impl.RedisService;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 基于JWT(JSON WEB TOKEN)的无状态过滤器--认证
 */
public class CustomCrosFilter extends AccessControlFilter{
	
	private static final Logger log = LoggerFactory.getLogger(CustomCrosFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		//添加跨域支持
		if (httpRequest.getHeader(HttpHeaders.ORIGIN) != null) {
			if(!httpResponse.containsHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN)){
				httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader(HttpHeaders.ORIGIN));
				httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
				httpResponse.addHeader("Access-Control-Allow-Methods", "POST, GET");
				httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type,token");
				httpResponse.addHeader("Access-Control-Max-Age", "3600");
			}
		}
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return true;
	}

}
