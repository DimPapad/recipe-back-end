package com.group.project.controllers;

import com.group.project.dto.UserDTO;
import com.group.project.models.User;
import com.group.project.services.UserServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andreas
 */
@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInterface userServ;

    @GetMapping("/all")
    public List<UserDTO> showAllUsers() {
        return userServ.getAllUsers();
    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable Integer id) {
        return userServ.getUserById(id);
    }
    
    @GetMapping("/search/{name}")
    public List<UserDTO> searchByname(@PathVariable String name) {
        return userServ.searchByName(name);
    }

    @PostMapping("/create")
    public User addUser(@RequestBody User u) {
        return userServ.createUser(u);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User u) {
        return userServ.updateUser(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userServ.deleteUser(id);
    }

    @GetMapping("/{email}/{password}")
    public User NoName (@PathVariable String email,@PathVariable String password) {
        return userServ.findByEmailAndPassword(email,password);
    }
}
