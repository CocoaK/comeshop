//package com.eshop.serviceapp.controller;
//
//import com.eshop.serviceapp.service.IBaseService;
//import com.eshop.serviceapp.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
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
//    @RequestMapping("/add2")
//    public String get(User user) {
//        User u = new User();
//        u.setUsername(user.getUsername());
//        u.setPassword(user.getPassword());
//       int i = userService.add(u);
//        return "user:"+i;
//    }
//
//    @RequestMapping("/getByUsername")
//    public String getByUsername(String username) {
//        User u = userService.getByUsername(username);
//        return "user:"+u;
//    }
//
//    @RequestMapping("/getByUser")
//    public String getByUser(@RequestBody @Validated User user) {
//        User u = userService.getByUser(user);
//        return "user:"+u;
//    }
//}
