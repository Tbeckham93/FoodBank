
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Donor class
 * @author Randy
 */
public class Donor extends User {

    private int totalGiven = 0;
    ArrayList<Food> food;

    /**
     *Donor constructor
     * @param id
     * @param name
     */
    public Donor(int id, String name) {
        super(id, name);
    }

    /**
     *gets total items gievn
     * @return
     */
    public int getTotalGiven() {
        return totalGiven;
    }

    /**
     * lets the donor add a food item of either perishable or non-perishable
     * @throws InputMismatchException
     * @throws NullPointerException
     */
    public void addFood() throws InputMismatchException, NullPointerException {//throws to main --  MAIN METHOD 6
        Scanner scn = new Scanner(System.in);
        boolean tryExit = false;
        int dupIdCatch = 0;
        dupIdCatch = dupIdCatch + 7;//var to make sure the id of food isnt repeated even if some of them are removed

        while (tryExit != true) {
            System.out.println("If this item perishable or not? Please press (1) for YES or (2) for NO.");//asks if the new food is perishable or not
            int userInput;
            userInput = scn.nextInt();
            scn.nextLine();
            while (userInput != 1 && userInput != 2) {//catch of non- 1 or 2's
                System.out.println("You didnt pick 1 or 2, try again.");
                userInput = scn.nextInt();
            }
            if (userInput == 1) {
                System.out.println("Enter the DAY the food goes bad in form XX");//if perishable lets the donor enter the bad by day, month and year
                int badByDay = scn.nextInt();
                scn.nextLine();
                System.out.println("Enter the MONTH the food goes bad in form XX");
                int badByMonth = scn.nextInt();
                scn.nextLine();
                System.out.println("Enter the YEAR the food goes bad in form XXXX");
                int badByYear = scn.nextInt();
                String name = scn.nextLine();
                System.out.println("Give date given as XX/XX/XXXX");
                String dateGiven = scn.nextLine();
                int id = food.size() + 999 + dupIdCatch;//giving in id to the food
                food.add(new Perishable(badByDay, badByMonth, badByYear, name, dateGiven, id));//adding it to the array
                totalGiven++;
                System.out.println("You have given ");
                System.out.println(totalGiven);//telling the donor how many items they have given so they can feel good about themselves
            }
            if (userInput == 2) {
                String name = scn.nextLine();
                System.out.println("Give date given as XX/XX/XXXX");//date given
                String dateGiven = scn.nextLine();
                int id = food.size() + 999 + dupIdCatch;//gives id to food
                food.add(new Nonperishable(name, dateGiven, id));//add the food
                totalGiven++;
                System.out.println("You have given ");
                System.out.println(totalGiven);
            }
            tryExit = true;
        }

    }
}
