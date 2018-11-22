package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/f1")
    public void f1()
    {
        System.out.println(1/0);
    }
    @RequestMapping("/f2")
    public void f2()
    {

        int[] is = new int[]{1,3,5,78};
        System.out.println(is[6]);
    }
    @RequestMapping("/f3")
    public void f3()
    {
        String s = null;
        System.out.println(s.length());
    }
    @RequestMapping("/f4")
    public void f4() throws Exception {
        throw new Exception("error");
    }


    @RequestMapping("/f5")
    public void f5() throws Exception {
        throw new Exception("error");
    }
}
