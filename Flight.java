/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegeproject;

import java.util.ArrayList;


public class Flight extends Passenger {
    protected String to, from, classification;
    public int flightNumber2, seatNum, numOfSeats, availableSeats, takeOffMinute, takeOffHour, takeOffDay, takeOffMonth, takeOffYear, flightDuration, landingMinute, landingHour, landingDay, landingMonth, landingYear;
    public static int flightNum = 1;
    public static ArrayList<Flight> arrayList = new ArrayList<>();

    public Flight() {
    }

    public Flight(double cost, String FlayingClass, String ownerName, String phoneNumber) {
        super(cost, FlayingClass, ownerName, phoneNumber);
    }

    public Flight(String firstName, String secondName, String e_mail, String gender, String number, String passportNum, int age) {
        super(firstName, secondName, e_mail, gender, number, passportNum, age);
    }

    public Flight(Flight F) {
        this.flightNumber2 = arrayList.size()+1;;
        this.to = F.to;
        this.from = F.from;
        this.numOfSeats = F.numOfSeats;
        this.takeOffMinute = F.takeOffMinute;
        this.takeOffHour = F.takeOffHour;
        this.takeOffDay = F.takeOffDay;
        this.takeOffMonth = F.takeOffMonth;
        this.takeOffYear = F.takeOffYear;
        this.landingMinute = F.landingMinute;
        this.landingHour = F.landingHour;
        this.landingDay = F.landingDay;
        this.landingMonth = F.landingMonth;
        this.landingYear = F.landingYear;
    }

    public Flight(String to, String from, int numOfSeats, int takeOffMinute, int takeOffHour, int takeOffDay, int takeOffMonth, int takeOffYear, int flightDuration, int landingMunite, int landingHour, int landingDay, int landingMonth, int landingYear) {
        this.flightNumber2 = arrayList.size()+1;
        this.to = to;
        this.from = from;
        this.numOfSeats = numOfSeats;
        this.takeOffMinute = takeOffMinute;
        this.takeOffHour = takeOffHour;
        this.takeOffDay = takeOffDay;
        this.takeOffMonth = takeOffMonth;
        this.takeOffYear = takeOffYear;
        this.flightDuration = flightDuration;
        this.landingMinute = landingMunite;
        this.landingHour = landingHour;
        this.landingDay = landingDay;
        this.landingMonth = landingMonth;
        this.landingYear = landingYear;
    }


    public static int[] calculateLandingTime(int takeOffMinute, int takeOffHour, int takeOffDay, int takeOffMonth, int takeOffYear, int flightDuration) {
        int totalMunites = takeOffMinute + (takeOffHour * 60) + (takeOffDay * 24 * 60) + ((takeOffMonth - 1) * 30 * 24 * 60) + ((takeOffYear - 1970) * 365 * 24 * 60);
        int landingTotalMunites = totalMunites + flightDuration;
        int landingYear = 1970 + (landingTotalMunites / (365 * 24 * 60));
        int landingMonth = 1 + ((landingTotalMunites % (365 * 24 * 60)) / (30 * 24 * 60));
        int landingDay = ((landingTotalMunites % (30 * 24 * 60)) / (24 * 60));
        int landingHour = (landingTotalMunites % (24 * 60)) / 60;
        int landingMunite = landingTotalMunites % 60;

        return new int[]{landingMunite, landingHour, landingDay, landingMonth, landingYear};
    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTakeOffMinute() {
        return takeOffMinute;
    }

    public void setTakeOffMinute(int takeOffMinute) {
        this.takeOffMinute = takeOffMinute;
    }

    public int getTakeOffHour() {
        return takeOffHour;
    }

    public void setTakeOffHour(int takeOffHour) {
        this.takeOffHour = takeOffHour;
    }

    public int getTakeOffDay() {
        return takeOffDay;
    }

    public void setTakeOffDay(int takeOffDay) {
        this.takeOffDay = takeOffDay;
    }

    public int getTakeOffMonth() {
        return takeOffMonth;
    }

    public void setTakeOffMonth(int takeOffMonth) {
        this.takeOffMonth = takeOffMonth;
    }

    public int getTakeOffYear() {
        return takeOffYear;
    }

    public void setTakeOffYear(int takeOffYear) {
        this.takeOffYear = takeOffYear;
    }

    public int getLandingMinute() {
        return landingMinute;
    }


    public int getLandingHour() {
        return landingHour;
    }


    public int getLandingDay() {
        return landingDay;
    }


    public int getLandingMonth() {
        return landingMonth;
    }


    public int getLandingYear() {
        return landingYear;
    }


    public int getFlightNumber2() {
        return flightNumber2;
    }
    public void setFlightNumber2(int num){
        this.flightNumber2 = num;
    }


    public  int getFlightNum() {
        return flightNum;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public void setLandingMinute(int landingMinute) {
        this.landingMinute = landingMinute;
    }

    public void setLandingHour(int landingHour) {
        this.landingHour = landingHour;
    }

    public void setLandingDay(int landingDay) {
        this.landingDay = landingDay;
    }

    public void setLandingMonth(int landingMonth) {
        this.landingMonth = landingMonth;
    }

    public void setLandingYear(int landingYear) {
        this.landingYear = landingYear;
    }


    @Override
    public String toString() {
        return "Flight{"
                + "Flight Number = " + flightNumber2 +
                ", from " + from + " to " + to +
                ", Number Of Seats = " + numOfSeats +
                ", Take Off Date " + takeOffHour + ":" + takeOffMinute + "\n" + takeOffDay + "/" + takeOffMonth + "/" + takeOffYear +
                ",Flight Duration " + flightDuration +
                ", Landing Date " + landingHour + ":" + landingMinute + "\n" + landingDay + "/" + landingMonth + "/" + landingYear + '}';
    }
}