package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.service.IRedisService;
import com.eshop.serviceapp.shiro.JwtTokenUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/login")
    @CachePut
    public ResultEntity<String> submitLogin(String username, String password, HttpServletRequest request) {
        ResultEntity<String> re = new ResultEntity<>(ResultEntity.FAILD,"","");
        String access_token = "";
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            User user = (User) subject.getPrincipal();
            access_token = JwtTokenUtil.createToken(user.getId(),Constants.REDIS_TOKEN_EXPIRE_TIME);
            redisService.addKey(access_token,user.getId().toString());
            re.setCode(ResultEntity.SUCCESS);
            re.setMsg(ResultEntity.MSG_SUCCESS);
            re.setData(access_token);
        } catch (DisabledAccountException e) {
            e.printStackTrace();
//            request.setAttribute("msg", "账户已被禁用");
            re.setCode(ResultEntity.ACCOUNT_DISABLE);
            re.setMsg("account disable");
        } catch (AuthenticationException e) {
            e.printStackTrace();
//            request.setAttribute("msg", "用户名或密码错误");
            re.setCode(ResultEntity.ACCOUNT_OR_PASSWD_ERROR);
            re.setMsg("account or password error");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 执行到这里说明用户已登录成功
        return re;
    }

    @RequestMapping(value = "/logout")
    @CachePut
    public ResultEntity<String> logout(HttpServletRequest request) {
        ResultEntity<String> re = new ResultEntity<>(ResultEntity.FAILD,"","");
        String token  = request.getHeader(Constants.ACCESS_TOKEN);
        redisService.deleteKey(token);
        re.setCode(ResultEntity.SUCCESS);
        re.setMsg("logout success!");
        // 执行到这里说明用户已登录成功
        return re;
    }

    //被踢出后跳转的页面
    @RequestMapping(value = "/kickout", method = RequestMethod.GET)
    public String kickOut() {
        return "kickout";
    }
}
