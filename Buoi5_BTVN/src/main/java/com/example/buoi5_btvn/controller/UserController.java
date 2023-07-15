package com.example.buoi5_btvn.controller;

import com.example.buoi5_btvn.model.User;
import com.example.buoi5_btvn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = {"/","/login","home"})
    public String login() {
        return "login";
    }
    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        List<User> users = userService.getUserAll();
        for (User user:users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {

                return "redirect:/store";
            }
        }
        model.addAttribute("messageErrLogin", "Thông tin đăng nhập không hợp lệ!");
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "login";
    }

    @GetMapping(value = "/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/signup")
    public String signup(Model model,@RequestParam String username,@RequestParam String password,@RequestParam String fullname) {
        List<User> users = userService.getUserAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("messageErrSignup", "Thông tin username đã tồn tại!!");
                model.addAttribute("username",username);
                model.addAttribute("password",password);
                model.addAttribute("fullname",fullname);
                return "signup";
            }
        }
        userService.createUser(new User(username,password,fullname));
        return "redirect:login";
    }
    @GetMapping("/store")
    public String store(Model model) {
        List<User> users = userService.getUserAll();
        model.addAttribute("users",users);
        return "store";
    }
    @GetMapping("/edit/{id}")
    public String viewedit(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        Object messageErrEdit = redirectAttributes.getFlashAttributes().get("messageErrEdit");
        if (messageErrEdit != null) {
            model.addAttribute("messageErrEdit", messageErrEdit);
        }
        return "edit";
    }
//    @GetMapping("/edit/{id}")
//    public String viewedit(Model model, @PathVariable Long id, @ModelAttribute("messageErrEdit") String messageErrEdit) {
//        User user = userService.findUserById(id);
//        model.addAttribute("user",user);
//        if (messageErrEdit != null) {
//            model.addAttribute("messageErrEdit", messageErrEdit);
//        }
//        return "edit";
//    }
    @PostMapping("/edit")
    public String edit (@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        List<User> users = userService.getUserAll();
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername()) && user1.getId()!=user.getId()) {
                redirectAttributes.addFlashAttribute("messageErrEdit", "Thông tin username đã tồn tại!");
                return "redirect:/edit/" + user.getId();
            }
        }
        userService.updateUser(user);
        return "redirect:store";
    }
    @GetMapping("/delete/{id}")
    public String viewdelete(@PathVariable Long id,Model model) {
        model.addAttribute("id",id);
        return "confirmdelete";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:store";
    }

    @GetMapping("/logout")
    public String logout() {
        return "confirmlogout";
    }

}
