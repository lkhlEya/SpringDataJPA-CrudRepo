package tn.exam.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.exam.exam.entity.User;
import tn.exam.exam.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAll() {
        return iUserService.getAllUsers();
    }



    @GetMapping("/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") Long id) {
        return iUserService.getUser(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return iUserService.addUser(user);
    }

    @PostMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return iUserService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Boolean deleteUser(@PathVariable Long id)
    {
        return iUserService.deleteUSer(id);
    }

}
