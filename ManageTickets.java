/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegeproject;

import java.util.ArrayList;


public class ManageTickets extends Manage implements Bookable {

   
    public static ArrayList <Ticket> ticketArrayList = new ArrayList<>();
    public static ArrayList <Passenger> passengerArrayList = new ArrayList<>();

    public ManageTickets(){}

    public ManageTickets(double cost, String FlayingClass, String ownerName,String phoneNumber){
        super(cost,FlayingClass,ownerName,phoneNumber);
    }

    public ManageTickets(String firstName, String secondName, String e_mail, String gender, String number, String passportNum, int age){
        super(firstName,secondName,e_mail,gender,number,passportNum,age);
    }
    //String firstName, String secondName, String e_mail, String gender, String number, String passportNum, int age
    @Override
    public void addPassenger(ManageTickets mt1) {
        passengerArrayList.add(new Passenger(mt1.getFirstName(),mt1.getSecondName(),mt1.getE_mail(),mt1.getGender(),mt1.getNumber(),mt1.getPassportNum(),mt1.getAge()));
        numberOfPassenger++;
    }

    @Override
    public void searchForFlights1( String departure,String Destination,String departureDate) {
        String[] dateParts = departureDate.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        boolean teller=false;
        for(int i=0;i<arrayList.size();i++){
            if(((arrayList.get(i).getFrom()).equals(departure)) &&((arrayList.get(i).getTo()).equals(Destination))&& ((arrayList.get(i).getTakeOffDay())==Integer.parseInt(day)) && ((arrayList.get(i).getTakeOffMonth())==Integer.parseInt(month))){
                System.out.println(arrayList.get(i).toString());
                teller=true;
            }
        }
        if(teller==false){
            System.out.println("No flights matches");}
    }

    @Override
    public void searchForFlights2(String departure, String Destination, String returnDate) {
        String[] dateParts = returnDate.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        boolean teller=false;
        for(int i=0;i<arrayList.size();i++){
            if(((arrayList.get(i).getFrom()).equals(departure)) &&((arrayList.get(i).getTo()).equals(Destination))&& ((arrayList.get(i).getLandingDay())==Integer.parseInt(day)) && ((arrayList.get(i).getLandingMonth())==Integer.parseInt(month))){
                System.out.println(arrayList.get(i).toString());
                teller=true;
            }
        }
        if(teller==false){
            System.out.println("No flights matches");}
    }

    @Override
    public void viewTicketPriceInformation() {
        System.out.println("""
                            The cost of the ticket is due to two aspects:
                            1: flight class:
                            # economy class ticket:extra 25 Dollar for Services.
                            # first class ticket: extra 75 Dollar for Services.
                            # business men class ticket: extra 200 Dollar for Services.
                            2:the duration of the trip:
                            #From 10 to 30 minutes An Avrage of 10 Dollar.
                            #From 31 minutes to 2 hours An Avrage of 37.75 Dollar.
                            #From 2 hours to 10 hours An Avrage of 180 Dollar.
                            #From 10 hours to a day An Avrage of 510 Dollar.
                            #From a day to a day and 10 hours An Avrage of 870 Dollar.
                            """);
    }

    @Override
    public void bookATicket(ManageTickets mt2) {
        //double cost, String FlayingClass, String ownerName,String phoneNumber
        ticketArrayList.add(new Ticket(mt2.getCost(),mt2.getFlayingClass(),mt2.getOwnerName(),mt2.getPhoneNumber()));
        ticketNum++;
    }

    @Override
    public void cancelATicketReservation(int num3) {
        ticketArrayList.remove(num3-1);
    }

    @Override
    public void viewYourTicketDetails(String owmerName,String phoneNumber) {
        boolean teller2=false;
        for(int i=0;i<ticketArrayList.size();i++){
            if((owmerName.equals(ticketArrayList.get(i).ownerName)) && (phoneNumber.equals(ticketArrayList.get(i).phoneNumber)) ){
                System.out.println(ticketArrayList.get(i).toString());
                teller2=true;
            }
        }
        if(teller2==false){
            System.out.println("no Tickets match");
        }
    }
}