/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.repositories;

import com.group.project.models.Bought;
import com.group.project.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mhtso
 */
@Repository
public interface BoughtRepo extends JpaRepository<Bought, Integer> {

    public List<Bought> findAllByUserId(User user);

}
