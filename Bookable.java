/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
 * @author Mahmoud
 */
public interface Bookable {
    boolean bookATicket(Connection conn, PreparedStatement pst, PreparedStatement pst1, ResultSet res, String t1, String t2, String t3,ToggleGroup tg,RadioButton r1,RadioButton r2) throws SQLException;

    void cancelATicketReservation(Connection conn, PreparedStatement pst,String t4,String t5,Alert a12,Alert a13);
}
