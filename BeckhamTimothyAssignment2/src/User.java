
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *User class
 * @author Randy
 */
public class User {
    private int id;
    private String name;
    ArrayList<User> user;

    /**
     *User constructor 
     * @param id 
     * @param name 
     */
    public User(int id, String name) {
        user = new ArrayList<>();//new user in the array
        this.id = id;
        this.name = name;
    }

    /**
     *gets the user id
     * @return id
     */
    public int getId() {//gets id
        return id;
    }

    /**
     *gets the name of user
     * @return name
     */
    public String getName() {//gets name
        return name;
    }
    
    /**
     *gets the users
     * @return user array
     */
    public ArrayList<User> getUser() {//gets the users in array
        return user;
    }
}
