package advanced2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Mahomod
 */
public class Ticket implements Bookable {

    public static int ticketNum = 1;
    int flightNumber, ticketNumber;
    double cost;
    String FlayingClass, ownerName, phoneNumber;

    public Ticket() {
    }

    public Ticket(int flightNumber, String ownerName, String phoneNumber, String FlayingClass, double cost) {
        this.flightNumber = flightNumber;
        this.ticketNumber = ticketNum;
        this.cost = cost;
        this.FlayingClass = FlayingClass;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        ticketNum++;
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

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public static int getTicketNum() {
        return ticketNum;
    }

    public static void setTicketNum(int ticketNum) {
        Ticket.ticketNum = ticketNum;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public boolean bookATicket(Connection conn, PreparedStatement pst, PreparedStatement pst1, ResultSet res, String t1, String t2, String t3, ToggleGroup tg, RadioButton r1, RadioButton r2) throws SQLException {
        conn = dbConn.DBConnection();
        String sql = "Insert into Tickets" + "(TICKET_NUMBER,FLIGHT_NUMBER,OWNER_NAME,PHONE_NUMBER,FLAYING_CLASS,COST) Values(?,?,?,?,?,?)";
        String sql1 = "select COST from Flights WHERE FLIGHT_NUMBER=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Ticket.ticketNum);
            pst.setInt(2, Integer.parseInt(t3));
            pst.setString(3, t1);
            pst.setString(4, t2);
            if (tg.getSelectedToggle() == r1) {
                pst.setString(5, "economic");
            } else if (tg.getSelectedToggle() == r2) {
                pst.setString(5, "first");
            } else {
                pst.setString(5, "business men");
            }
            pst1 = conn.prepareStatement(sql1);
            pst1.setString(1, t3);
            res = pst1.executeQuery();
            if (res.next()) {
                pst.setDouble(6, res.getDouble("COST"));
            }
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.toString());
        }
        int i = pst.executeUpdate();
        pst.close();
        conn.close();
        return i == 1;
    }

    @Override
    public void cancelATicketReservation(Connection conn, PreparedStatement pst, String t4, String t5, Alert a12,Alert a13) {
        String sql = "Delete from Tickets where TICKET_NUMBER = ? AND OWNER_NAME=?";

        conn = dbConn.DBConnection();
        int flag=0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(t5));
            pst.setString(2, t4);
            flag = pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.toString());
        }
        if(flag==1){
            a12.show();
        }
        else{
            a13.show();
        }
    }

}
