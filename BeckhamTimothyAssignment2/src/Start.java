
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * driver class
 *
 * @author Randy
 */
public class Start {           //My big main methods used ---- #1 donorAddFood() -- #2 employeeMenu() -- #3 fireEmployee() -- #4 newDonor() -- #5 hireEmployee() -- #6 addFood() -- #7 giveFoodItem()

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) { //THIS SHOULD COUNT AS MAIN METHOD 8
        int exit = 0; //exits the while loop on 1
        int userPick = 0;//tracks the users input to go from one option to the next
        FoodBank myFoodBank = new FoodBank("The Food Bank");//sets up the food bank to use (the object)
        Scanner scn = new Scanner(System.in);

        while (exit != 1) {//while loop goes till user enters a 1 at the end of the loop
            try {
                System.out.println("Are you a new user? Enter 1 for new user or 2 for returning user.");
                userPick = scn.nextInt();//user picks 1 or 2 based on needs
                scn.nextLine();
                while (userPick != 1 && userPick != 2) {//catch incase it's not a 1 or 2
                    System.out.println("Pleas pick either 1 or 2.");
                    userPick = scn.nextInt();
                    scn.nextLine();
                }
                if (userPick == 1) {//user picked 1 for new user
                    System.out.println("Are you a new donor or a new employee? Press 1 for donor or 2 for employee.");
                    userPick = scn.nextInt();
                    scn.nextLine();
                    while (userPick != 1 && userPick != 2) {//catch for anything thats not a 1 or 2
                        System.out.println("Please pick 1 or 2.");
                        userPick = scn.nextInt();
                        scn.nextLine();
                    }
                    if (userPick == 1) {//if for user pick 1(donor) - calls newDonor one of the major methods
                        myFoodBank.newDonor(); //method 1
                    }
                    if (userPick == 2) {// user picked 2(employee) - calls hireEmployee one of the major methods
                        myFoodBank.hireEmployee(); //method 2
                    }
                } else if (userPick == 2) {//user picked 2 for returning user
                    System.out.println("Are you an employee or donor? Press 1 for employee or 2 for donor.");
                    userPick = scn.nextInt();
                    scn.nextLine();
                    while (userPick != 1 && userPick != 2) {//catch for input thats not 1 or 2
                        System.out.println("Pleas pick either 1 or 2.");
                        userPick = scn.nextInt();
                        scn.nextLine();
                    }
                    if (userPick == 1) {//user picked 1 for employee which opens the menu for employees another major method
                        myFoodBank.employeeMenu();//method 3
                    }
                    if (userPick == 2) {//picked 2 which is a returning donor calls another major method
                        myFoodBank.donorAddFood();//method 4
                    }
                }
                System.out.println("Would you like to quit? 1 for yes, 0 for no.");//asks if the user wants to exit
                exit = scn.nextInt();
                scn.nextLine();
                while (userPick != 1 && userPick != 0) {//catch for anything thats not a 1 or 0
                    System.out.println("Please pick 1 or 0.");
                    userPick = scn.nextInt();
                    scn.nextLine();
                }
            } catch (InputMismatchException ex) {//catch for non-ints and null pointers
                System.out.println("Please input a number.");
                scn.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Please enter an input.");
            }
        }
    }
}
