/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegeproject;

public class Ticket {
      public static int ticketNum=1;
    int ticketNumber;
    double cost;
    String FlayingClass,ownerName,phoneNumber;

    public Ticket(){}
    public Ticket(double cost, String FlayingClass, String ownerName,String phoneNumber) {
        this.ticketNumber =ticketNum;
        this.cost = cost;
        this.FlayingClass = FlayingClass;
        this.ownerName = ownerName;
        this.phoneNumber=phoneNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public double getCost() {
        return cost;
    }

    public String getFlayingClass() {
        return FlayingClass;
    }

    public void setFlayingClass(String FlayingClass) {
        this.FlayingClass = FlayingClass;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketNumber=" + ticketNumber + ", cost=" + cost + ", FlayingClass=" + FlayingClass + ", ownerName=" + ownerName + ", phoneNumber=" + phoneNumber + '}';
    }
}