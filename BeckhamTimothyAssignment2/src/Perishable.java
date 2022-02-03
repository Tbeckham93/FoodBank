/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *perishable class
 * @author Randy
 */
public class Perishable extends Food { //child of food
    private int badByDay;
    private int badByMonth;
    private int badByYear;
    private String todaysDate;

    /**
     *constructor
     * @param badByDay
     * @param badByMonth
     * @param badByYear
     * @param name
     * @param dataGiven
     * @param id
     */
    public Perishable(int badByDay, int badByMonth, int badByYear, String name, String dataGiven, int id) {
        super(name, dataGiven, id);
        this.badByDay = badByDay;
        this.badByMonth = badByMonth;
        this.badByYear = badByYear;
    }

    /**
     *gets the bad by day
     * @return
     */
    public int getBadByDay() { //gets day by day
        return badByDay;
    }

    /**
     *gets sets the bad by day
     * @param badByDay
     */
    public void setBadByDay(int badByDay) {//sets bad bay
        this.badByDay = badByDay;
    }

    /**
     *gets the bad by month
     * @return
     */
    public int getBadByMonth() {//gets bad month
        return badByMonth;
    }

    /**
     *sets the bad by month
     * @param badByMonth
     */
    public void setBadByMonth(int badByMonth) {//sets bad month
        this.badByMonth = badByMonth;
    }

    /**
     *gets the bad by year
     * @return
     */
    public int getBadByYear() {//gets bad year
        return badByYear;
    }

    /**
     *sets the bad by year
     * @param badByYear
     */
    public void setBadByYear(int badByYear) {//sets bad year
        this.badByYear = badByYear;
    }

    /**
     *gets todays date
     * @return
     */
    public String getTodaysDate() {//gets todays date
        return todaysDate;
    }

    /**
     *sets todays date
     * @param todaysDate
     */
    public void setTodaysDate(String todaysDate) {//sets todays date
        this.todaysDate = todaysDate;
    }
}
