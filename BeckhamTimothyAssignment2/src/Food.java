
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *class food
 * @author Randy
 */
public class Food {
    private String name;
    private String dataGiven;
    private int id;
    private ArrayList<Food> food;

    /**
     *constructor
     * @param name
     * @param dataGiven
     * @param id
     */
    public Food(String name, String dataGiven, int id) {
        food = new ArrayList<>();//sets the array for new food items
        this.name = name;
        this.dataGiven = dataGiven;
        this.id = id;
    }
    
    /**
     *sets given date given
     * @param dataGiven
     */
    public void setDataGiven(String dataGiven) {//setter
        this.dataGiven = dataGiven;
    }

    /**
     *gets date given
     * @return
     */
    public String getDataGiven() {//getter
        return dataGiven;
    }

    /**
     *gets the id of the food
     * @return
     */
    public int getId() {//gett for id
        return id;
    }

    /**
     *gets the food in array
     * @return
     */
    public ArrayList<Food> getFood() {//getter for food array
        return food;
    }
}
