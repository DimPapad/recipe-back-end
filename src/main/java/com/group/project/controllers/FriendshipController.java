package com.group.project.controllers;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import com.group.project.services.FriendshipServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/friendship")
public class FriendshipController {

    @Autowired
    FriendshipServiceInterface friendshipServiceInterface;


    /*
    Add a Friend.
     */
    @PostMapping("/addFriend/{userID}/{friendID}")
    void addFriend(@PathVariable Integer userID, @PathVariable Integer friendID) {
        friendshipServiceInterface.addFriend(userID,friendID);
    }

    /*
    Delete a Friend From an ID
     */
    @DeleteMapping("/deleteFriend/{friendshipID}")
    void deleteFriend(@PathVariable Integer friendshipID) {
        friendshipServiceInterface.deleteFriend(friendshipID);
    }

    /*
    Show all of User's Friends whose Name contains, said string.
     */
    @GetMapping("/friends/{userID}/{name}")
    List<User> showAllFriends(@PathVariable Integer userID, @PathVariable (value = "name") String name) {
        return friendshipServiceInterface.showFriends(userID, name);
    }

    @GetMapping("/friends/{userID}")
    List<User> showAllFriends(@PathVariable Integer userID) {
        return friendshipServiceInterface.showFriends(userID);
    }
    /*
    Check's if logged-in User is friend with another user.
     */
    @GetMapping("/friend/{userID}/{friendID}")
    boolean checkFriendship(@PathVariable Integer userID,@PathVariable Integer friendID){
        return friendshipServiceInterface.checkFriendship(userID, friendID);
    }

}
