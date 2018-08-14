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
package com.eshop.serviceapp.shiro;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.service.IRedisService;
import com.eshop.serviceapp.service.impl.RedisService;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.concurrent.TimeUnit;

/**
 * 基于JWT(JSON WEB TOKEN)的无状态过滤器--认证
 */
public class JwtAuthcFilter extends AccessControlFilter{
	@Autowired
	private IRedisService redisService;
	
	private static final Logger log = LoggerFactory.getLogger(AccessControlFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		if (null != getSubject(request, response) 
				&& getSubject(request, response).isAuthenticated()) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		ResultEntity<String> resultEntity = new ResultEntity<String>();
		HttpServletRequest req = (HttpServletRequest)request;
		redisService(req);
		String accessToken = req.getHeader(Constants.ACCESS_TOKEN);
		try{
			JwtTokenUtil.verifyToken(accessToken);
			if(StringUtils.isEmpty(accessToken)){
				log.info("token未授权！");
			}else if(redisService.existsKey(accessToken)){
				redisService.expireKey(accessToken,Constants.REDIS_TOKEN_EXPIRE_TIME,TimeUnit.SECONDS);
				return true;
			}
		}catch (Exception e){
			log.error("token校验失败！"+e.getMessage());
		}
		resultEntity.setCode(401);
		resultEntity.setMsg("unauthorized");
		System.out.println("resultEntity:"+resultEntity);
		JwtTokenUtil.restFailed(WebUtils.toHttp(response),resultEntity);
		return false;
	}

	private void redisService(HttpServletRequest req){
		ServletContext sc = req.getSession().getServletContext();
		ServletWebServerApplicationContext cxt = (ServletWebServerApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
		if(cxt != null && cxt.getBean("redisService") != null && redisService == null){
			  this.redisService = (RedisService) cxt.getBean("redisService");
		}
	}
}
