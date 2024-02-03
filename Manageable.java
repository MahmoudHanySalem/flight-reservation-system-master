/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package collegeproject;


public interface Manageable {

    void addFlight(Manage m1);
    void deleteFlight(int num);
    void updateFlight(Flight F);
    void showFlights();
    void searchSpecificFlight(int num);
}