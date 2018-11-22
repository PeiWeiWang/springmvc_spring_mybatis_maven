package net.wanho.service;

import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*
service层 服务层肯定是相比之下比较高层次的一层结构，相当于将几种操作封装起来，至于为什么service层要使用接口来定义有以下几点好处：
service实现类：也顾名思义，service实现类实现了service接口，进行具体的业务操作。
在java中接口是多继承的，而类是单继承的，如果你需要一个类实现多个service，你用接口可以实现，用类定义service就没那么灵活
要提供不同的数据库的服务时，我们只需要面对接口用不同的类实现即可，而不用重复地定义类
编程规范问题，接口化的编程为的就是将实现封装起来，然调用者只关心接口不关心实现，也就是“高内聚，低耦合”的思想。
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public List<User> queryUsers() throws Exception {
        return userMapper.queryUsers();
    }
}
