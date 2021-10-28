/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Hoang Loc
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String address;
    private Date birthday;
    private String sex;
    private String description;

    public User() {
    }

    public User(int id, String username, String password, String address, Date birthday, String sex, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public Object[] toObjects() {
        return new Object[] {
            id, username, password, address, birthday, sex, description
        };
    }
}
