package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.Constants;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.User;
import com.eshop.serviceweb.service.IRedisService;
import com.eshop.serviceweb.service.IUserService;
import com.eshop.serviceweb.shiro.JwtTokenUtil;
import com.eshop.serviceweb.vo.LoginResultVO;
import com.eshop.serviceweb.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/login")
    public ResultEntity<LoginResultVO> login(@Validated @RequestBody LoginVO loginVO) throws Exception{
        ResultEntity<LoginResultVO> re = new ResultEntity<LoginResultVO>(ResultEntity.FAILD,ResultEntity.MSG_FAILED,null);
        User user = new User();
        user.setUserName(loginVO.getUserName());
        user.setUserPwd(loginVO.getPassword());
        List<User> list = userService.getList(user);
        if(null == list || list.size()==0){
            re.setCode(ResultEntity.ACCOUNT_OR_PASSWD_ERROR);
            re.setMsg(ResultEntity.MSG_FAILED);
        }else{
            User u = list.get(0);
            LoginResultVO loginResultVO = new LoginResultVO();
            String token = JwtTokenUtil.createToken(u.getUserId()+"");
            redisService.addKey(token,u.getUserId()+"",Constants.REDIS_TOKEN_EXPIRE_TIME);
            loginResultVO.setToken(token);
            loginResultVO.setUser(u);
            re.setCode(ResultEntity.SUCCESS);
            re.setMsg(ResultEntity.MSG_SUCCESS);
            re.setData(loginResultVO);
        }
        return re;
    }
}
