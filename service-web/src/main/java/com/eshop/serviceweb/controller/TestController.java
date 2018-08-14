//package com.eshop.serviceweb.controller;
//
//import com.eshop.serviceweb.common.model.ResultList;
//import com.github.pagehelper.Page;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class TestController extends BaseController<User>{
//
//    @Autowired
//    private IUserService userService;
//
//    @Override
//    public IBaseService<User> getBaseService() {
//        return userService;
//    }
//
//    @RequestMapping("/get")
//    public String get(Long id) {
//        User user = userService.getById(id);
//        return "user:"+user.getUsername();
//    }
//
//    @RequestMapping("/getPageList")
//    public ResultList<List<User>> getPageList(Page<User> p, User u) {
//        return userService.getPageList(p,null);
//    }
//}
