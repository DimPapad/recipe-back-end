/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author georg
 */
@Entity
@Table(name = "friendship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f"),
    @NamedQuery(name = "Friendship.findByFriendshipId", query = "SELECT f FROM Friendship f WHERE f.friendshipId = :friendshipId"),
    @NamedQuery(name = "Friendship.findByRequestValid", query = "SELECT f FROM Friendship f WHERE f.requestValid = :requestValid")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "friendship_id")
    private Integer friendshipId;
    @Column(name = "request_valid")
    private Boolean requestValid;
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User friendId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;

    public Friendship() {
    }

    public Friendship(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Boolean getRequestValid() {
        return requestValid;
    }

    public void setRequestValid(Boolean requestValid) {
        this.requestValid = requestValid;
    }

    public User getFriendId() {
        return friendId;
    }

    public void setFriendId(User friendId) {
        this.friendId = friendId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipId != null ? friendshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipId == null && other.friendshipId != null) || (this.friendshipId != null && !this.friendshipId.equals(other.friendshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Friendship[ friendshipId=" + friendshipId + " ]";
    }
    
}
