package com.group.project.services;

import com.group.project.dto.UserDTO;
import com.group.project.models.User;
import java.util.List;

/**
 *
 * @author Andreas
 */
public interface UserServiceInterface {
    
    public User createUser(User u);
    
    public User getByUsername(String name);
    
    public List<UserDTO> searchByName(String name);
    
    public List<UserDTO> getAllUsers();
    
    public User getUserById(Integer id);
    
    public User updateUser(User u);
    
    public void deleteUser(Integer id);

    public User getByIdAndByNameContainingIgnoreCase(Integer id, String name);

    User findByEmailAndPassword(String email, String password);
    
}
