/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advanced2;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud
 */
public class Customer {
    String name,phoneNumber;
    public static ArrayList<Customer> customerArrayList = new ArrayList<>();

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
