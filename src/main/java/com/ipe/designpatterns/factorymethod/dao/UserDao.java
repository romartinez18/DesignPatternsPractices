package com.ipe.designpatterns.factorymethod.dao;

import com.ipe.designpatterns.factorymethod.adapter.DBAdapter;
import com.ipe.designpatterns.factorymethod.factory.DBFactory;
import com.ipe.designpatterns.factorymethod.pojo.User;
import java.sql.*;
import java.util.*;
        
/**
 *
 * @author Ronald
 */
public class UserDao {
    private DBAdapter dbManager;
    
    /**
     *
     */
    public UserDao() {
        dbManager = DBFactory.getDefaultConnection();
    }
    
    /**
     *
     * @return
     */
    public List<User> listAllUsers() {
        Connection connection = dbManager.getConnection();
        List<User> allUsers = new ArrayList<>();
        String queryAllUsers = "SELECT * FROM user";
        
            try {
                // Preparing the query
                PreparedStatement stm = connection.prepareStatement(queryAllUsers);
                // Send the query and return the records
                ResultSet result = stm.executeQuery();
                
                // Iterating while records exists
                while(result.next()) {
                    String name = result.getString("name");
                    String lastname = result.getString("lastname");
                    String username = result.getString("username");
                    String password = result.getString("password");
                    
                    User user = new User(name, lastname, username, password);
                        allUsers.add(user);
                }
                
                stm.close();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection(connection);
            }
        
      return allUsers;
    }
    
    /**
     *
     * @param user
     * @return
     */
    public boolean newUser(User user) {
        Connection connection = dbManager.getConnection();
        boolean isCreatedUser = false;
        String insertUser = "INSERT INTO user(name, lastName, username, "
                                + "password) VALUES (?,?,?,?)";
        
            try {
                // Preparing the query
                PreparedStatement stm = connection.prepareStatement(insertUser);
                stm.setString(1, user.getName());
                stm.setString(2, user.getLastName());
                stm.setString(3, user.getUsername());
                stm.setString(4, user.getPassword());
                
                // Send the query
                stm.executeUpdate();
                isCreatedUser = true;
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection(connection);
            }
        
      return isCreatedUser;
    }
    
    private void closeConnection(Connection connection) {
        try {
            // Release the connection
            connection.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
