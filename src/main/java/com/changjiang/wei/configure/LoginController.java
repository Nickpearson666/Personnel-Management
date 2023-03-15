package com.changjiang.wei.configure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                            Model model, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("user",username);
            System.out.println(Math.pow(2.0, 500000003));
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","Password or Username is incorrect");
            return "index";
        }

    }

    @RequestMapping("/user/signout")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/main.html";
    }

}
