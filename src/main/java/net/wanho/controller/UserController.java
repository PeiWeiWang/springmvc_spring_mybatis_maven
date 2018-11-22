package net.wanho.controller;

import net.wanho.pojo.User;
import net.wanho.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
/*
dao层数据访问层 data access object，比较底层，比较基础的操作，具体到每个表的增删改查
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/query")
    @ResponseBody
    public String queryUsers() throws Exception {
        List<User> list = userService.queryUsers();
        return "success";
    }

}
