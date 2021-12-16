package com.ipe.designpatterns.factorymethod;

import com.ipe.designpatterns.factorymethod.dao.UserDao;
import com.ipe.designpatterns.factorymethod.pojo.User;
import java.util.List;

/**
 * Entry class
 */
public class Principal {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Initiation Factory Method....");
        
        UserDao userService = new UserDao();
        
            List<User> allUsers = userService.listAllUsers();
            System.out.println(allUsers);
    }
    
}
