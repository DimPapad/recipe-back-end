package com.group.project.repositories;

import com.group.project.dto.UserDTO;
import com.group.project.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andreas
 */
@Component
public interface UserRepo extends JpaRepository<User, Integer> {
    
    @Query("SELECT u FROM User u")
    List<UserDTO> findAllUsers();
    
    List<UserDTO> findByNameContainingIgnoreCase(String name);

    User findByIdAndNameContainsIgnoreCase(Integer id,String name);

    User findByEmailAndPassword(String email, String password);
    
    User findByName(String name);
    
    User findByEmail(String email);
    
}
