
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *FoodBank class
 * @author Randy
 */
public class FoodBank {

    private String name;
    ArrayList<User> user;

    /**
     *constructor sets name of foodbank
     * @param name
     */
    public FoodBank(String name) {
        this.name = name;
        user = new ArrayList<>();//new users
    }

    /**
     *Lets the food bank hire a new employee
     * @throws InputMismatchException
     * @throws NullPointerException
     */
    public void hireEmployee() throws InputMismatchException, NullPointerException {//throws to main --  MAIN METHOD 5
        String nameFirst;
        String nameLast;
        int employCatch = 0;
        employCatch = employCatch + 7;//same id catch
        boolean tryExit = false;
        int id; //try catch
        
        while (tryExit != true) {
            Scanner scn = new Scanner(System.in);
            System.out.println("What is the employees name? First name");//get first name
            nameFirst = scn.nextLine();
            System.out.println("What is the employees name? Last name");//get last name
            nameLast = scn.nextLine();
            id = 10000 + user.size() + employCatch;//new id for employee
            String name = nameLast + " " + nameFirst;
            System.out.println("Name: " + name + " id: " + id);//tells name and new id
            user.add(new Employee(id, name));//adds them to array
            tryExit = true;
        }

    }

    /**
     *lets the food bank create a new donor object
     * @throws InputMismatchException
     * @throws NullPointerException
     */
    public void newDonor() throws InputMismatchException, NullPointerException {//throws to main  --  MAIN METHOD 4
        String nameFirst;
        String nameLast;
        boolean tryExit = false;
        int id;

        while (tryExit != true) {
            Scanner scn = new Scanner(System.in);
            System.out.println("What is your first name?");//first name
            nameFirst = scn.nextLine();
            System.out.println("What is your last name?");//last name
            nameLast = scn.nextLine();
            id = 1000 + user.size();
            String name = nameLast + " " + nameFirst;
            System.out.println("Name: " + name + " id: " + id);//shows name and new id to user
            user.add(new Donor(id, name));//adds user
            tryExit = true;
        }

    }

    /**
     *lets the food bank fire employee
     * @return if the employee is in the system
     * @throws InputMismatchException
     */
    public boolean fireEmployee() throws InputMismatchException {//throws to main --   MAIN METHOD 3
        int id;
        boolean isIdHere = false;
        Scanner scn = new Scanner(System.in);

        while (isIdHere == false) {//loops till id is entered and in the system
            System.out.println("Enter the id of the employee you want to fire.");
            id = scn.nextInt();
            scn.nextLine();
            for (int i = 0; i < user.size(); i++) {//loop to find the id or the employee
                if (user.get(i) instanceof Employee) {//makes sure the id is an employee and not a donor
                    if (id == user.get(i).getId()) {
                        user.remove(i);//removes them
                        isIdHere = true;//found it!
                        break;
                    }
                    if (i == user.size() - 1 && isIdHere != true) {//wasnt in the system, try again
                        System.out.println("The Item with the id " + id + " does not exist. Please try again");
                    }
                }
            }
        }

        return isIdHere;
    }

    /**
     * Shows the menu of everything the employee can do
     *@throws ImputMismatchException
     */
    public void employeeMenu() throws InputMismatchException{//throws to main   -- MAIN METHOD 2
        Scanner scn = new Scanner(System.in);
        int userPick = 0;
        System.out.println("Enter your id please.");//enter id
        int id = scn.nextInt();
        scn.nextLine();
        
        for (int i = 0; i < user.size(); i++) {//finds the employee by id
            if (user.get(i).getId() == id) {

                if (user.get(i) instanceof Employee) {//catch to make sure it's in employee and not a donor
                    System.out.println("Welcome " + user.get(i).getName());
                    System.out.println("What would you like to see, employee?");
                    int k = 0;
                    while (k < 1) {
                        System.out.println("press 1 to set how many hours you've worked (total), press 2 for pay based on how many hours you've worked so far, press 3 to give a food item to the needy or press 4 to fire an employee.");
                        userPick = scn.nextInt();
                        scn.nextLine();
                        if (userPick == 1) {
                            System.out.println("How many hours have you worked this week?");//employee sets how many hours the worked.
                            int hoursWork = scn.nextInt();
                            scn.nextLine();
                            ((Employee) user.get(i)).setHoursWorked(hoursWork);
                        }
                        if (userPick == 2) {//shows how much the employee will make based off hours worked and pay per hour
                            System.out.println("At the moment you'll make $ " + ((Employee) user.get(i)).getPay());
                        }
                        if (userPick == 3) {//lest the employee give a food item
                            ((Employee) user.get(i)).giveFoodItem(); //calls givefooditem
                        }
                        if(userPick == 4){//lets employee fire someone
                            fireEmployee();
                        }

                        System.out.println("Would you like to do something else.(Yes or No)");//asks if they would like to do something else
                        String yorn = scn.nextLine();
                        yorn = yorn.toLowerCase();
                        while (!yorn.equals("yes") && !yorn.equals("no")) {//makes sure they entered yes or no
                            System.out.println("Please enter either yes or no");
                            yorn = scn.nextLine();
                            yorn = yorn.toLowerCase();
                        }
                        if (yorn.equals("no")) {//if they're done, ends loop
                            k++;
                        }
                    }

                }
            }
        }
    }

    /**
     * lets the donor add a food item to the bank
     *@throws ImputMismatchException
     */
    public void donorAddFood() throws InputMismatchException{//throws to main  MAIN METHOD 1
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your id please.");
        int id = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < user.size(); i++) {//finds the donor
            if (user.get(i).getId() == id) {
                if (user.get(i) instanceof Donor) {//checks for donor
                    System.out.println("Welcome " + user.get(i).getName());
                    ((Donor) user.get(i)).addFood(); //lets donor add food item
                }
            }
        }
    }
}
