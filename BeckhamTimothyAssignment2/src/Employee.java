
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Employee class
 * @author Randy
 */
public class Employee extends User {// cild of User class

    private int hoursWorked;
    private int pay;
    private final int hourlyPay;
    private ArrayList<Food> food;

    /**
     *Employee constructor - sets pay per hour to 15
     * @param id
     * @param name
     */
    public Employee(int id, String name) {
        super(id, name);
        hourlyPay = 15;
    }

    /**
     *gets the hours the employee worked
     * @return
     */
    public int getHoursWorked() {//gets hours worked
        return hoursWorked;
    }

    /**
     *sets the hours worked
     * @param hoursWorked
     */
    public void setHoursWorked(int hoursWorked) {//sets hours worked
        this.hoursWorked = hoursWorked;
    }

    /**
     *gets the pay of the employee based on hourly pay and hours worked
     * @return
     */
    public int getPay() {//gets pay based on hourly pay and hours worked
        return pay = getHourlyPay() * getHoursWorked();
    }

    /**
     *gets hourly pay
     * @return
     */
    public int getHourlyPay() {//gets hourly pay
        return hourlyPay;
    }

    /**
     *lets the employee give a food item away
     * @return @throws InputMismatchException
     * @throws NullPointerException
     */
    public boolean giveFoodItem() throws InputMismatchException, NullPointerException { //throws to main  -- MAIN METHOD 7
        boolean isFoodIn = false; //bool to check if food is in
        int id;
        Scanner scn = new Scanner(System.in);
        boolean tryExit = false;

        while (tryExit != true) {//sets loop
            System.out.println("What is the id of the food item for check out?");
            id = scn.nextInt();
            scn.nextLine();
            for (int i = 0; i < food.size(); i++) {//loop to check for id in food array
                if (id == food.get(i).getId()) {
                    isFoodIn = true;//food was found
                    if (food.get(i) instanceof Perishable) {//checks if food is perishable if so gets todays day, month and year to make sure food is still good
                        System.out.println("Enter the todays year is form XXXX");
                        int tYear = scn.nextInt();
                        System.out.println("Enter the todays month is form XX");
                        int tMonth = scn.nextInt();
                        System.out.println("Enter the todays day is form XX");
                        int tDay = scn.nextInt();
                        if (tYear == ((Perishable) food.get(i)).getBadByYear()) {//checking if food is good still
                            if (tMonth == ((Perishable) food.get(i)).getBadByMonth()) {
                                if (tDay > ((Perishable) food.get(i)).getBadByDay()) {
                                    System.out.println("Sorry, this product is bad and will be removed.");
                                    food.remove(i);
                                }
                            } else if (tMonth > ((Perishable) food.get(i)).getBadByMonth()) {
                                System.out.println("Sorry, this product is bad and will be removed.");//letting the person know they cant get the item because it's bad.
                                food.remove(i);//still removes if the item is bad or good
                            }
                        } else if (tYear > ((Perishable) food.get(i)).getBadByYear()) {//get the bad by year of item to check vs the days date
                            System.out.println("Sorry, this product is bad and will be removed.");
                            food.remove(i);
                        } else {
                            System.out.println("Thank you for stopping by, here's your food.");
                            food.remove(i);
                        }
                    }
                    if (food.get(i) instanceof Nonperishable) {//if the food is nonperishable, it will give it out and remove
                        System.out.println("Thank you for stopping by, here's your food.");
                        food.remove(i);
                        break;
                    }
                }
                if (i == food.size() - 1 && isFoodIn != true) {//lets them no the id is not in the array
                    System.out.println("The Item with the id " + id + " does not exist.");
                }
            }
            tryExit = true;
        }

        return isFoodIn;
    }
}
