package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.util.JwtTokenUtil;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.service.IRedisService;
import com.eshop.serviceapp.service.IMemberService;
import com.eshop.serviceapp.vo.LoginResultVO;
import com.eshop.serviceapp.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private IMemberService memberService;

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/login")
    public ResultEntity<LoginResultVO> login(@Validated @RequestBody LoginVO loginVO) throws Exception{
        ResultEntity<LoginResultVO> re = new ResultEntity<LoginResultVO>(ResultEntity.FAILD,ResultEntity.MSG_FAILED,null);
        Member member = new Member();
        member.setUserName(loginVO.getUserName());
        member.setPassword(loginVO.getPassword());
        List<Member> list = memberService.getList(member);
        if(null == list || list.isEmpty()){
            //判断手机号和密码
            Member tleMember = new Member();
            tleMember.setTelephone(loginVO.getUserName());
            tleMember.setPassword(loginVO.getPassword());
            List<Member> telList = memberService.getList(tleMember);
            if(null == telList || telList.isEmpty()){
                re.setCode(ResultEntity.ACCOUNT_OR_PASSWD_ERROR);
                re.setMsg(ResultEntity.MSG_FAILED);
            }else{
                //手机号和密码匹配
                checkLoginResult(telList,re);
            }
        }else{
            //用户名和密码匹配
            checkLoginResult(list,re);
        }
        return re;
    }

    private void checkLoginResult(List<Member> list,ResultEntity<LoginResultVO> re) throws Exception{
        Member mem = list.get(0);
        LoginResultVO loginResultVO = new LoginResultVO();
        String token = JwtTokenUtil.createToken(mem.getMemberId()+"");
        redisService.addKey(token,mem.getMemberId()+"",Constants.REDIS_TOKEN_EXPIRE_TIME);
        loginResultVO.setToken(token);
        loginResultVO.setMember(mem);
        re.setCode(ResultEntity.SUCCESS);
        re.setMsg(ResultEntity.MSG_SUCCESS);
        re.setData(loginResultVO);
    }
}
