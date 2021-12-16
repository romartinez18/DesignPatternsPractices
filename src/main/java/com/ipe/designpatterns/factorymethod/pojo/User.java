package com.ipe.designpatterns.factorymethod.pojo;

/**
 *
 * @author Ronald
 */
public class User {
    private int id;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private boolean isAdmin = false;

    /**
     *
     */
    public User() {
        this.name = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
    }
    
    /**
     *
     * @param name
     * @param lastName
     * @param username
     * @param password
     */
    public User(String name, String lastName, String username, 
                String password) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + '}';
    }
    
}
