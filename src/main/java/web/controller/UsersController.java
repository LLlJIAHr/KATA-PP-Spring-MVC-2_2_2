package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public ModelAndView showAllUsers(Model userModel) {
        userModel.addAttribute("allUsers", userService.getAllUsers());
        return new ModelAndView("users");
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model userModel) {
        userModel.addAttribute("man", userService.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUserPage(@ModelAttribute("userBoy") User user) {
        return "new";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editeUserPage(@PathVariable Long id, Model userModel) {
        userModel.addAttribute("userUpdate", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
