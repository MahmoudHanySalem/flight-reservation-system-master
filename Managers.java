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
public class Managers {
    String firstName ,password;
    public static ArrayList<Managers> managersArrayList = new ArrayList<>();

    public Managers(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }
    
    public static void newManager(Managers m){
        managersArrayList.add(m);
    }
    
}
