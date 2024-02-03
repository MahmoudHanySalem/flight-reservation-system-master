/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collegeproject;

import static collegeproject.Manage.arrayList;
import static collegeproject.ManageTickets.ticketArrayList;
import static collegeproject.Passenger.numberOfPassenger;
import java.util.Scanner;

public class Main {


    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);

        Manage dm =new Manage();
        ManageTickets mt = new ManageTickets();

        Managers manager1 = new Managers("abdalla", "sobhy", "jj_q86@cj_og", "Abcdefghi@gmail.com", "male", "01154157541", 20);
        Managers manager2 = new Managers("Mahmoud", "Hany", "123", "mahmoud@gmail.com", "male", "01200703176", 19);

        String name1="",password;

        boolean sflag=false;
        while(sflag==false){
            System.out.println("WELCOME TO AIRPLANE TICKET RESERVATION SYSTEM"+"\n"
                    +"press 1 for managers programme and 2 for passengers programme or 0 to exit");
            int mchoice=in.nextInt();
            if(mchoice==0){
                System.out.println("THANKS FOR USING OUR APPLICATION");
                sflag=true;
            }
            else if ( mchoice== 1) {
                boolean flag1 = false;
                while (flag1 == false) {
                    System.out.println("enter your first name");
                    name1 = in.next();
                    if (!name1.equalsIgnoreCase(manager1.getFirstName()) && !name1.equals(manager2.getFirstName())) {
                        System.out.println("wrong first name");
                    } else {
                        flag1 = true;
                    }
                }

                boolean flag2 = false;
                while (flag2 == false) {
                    System.out.println("enter your password");
                    password = in.next();
                    if (!password.equalsIgnoreCase(manager1.getPassword()) && !password.equals(manager2.getPassword())) {
                        System.out.println("wrong password");
                    } else {
                        flag2 = true;
                    }
                }
                System.out.println("WELCOME BACK "+name1);
                boolean flag3 = false;
                while (flag3 == false) {
                    System.out.println("press 1 to add a flight"+"\n"+"press 2 to delete a flight"+"\n"+
                            "press 3 to update a flight"+"\n"+"press 4 to show flights"+"\n"+"press 5 to search specific flight"+
                            "\n"+"press 0 to exit"+"\n"+"press 6 to get back");
                    int choice =in.nextInt();

                        if (choice == 0) {
                            boolean nestedFlag = false;
                            while (!nestedFlag) {
                            System.out.println("are you sure you want to exit(YES/NO)");
                            String yn = in.next();
                            if (yn.equalsIgnoreCase("yes")) {
                                System.out.println("THANKS FOR USING OUR APPLICATION");
                                return;
                            } else if (yn.equalsIgnoreCase("no")) {
                                nestedFlag = true;
                            } else {
                                System.out.println("please enter YES or NO ");
                            }
                        }
                    }
                     if (choice == 1) {
                        System.out.println("enter The country traveling from ");
                        String from = in.next();
                        System.out.println("enter the country going to ");
                        String to = in.next();
                        System.out.println("enter the takeoff minute ");
                        int takeOffMinute = 0;
                        boolean flag4 = false;
                        while (!flag4) {
                            takeOffMinute = in.nextInt();
                            if (takeOffMinute < 1 || takeOffMinute > 60) {
                                System.out.println("invalid take Off Minute"+"\n"+"enter valid take Off Minute");
                            } else {
                                flag4 = true;
                            }
                        }

                        System.out.println("enter the takeoff hour ");
                        int takeOffHour = 0;
                        boolean flag5 = false;
                        while (!flag5) {
                            takeOffHour = in.nextInt();
                            if (takeOffHour < 0 || takeOffHour > 24) {
                                System.out.println("invalid take Off Hour"+"\n"+"enter valid take Off Hour");
                            } else {
                                flag5 = true;
                            }
                        }

                        System.out.println("enter the takeoff day ");
                        int takeOffDay = 0;
                        boolean flag6 = false;
                        while (!flag6) {
                            takeOffDay = in.nextInt();
                            if (takeOffDay < 1 || takeOffDay > 31) {
                                System.out.println("invalid day date"+"\n"+"enter the takeoff day");
                            } else {
                                flag6 = true;
                            }
                        }

                        System.out.println("enter the takeoff month ");
                        int takeOffMonth = 0;
                        boolean flag7 = false;
                        while (!flag7) {
                            takeOffMonth = in.nextInt();
                            if (takeOffMonth < 1 || takeOffMonth > 12) {
                                System.out.println("invalid month date"+"\n"+"enter the takeoff month");
                            } else {
                                flag7 = true;
                            }
                        }

                        System.out.println("enter the takeoff year ");
                        int takeOffYear = 0;
                        boolean flag8 = false;
                        while (!flag8) {
                            takeOffYear = in.nextInt();
                            if (takeOffYear < 2023 || takeOffYear > 2050) {
                                System.out.println("invalid Year date"+"\n"+"enter the takeoff year");
                            } else {
                                flag8 = true;
                            }
                        }

                        int flightDuration =0;
                        boolean flag9=false;
                        while(!flag9){
                            System.out.println("enter flight Duration in minute");
                            flightDuration=in.nextInt();
                            if(flightDuration<=0 || flightDuration>1125){
                                System.out.println("invalide flight Duration");
                            }
                            else{
                                flag9=true;}
                        }

                        int numOfSeats = 0;
                        boolean flag10 = false;
                        while (!flag10) {
                            System.out.println("please enter number of seats");
                            numOfSeats = in.nextInt();
                            if (numOfSeats < 1 || numOfSeats > 500) {
                                System.out.println("invalide number of seats");
                            } else {
                                flag10 = true;
                            }
                        }
                        int[] landinDate=Flight.calculateLandingTime(takeOffMinute, takeOffHour, takeOffDay, takeOffMonth, takeOffYear, flightDuration);
                        int landingMunite =landinDate[0];
                        int landingHour =landinDate[1];
                        int landingDay =landinDate[2];
                        int landingMonth =landinDate[3];
                        int landingYear =landinDate[4];
                        Manage m1 = new Manage(to, from, numOfSeats, takeOffMinute, takeOffHour, takeOffDay, takeOffMonth, takeOffYear,flightDuration,landingMunite,landingHour,landingDay,landingMonth,landingYear);
                        System.out.println("please press 1 to confirm the flight or 2 to abort");
                        if (in.nextInt() == 1) {
                            m1.addFlight(m1);
                            System.out.println("flight has been creatad successfully" + "\n");
                            dm.searchSpecificFlight((arrayList.size()));
                        }
                        else  if(in.nextInt() == 2){
                            System.out.println("Flight add has been aborted");
                        }
                        else
                            System.out.println("invalid choice");

                    }
                    else if(choice ==2){
                        System.out.println("Enter The Number of Flight you want to Delete");
                        int num=in.nextInt();
                        if(num-1<=dm.arrayList.size()){
                            dm.deleteFlight(num);
                            System.out.println("Flight deleted");}
                        else
                            System.out.println("there is no flight with this Number");
                    }
                    else if(choice == 3){
                        System.out.println("Enter The Number of Flight you want to Update");
                        int num=in.nextInt();
                        if(num-1<=dm.arrayList.size()){
                            dm.updateFlight((dm.arrayList.get(num-1)));
                        }
                        else
                            System.out.println("there is no flight with this Number of Flight");
                    }
                    else if(choice == 4){
                        dm.showFlights();
                    }
                    else if(choice == 5){
                        System.out.println("Enter The Number of Flight you want to search about");
                        int num=in.nextInt();
                        if(num-1<=dm.arrayList.size()){
                            dm.searchSpecificFlight(num);
                        }
                        else
                            System.out.println("there is no flight with this Number of Flight");
                    }
                    else if ( choice == 6 ){
                        flag3 = true;
                     }

                }

            }
            else if(mchoice==2){
                boolean flag20=false;
                while(!flag20){
                    System.out.println("Choose what you want to do"+"\n"+"1.View flight schedule"+"\n"+"2.Search for flights" +
                            "\n"+"3.View ticket price information"+"\n"+"4.Book a ticket"+"\n"+"5.Cancel a ticket reservation " +
                            "\n"+"6.View your ticket details"+"\n"+"0.Exit");
                    int choice2=in.nextInt();
                    if(choice2==0){
                        flag20=true;
                    }
                    else if(choice2==1){
                        dm.showFlights();
                    }
                    else if(choice2==2){
                        System.out.println("Enter departure");
                        String departure=in.next();
                        System.out.println("Enter Destination");
                        String Destination =in.next();
                        System.out.println("Enter departure date in this format[day/month]");
                        String departureDate =in.next();
                        boolean flag21=false;
                        while(!flag21){
                            System.out.println("Enter (1) for one-way Ticket ,(2) for Round trip");
                            int choice3=in.nextInt();
                            if(choice3==1){
                                mt.searchForFlights1(departure,Destination,departureDate);
                                flag21=true;
                            }
                            else if(choice3==2){
                                System.out.println("Enter Return date in this format[day/month]");
                                String returnDate=in.next();
                                System.out.println("going flight");
                                System.out.println("");
                                mt.searchForFlights1(departure, Destination, departureDate);
                                System.out.println("coming flight");
                                System.out.println("");
                                mt.searchForFlights2(Destination, departure, returnDate);
                                flag21=true;
                            }
                            else{
                                System.out.println("invaled choise");
                            }}

                    }
                    else if(choice2==3){
                        mt.viewTicketPriceInformation();
                    }
                    else if(choice2==4){
                        boolean ggflag=false;
                        while(!ggflag){
                            System.out.println("Enter first Name");
                            String firstName=in.next();
                            System.out.println("Enter second Name");
                            String secondName=in.next();
                            System.out.println("Enter e_mail");
                            String e_mail=in.next();
                            System.out.println("Enter gender");
                            String gender=in.next();
                            System.out.println("Enter Mobile number");
                            String number=in.next();
                            System.out.println("Enter passport Number");
                            String passportNum=in.next();
                            System.out.println("Enter age");
                            int age=0;
                            boolean flag=false;
                            while(!flag){
                                age=in.nextInt();
                                if( !(age>=5 && age<=90)){
                                    System.out.println("Invaled age\n Enter valed age");
                                }
                                else
                                    flag=true;
                            }

                            ManageTickets mt1=new ManageTickets(firstName,secondName,e_mail,gender,number,passportNum,age);
                            System.out.println("first Name : "+firstName+"\tsecond Name : "+secondName+"\te_mail : "+ e_mail+"\ngender : "+gender+"\tphone number : "+number+"\tpassport Number : "+passportNum+"\tage : "+age);
                            System.out.println("");
                            boolean g2flag=false;
                            while(!g2flag){
                                System.out.println("press 1 to  confirm this information or 2 to abort");
                                int choice00=in.nextInt();
                                if(choice00==1){
                                    mt1.addPassenger(mt1);
                                    ggflag=true;
                                    g2flag=true;
                                }
                                else  if(choice00== 2){
                                    System.out.println("information add has been aborted");
                                    g2flag=true;
                                }
                                else{
                                    System.out.println("invalid choice");}}}
                        System.out.println("");
                        System.out.println("Enter the number of flight you want to book on");
                        int num2=in.nextInt();
                        if(num2-1<dm.arrayList.size()){
                            int duration=(arrayList.get(num2-1).flightDuration);
                            boolean g3flag=false;
                            while(!g3flag){
                                System.out.println("choose ticket class\n1.economic classn\n2.first class\n3.business men class\n<<please make sure to see classes cost info by following this path(choose 2 from main mune then 3)>>");
                                int classChoice=in.nextInt();
                                if(classChoice==1){
                                    g3flag=true;
                                    double cost=duration*0.5+25;
                                    System.out.println("the ticket cost ="+cost);
                                    boolean flag23=false;
                                    while(!flag23){
                                        System.out.println("choose (1) to confirm or (2)to abort ");
                                        int choise5=in.nextInt();
                                        if(choise5==1){
                                            flag23=true;
                                            String flayingClass="economic Class";
                                            ManageTickets mt2=new ManageTickets(cost,flayingClass,mt.passengerArrayList.get(numberOfPassenger-2).getFirstName(),mt.passengerArrayList.get(numberOfPassenger-2).getNumber());
                                            mt2.bookATicket(mt2);
                                            System.out.println("ticket has been booked successfully");
                                            mt.viewYourTicketDetails(mt2.getOwnerName(), mt2.getPhoneNumber());

                                        }
                                        else if(choise5==2){
                                            flag23=true;
                                            System.out.println("booking aborted");
                                        }
                                        else{
                                            System.out.println("invalid choice");
                                        }
                                    }
                                }
                                else if(classChoice==2){
                                    g3flag=true;
                                    double cost=duration*0.5+75;
                                    System.out.println("the ticket cost ="+cost);
                                    boolean flag23=false;
                                    while(!flag23){
                                        System.out.println("choose (1) to confirm or (2)to abort ");
                                        int choise5=in.nextInt();
                                        if(choise5==1){
                                            flag23=true;
                                            String flayingClass="firest Class";
                                            ManageTickets mt2=new ManageTickets(cost,flayingClass,mt.passengerArrayList.get(numberOfPassenger-2).getFirstName(),mt.passengerArrayList.get(numberOfPassenger-2).getNumber());
                                            mt2.bookATicket(mt2);
                                            System.out.println("ticket has been booked successfully");
                                            mt.viewYourTicketDetails(mt2.getOwnerName(), mt2.getPhoneNumber());
                                        }
                                        else if(choise5==2){
                                            flag23=true;
                                            System.out.println("booking aborted");
                                        }
                                        else{
                                            System.out.println("invalid choice");
                                        }
                                    }
                                }
                                else if(classChoice==3){
                                    g3flag=true;
                                    double cost=duration*0.5+200;
                                    System.out.println("the ticket cost ="+cost);
                                    boolean flag23=false;
                                    while(!flag23){
                                        System.out.println("choose (1) to confirm or (2)to abort ");
                                        int choise5=in.nextInt();
                                        if(choise5==1){
                                            flag23=true;
                                            String flayingClass="business men Class";
                                            ManageTickets mt2=new ManageTickets(cost,flayingClass,mt.passengerArrayList.get(numberOfPassenger-2).getFirstName(),mt.passengerArrayList.get(numberOfPassenger-2).getNumber());
                                            mt2.bookATicket(mt2);
                                            System.out.println("ticket has been booked successfully");
                                            mt.viewYourTicketDetails(mt2.getOwnerName(), mt2.getPhoneNumber());
                                        }
                                        else if(choise5==2){
                                            flag23=true;
                                            System.out.println("booking aborted");
                                        }
                                        else{
                                            System.out.println("invalid choice");
                                        }
                                    }
                                }
                                else{
                                    System.out.println("invalide choice");
                                }}
                        }
                        else{
                            System.out.println("there dosen't exist a flight with this flight number");
                        }

                    }
                    else if(choice2==5){
                        System.out.println("Enter number of ticket you want to cancel");
                        int num3=in.nextInt();
                        mt.cancelATicketReservation(num3);
                        System.out.println("Reservation canceld");
                    }
                    else if(choice2==6){
                        System.out.println("Enter your First Name");
                        String name=in.next();
                        System.out.println("Enter your mobile number");
                        String phonenumber=in.next();
                        mt.viewYourTicketDetails(name,phonenumber);

                    }
                }
            }
        }
    }
}
