package com.group.project.services;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import com.group.project.repositories.FriendshipRepo;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipServiceInterface{

    @Autowired
    FriendshipRepo friendshipRepo;

    @Autowired
    UserService userService;

    @Override
    public void addFriend(Integer userID, Integer friendID) {
        Friendship f = new Friendship();
        f.setRequestValid(true);
        f.setUserId(userService.getUserById(userID));
        f.setFriendId(userService.getUserById(friendID));
        friendshipRepo.save(f);
    }

    @Override
    public void deleteFriend(Integer friendshipID) {
        friendshipRepo.deleteById(friendshipID);
    }

    @Override
    public List<User> showFriends(Integer userID, String name) {
        User u = userService.getUserById(userID);
        List<Friendship> friendships = friendshipRepo.findByUserId(u);
        List<User> friends = new ArrayList<>();
        for (Friendship friendship : friendships)  {
            if (friendship.getRequestValid()) {
                if(userService.getByIdAndByNameContainingIgnoreCase(friendship.getFriendId().getId(), name)!=null) {
                    friends.add(userService.getByIdAndByNameContainingIgnoreCase(friendship.getFriendId().getId(), name));
                }
            }
        }

        return (friends);
    }

    @Override
    public List<User> showFriends(Integer userID) {
        User u = userService.getUserById(userID);
        List<Friendship> friendships = friendshipRepo.findByUserId(u);
        List<User> friends = new ArrayList<>();
        for (Friendship friendship : friendships)  {
            if (friendship.getRequestValid()) {
                //friends.add(userService.getUserById(friendship.getFriendId().getId()));
                friends.add(friendship.getFriendId());
            }
        }

        return (friends);
    }

    @Override
    public Friendship getFriendship(Integer friendshipID) {
        return (friendshipRepo.findByFriendshipId(friendshipID));
    }

    @Override
    public boolean checkFriendship(Integer userID, Integer friendID) {
        Friendship tmp = friendshipRepo.findByUserIdAndFriendId(
                userService.getUserById(userID),
                userService.getUserById(friendID));
        if (tmp != null) {
            return tmp.getRequestValid();
        }
        return false;
    }

}
