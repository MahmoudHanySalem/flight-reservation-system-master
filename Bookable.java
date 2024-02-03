/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package collegeproject;


public interface Bookable {
       //   who's gonna implement this need to implement methods from Manageable too
    void addPassenger(ManageTickets mt1);
    void searchForFlights1( String departure,String Destination,String departureDate);
    void searchForFlights2( String departure,String Destination,String returnDate);
    void viewTicketPriceInformation();      // one or more // from, to,  plane type, takeoff time, arrival time, distance, number of seats, passenger info,
    void bookATicket(ManageTickets mt2);          // one or more
    void cancelATicketReservation(int num3);
    void viewYourTicketDetails(String owmerName,String phoneNumber);
}