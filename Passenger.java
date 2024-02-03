/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegeproject;


public class Passenger extends Ticket {
   private String firstName, secondName, e_mail, gender, number, passportNum;
    private int age;
    public static int numberOfPassenger=1;
    public Passenger(){}

    public Passenger(double cost, String FlayingClass, String ownerName,String phoneNumber){
        super(cost,FlayingClass,ownerName,phoneNumber);
    }

    public Passenger(String firstName, String secondName, String e_mail, String gender, String number, String passportNum, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.e_mail = e_mail;
        this.gender = gender;
        this.number = number;
        this.passportNum = passportNum;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Passenger{" + "firstName=" + firstName + ", secondName=" + secondName + ", e_mail=" + e_mail + ", gender=" + gender + ", number=" + number + ", passportNum=" + passportNum + ", age=" + age + '}';
    }
}