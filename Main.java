package advanced2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ABDALLA
 */
public class Advanced2 extends Application {

    Connection conn = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    ResultSet res = null;
    ObservableList<Flight> data;
    TableView<Flight> table;

    @Override
    public void start(Stage primaryStage) throws IOException {

        FileWriter fr = new FileWriter("log.txt", true);
        PrintWriter pr = new PrintWriter(fr, true);
        Ticket t = new Ticket();
        Managers.newManager(new Managers("Mahmoud", "123"));

        Label l1 = new Label("Welcome to ALEX Science Faculty Airlines");
        Label sm = new Label("Sign in as a manager");
        Label mn = new Label("Name");
        TextField tmn = new TextField();
        Label mp = new Label("Password");
        PasswordField tmp = new PasswordField();
        Label sc = new Label("Enter as a customer");
        Button butsm = new Button("Sign in");
        Button butec = new Button("Enter");

        GridPane g1 = new GridPane();
        g1.add(sm, 1, 2);
        g1.add(mn, 1, 3);
        g1.add(tmn, 2, 3);
        g1.add(mp, 1, 4);
        g1.add(tmp, 2, 4);
        g1.add(sc, 6, 2);
        g1.add(butsm, 1, 5);
        g1.add(butec, 6, 3);
        g1.setVgap(20);
        g1.setHgap(20);
        g1.setPadding(new Insets(160, 160, 160, 160));
        g1.setAlignment(Pos.CENTER);

        GridPane gh = new GridPane();
        gh.add(l1, 0, 7, 2, 2);
        gh.setAlignment(Pos.CENTER);
        gh.setPadding(new Insets(50, 50, 20, 20));
        VBox vb = new VBox(gh, g1);

        Scene scene1 = new Scene(vb, 1000, 500);
        vb.getStyleClass().add("root");
        vb.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene1);
        primaryStage.show();

        Label l2 = new Label("ADD Flight");
        Label fn = new Label("FLIGHT NUMBER");
        TextField tfn = new TextField();
        Label ds = new Label("Destination");
        TextField tds = new TextField();
        Label dp = new Label("Departure");
        TextField tdp = new TextField();
        Label ns = new Label("Number of Seats");
        TextField tns = new TextField();
        Label td = new Label("Take off Date");
        TextField ttd = new TextField();
        Label ld = new Label("Landing Date");
        TextField tld = new TextField();
        Label c = new Label("Cost");
        TextField tc = new TextField();
        Button addbtn = new Button("Add");
        Button cbtn1 = new Button("Clear");

        GridPane g2 = new GridPane();
        g2.add(l2, 0, 0, 3, 1);
        g2.add(fn, 0, 1);
        g2.add(tfn, 0, 2);
        g2.add(ds, 0, 3);
        g2.add(tds, 0, 4);
        g2.add(dp, 0, 5);
        g2.add(tdp, 0, 6);
        g2.add(ns, 0, 7);
        g2.add(tns, 0, 8);
        g2.add(td, 0, 9);
        g2.add(ttd, 0, 10);
        g2.add(ld, 0, 11);
        g2.add(tld, 0, 12);
        g2.add(c, 0, 13);
        g2.add(tc, 0, 14);
        g2.add(addbtn, 0, 15);
        g2.add(cbtn1, 1, 15);
        g2.setHgap(20);
        g2.setVgap(20);
        g2.setAlignment(Pos.CENTER);
        g2.setPadding(new Insets(20, 20, 20, 20));

        table = new TableView<Flight>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No Flights to display"));

        TableColumn c1 = new TableColumn("FLIGHT NUMBER");
        c1.setCellValueFactory(new PropertyValueFactory("flightNumber"));

        TableColumn c2 = new TableColumn("Destination");
        c2.setCellValueFactory(new PropertyValueFactory("to"));

        TableColumn c3 = new TableColumn("Departure");
        c3.setCellValueFactory(new PropertyValueFactory("from"));

        TableColumn c4 = new TableColumn("Number of Seats");
        c4.setCellValueFactory(new PropertyValueFactory("numOfSeats"));

        TableColumn c5 = new TableColumn("Take off Date");
        c5.setCellValueFactory(new PropertyValueFactory("takeOffdate"));

        TableColumn c6 = new TableColumn("Landing Date");
        c6.setCellValueFactory(new PropertyValueFactory("landingDate"));

        TableColumn c7 = new TableColumn("Cost");
        c7.setCellValueFactory(new PropertyValueFactory("cost"));

        table.getColumns().addAll(c1, c2, c3, c4, c5, c6, c7);

        try {
            show();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }

        Label l3 = new Label("Delete Flight by Flight Number: ");
        Label fn2 = new Label("Flight Number");
        TextField tfn2 = new TextField();
        Button deletebtn1 = new Button("Delete");
        Button backbtn1 = new Button("Back");
        Label upla = new Label("Update section");
        Button updatesbtn = new Button("Update");

        GridPane g3 = new GridPane();

        g3.add(l3, 0, 0, 2, 1);
        g3.add(fn2, 0, 1);
        g3.add(tfn2, 1, 1);
        g3.add(deletebtn1, 0, 2);
        g3.add(backbtn1, 2, 9);
        g3.add(upla, 0, 4, 3, 1);
        g3.add(updatesbtn, 0, 5);
        g3.setVgap(20);
        g3.setHgap(20);
        g3.setPadding(new Insets(20, 20, 20, 20));

        Alert am = new Alert(Alert.AlertType.WARNING, "Un correct name or password");
        am.setTitle("Login Fail");

        FlowPane root1 = new FlowPane(g2, table, g3);

        Scene scene2 = new Scene(root1, 1000, 500);

        butsm.setOnAction((ActionEvent actinoEvent) -> {
            for (Managers m : Managers.managersArrayList) {
                if (tmn.getText().equals(m.getFirstName()) && tmp.getText().equals(m.getPassword())) {
                    root1.getStyleClass().add("root");
                    root1.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
                    primaryStage.setTitle("Manage");
                    primaryStage.setScene(scene2);
                    primaryStage.show();
                    return;
                }
            }
            am.show();
        });

        addbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                conn = dbConn.DBConnection();//                                  DEPARTURE
                String sql = "Insert into flights" + "(FLIGHT_NUMBER,DESTINATION,DEPARTURE,NUMBER_OF_SEATS,TAKE_OFF_DATE,LANDING_DATE,COST) Values(?,?,?,?,?,?,?)";

                try {
                    pst = conn.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(tfn.getText()));
                    pst.setString(2, tds.getText());
                    pst.setString(3, tdp.getText());
                    pst.setInt(4, Integer.parseInt(tns.getText()));
                    pst.setString(5, ttd.getText());
                    pst.setString(6, tld.getText());
                    pst.setDouble(7, Double.parseDouble(tc.getText()));

                    int i = pst.executeUpdate();
                    if (i == 1) {
                        System.out.println("Data is inserted");
                        pr.print("Flight number " + Integer.valueOf(tfn.getText()) + " has been added , added at: ");

                        File file = new File("log.txt");
                        // Gets the path of the file
                        Path path = file.toPath();
                        try {
                            // Gets the current date and time
                            LocalDateTime now = LocalDateTime.now();
                            // Converts the date and time to a file time object
                            FileTime fileTime = FileTime.from(now.atZone(ZoneId.systemDefault()).toInstant());
                            // Sets the last modified time of the file
                            Files.setLastModifiedTime(path, fileTime);
                            // Prints the last modified time of the file
                            //System.out.println("File last modified: " + Files.getLastModifiedTime(path));
                            pr.println(now);
                        } catch (IOException e) {// Handles the exception
                            System.out.println(e);
                        }
                    }
                    pst.close();
                    conn.close();
                    show();
                } catch (NumberFormatException | SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        });

        cbtn1.setOnAction((ActionEvent event) -> {

            tfn.clear();
            tds.clear();
            tdp.clear();
            tns.clear();
            ttd.clear();
            tld.clear();
            tc.clear();

        });

        deletebtn1.setOnAction(e -> {
            int flightnum = Integer.parseInt(tfn2.getText());
            String sql = "Delete from Flights where FLIGHT_NUMBER = ?";

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();

                pr.print("Flight number " + Integer.valueOf(tfn.getText()) + " has been deleted , deleted at: ");

                File file = new File("log.txt");
                // Gets the path of the file
                Path path = file.toPath();

                // Gets the current date and time
                LocalDateTime now = LocalDateTime.now();
                // Converts the date and time to a file time object
                FileTime fileTime = FileTime.from(now.atZone(ZoneId.systemDefault()).toInstant());
                try {
                    // Sets the last modified time of the file
                    Files.setLastModifiedTime(path, fileTime);
                } catch (IOException ex) {
                    Logger.getLogger(Advanced2.class.getName()).log(Level.SEVERE, null, ex);
                }
                pr.println(now);

            } catch (NumberFormatException | SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        backbtn1.setOnAction((ActionEvent actinoEvent) -> {
            scene1.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Home");
            primaryStage.setScene(scene1);
            primaryStage.show();
        });

        Label l4 = new Label("Update  A FLIGHT NUMBER using Flight number");
        Label fn3 = new Label("Flight number");
        TextField tfn3 = new TextField();
        Label nfn = new Label("New FLIGHT NUMBER");
        TextField ntfn = new TextField();
        Button updatebtn1 = new Button("Update");
        GridPane g4 = new GridPane();
        g4.add(l4, 0, 0, 2, 1);
        g4.add(fn3, 0, 1);
        g4.add(tfn3, 1, 1);
        g4.add(nfn, 0, 2);
        g4.add(ntfn, 1, 2);
        g4.add(updatebtn1, 1, 3);
        g4.setHgap(20);
        g4.setVgap(20);
        g4.setPadding(new Insets(20));

        Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a1.setTitle("action");

        updatebtn1.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn3.getText());
            int nflightnum = Integer.parseInt(ntfn.getText());

            String sql = "Update Flights set FLIGHT_NUMBER = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, nflightnum);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a1.show();

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        Label l5 = new Label("Update  A DESTINATION using Flight number");
        Label fn4 = new Label("Flight number");
        TextField tfn4 = new TextField();
        Label nds = new Label("New DESTINATION");
        TextField ntds = new TextField();
        Button updatebtn2 = new Button("Update");
        GridPane g5 = new GridPane();
        g5.add(l5, 0, 0, 2, 1);
        g5.add(fn4, 0, 1);
        g5.add(tfn4, 1, 1);
        g5.add(nds, 0, 2);
        g5.add(ntds, 1, 2);
        g5.add(updatebtn2, 1, 3);
        g5.setHgap(20);
        g5.setVgap(20);
        g5.setPadding(new Insets(20));

        Alert a2 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a2.setTitle("action");

        updatebtn2.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn4.getText());
            String nDESTINATION = ntds.getText();

            String sql = "Update Flights set DESTINATION = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, nDESTINATION);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a2.show();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        Label l6 = new Label("Update  A DEPARTURE using Flight number");
        Label fn5 = new Label("Flight number");
        TextField tfn5 = new TextField();
        Label ndp = new Label("New DEPARTURE");
        TextField ntdp = new TextField();
        Button updatebtn3 = new Button("Update");
        GridPane g6 = new GridPane();
        g6.add(l6, 0, 0, 2, 1);
        g6.add(fn5, 0, 1);
        g6.add(tfn5, 1, 1);
        g6.add(ndp, 0, 2);
        g6.add(ntdp, 1, 2);
        g6.add(updatebtn3, 1, 3);
        g6.setHgap(20);
        g6.setVgap(20);
        g6.setPadding(new Insets(20));

        Alert a3 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a3.setTitle("action");

        updatebtn3.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn5.getText());
            String nDEPARTURE = ntdp.getText();

            String sql = "Update Flights set DEPARTURE = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, nDEPARTURE);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a3.show();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        Label l7 = new Label("Update Number of Seats using Flight number");
        Label fn6 = new Label("Flight number");
        TextField tfn6 = new TextField();
        Label nns = new Label("New Number of Seats");
        TextField ntns = new TextField();
        Button updatebtn4 = new Button("Update");
        GridPane g7 = new GridPane();
        g7.add(l7, 0, 0, 2, 1);
        g7.add(fn6, 0, 1);
        g7.add(tfn6, 1, 1);
        g7.add(nns, 0, 2);
        g7.add(ntns, 1, 2);
        g7.add(updatebtn4, 1, 3);
        g7.setHgap(20);
        g7.setVgap(20);
        g7.setPadding(new Insets(20));

        Alert a4 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a4.setTitle("action");

        updatebtn4.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn6.getText());
            int nNumberofSeats = Integer.parseInt(ntns.getText());

            String sql = "Update Flights set NUMBER_OF_SEATS = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, nNumberofSeats);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a4.show();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        Label l8 = new Label("Update Take off date using Flight number");
        Label fn7 = new Label("Flight number");
        TextField tfn7 = new TextField();
        Label ntd = new Label("New Take off date");
        TextField nttd = new TextField();
        Button updatebtn5 = new Button("Update");
        GridPane g8 = new GridPane();
        g8.add(l8, 0, 0, 2, 1);
        g8.add(fn7, 0, 1);
        g8.add(tfn7, 1, 1);
        g8.add(ntd, 0, 2);
        g8.add(nttd, 1, 2);
        g8.add(updatebtn5, 1, 3);
        g8.setHgap(20);
        g8.setVgap(20);
        g8.setPadding(new Insets(20));

        Alert a5 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a5.setTitle("action");

        updatebtn5.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn7.getText());
            String nTakeoffdate = nttd.getText();

            String sql = "Update Flights set TAKE_OFF_DATE = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, nTakeoffdate);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a5.show();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        Label l9 = new Label("Update Landing date using Flight number");
        Label fn8 = new Label("Flight number");
        TextField tfn8 = new TextField();
        Label nld = new Label("New Landing date");
        TextField ntld = new TextField();
        Button updatebtn6 = new Button("Update");

        GridPane g9 = new GridPane();
        g9.add(l9, 0, 0, 2, 1);
        g9.add(fn8, 0, 1);
        g9.add(tfn8, 1, 1);
        g9.add(nld, 0, 2);
        g9.add(ntld, 1, 2);
        g9.add(updatebtn6, 1, 3);
        g9.setHgap(20);
        g9.setVgap(20);
        g9.setPadding(new Insets(20));

        Alert a6 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a6.setTitle("action");

        updatebtn6.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn8.getText());
            String nLandingdate = ntld.getText();

            String sql = "Update Flights set LANDING_DATE = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, nLandingdate);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a6.show();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        Label l10 = new Label("Update  FLIGHT Cost using Flight number");
        Label fn9 = new Label("Flight number");
        TextField tfn9 = new TextField();
        Label nc = new Label("New FLIGHT Cost");
        TextField ntnc = new TextField();
        Button updatebtn7 = new Button("Update");
        Button backbtn2 = new Button("Back");
        Button backbtnA = new Button("Home");
        GridPane g10 = new GridPane();
        g10.add(l10, 0, 0, 2, 1);
        g10.add(fn9, 0, 1);
        g10.add(tfn9, 1, 1);
        g10.add(nc, 0, 2);
        g10.add(ntnc, 1, 2);
        g10.add(updatebtn7, 1, 3);
        g10.add(backbtn2, 0, 21);
        g10.add(backbtnA, 1, 21);
        g10.setHgap(20);
        g10.setVgap(20);
        g10.setPadding(new Insets(20));
        g10.setAlignment(Pos.CENTER);

        Alert a7 = new Alert(Alert.AlertType.INFORMATION, "Updated successfully");
        a7.setTitle("action");

        updatebtn7.setOnAction((ActionEvent event) -> {

            int flightnum = Integer.parseInt(tfn9.getText());
            double nCost = Double.parseDouble(ntnc.getText());

            String sql = "Update Flights set COST = ? where FLIGHT_NUMBER = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setDouble(1, nCost);
                pst.setInt(2, flightnum);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
                a7.show();

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        VBox v1 = new VBox(g4, g5, g6);
        v1.setPadding(new Insets(20));
        VBox v2 = new VBox(g7, g8, g9);
        v2.setPadding(new Insets(20));
//         VBox v3 = new VBox(g10);
//         v3.setPadding(new Insets(20));
        FlowPane root2 = new FlowPane(v1, v2, g10);
        root2.getStyleClass().add("root");
        root2.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
        Scene scene3 = new Scene(root2, 1000, 600);

        backbtn2.setOnAction((ActionEvent actinoEvent) -> {
            scene2.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Manage");
            primaryStage.setScene(scene2);
            primaryStage.show();
        });

        backbtnA.setOnAction((ActionEvent actinoEvent) -> {
            scene1.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Home");
            primaryStage.setScene(scene1);
            primaryStage.show();
        });

        updatesbtn.setOnAction((ActionEvent actinoEvent) -> {
            root2.getStyleClass().add("root");
            root2.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Update section");
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        Label l11 = new Label("Choose transaction");
        Label bt = new Label("Book a ticket");
        Label cb = new Label("Cancel Book");
        Button btbtn = new Button("Book");
        Button cbbtn = new Button("Cancel");
        Button backbtn3 = new Button("Back");

        GridPane g11 = new GridPane();
        g11.add(l11, 2, 0, 3, 1);
        g11.add(bt, 0, 3);
        g11.add(btbtn, 0, 4);
        g11.add(cb, 5, 3);
        g11.add(cbbtn, 5, 4);
        g11.add(backbtn3, 6, 8);
        g11.setHgap(20);
        g11.setVgap(20);
        g11.setAlignment(Pos.CENTER);

        Scene scene4 = new Scene(g11, 1000, 500);
        g11.getStyleClass().add("root");
        g11.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());

        butec.setOnAction((ActionEvent actinoEvent) -> {
            g11.getStyleClass().add("root");
            g11.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("services");
            primaryStage.setScene(scene4);
            primaryStage.show();
        });

        backbtn3.setOnAction((ActionEvent actinoEvent) -> {
            scene1.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Home");
            primaryStage.setScene(scene1);
            primaryStage.show();
        });
        Label l12 = new Label("Search for Flight");
        Label ds2 = new Label("Destination");
        TextField tds2 = new TextField();
        Label dp2 = new Label("Departure");
        TextField tdp2 = new TextField();
        Label td2 = new Label("Take off Date");
        TextField ttd2 = new TextField();
        Label rslt = new Label("?");
        Text note1 = new Text("Note:the search result follow the following sequence:");
        Text note2 = new Text("FLIGHT NUMBER>>DESTINATION>>DEPARTURE>>");
        Text note3 = new Text("NUMBER OF SEATS>>TAKE OFF DATE>>LANDING DATE>>COST");
        Text note4 = new Text("Note:you will need the Flight number to book a ticket");
        Button srcbtn = new Button("Search");
        Label ll = new Label("Booking section");
        Button bs = new Button("Enter");
        Button clbtn = new Button("Clear");
        Button backbtn4 = new Button("Back");

        GridPane g12 = new GridPane();
        g12.add(l12, 0, 0, 2, 1);
        g12.add(ds2, 0, 1);
        g12.add(tds2, 1, 1);
        g12.add(dp2, 0, 2);
        g12.add(tdp2, 1, 2);
        g12.add(td2, 0, 3);
        g12.add(ttd2, 1, 3);
        g12.add(rslt, 0, 5);
        g12.add(srcbtn, 1, 4);
        g12.add(backbtn4, 7, 10);
        g12.add(ll, 5, 0);
        g12.add(bs, 5, 1);
        g12.add(note1, 0, 6);
        g12.add(note2, 0, 7);
        g12.add(note3, 0, 8);
        g12.add(note4, 0, 9);
        g12.add(clbtn, 2, 4);
        g12.setHgap(20);
        g12.setVgap(20);
        g12.setAlignment(Pos.CENTER);

        Scene scene5 = new Scene(g12, 1000, 500);

        Alert a8 = new Alert(Alert.AlertType.WARNING, "No Flights matched");
        a8.setTitle("search");

        btbtn.setOnAction((ActionEvent actinoEvent) -> {
            g12.getStyleClass().add("root");
            g12.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Book page");
            primaryStage.setScene(scene5);
            primaryStage.show();
        });

        backbtn4.setOnAction((ActionEvent actinoEvent) -> {
            primaryStage.setTitle("services");
            primaryStage.setScene(scene4);
            primaryStage.show();
        });

        srcbtn.setOnAction((ActionEvent event) -> {
            String dss = tds2.getText();
            String dps = tdp2.getText();
            String tds1 = ttd2.getText();

            String sql = "select * from Flights WHERE DESTINATION=? AND DEPARTURE=? AND TAKE_OFF_DATE=?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, dss);
                pst.setString(2, dps);
                pst.setString(3, tds1);
                res = pst.executeQuery();
                if (res.next()) {
                    StringBuilder row = new StringBuilder();
                    for (int i = 1; i <= 7; i++) {
                        row.append(res.getString(i));
                        if (i != 7) {
                            row.append(", ");
                        }
                    }
                    String result = row.toString();
                    rslt.setText(result);
                } else {
                    a8.show();
                }
                pst.close();
                conn.close();

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        });

        clbtn.setOnAction((ActionEvent event) -> {
            tds2.clear();
            tdp2.clear();
            ttd2.clear();
        });

        Label ln = new Label("Name");
        Label lp = new Label("Phone number");
        Label lfn = new Label("Flight number");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        Button b = new Button("Book");
        Button backbtn5 = new Button("Back");
        Button backbtnAA = new Button("Home");
        Label rd = new Label("Choose class");
        RadioButton r1 = new RadioButton("economic");
        RadioButton r2 = new RadioButton("first");
        RadioButton r3 = new RadioButton("business men");
        CheckBox cb1 = new CheckBox("i  agree....");
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        r1.setSelected(true);

        GridPane g13 = new GridPane();
        g13.add(ln, 0, 0);
        g13.add(t1, 1, 0);
        g13.add(lp, 0, 1);
        g13.add(t2, 1, 1);
        g13.add(lfn, 0, 2);
        g13.add(t3, 1, 2);
        g13.add(rd, 0, 3);
        g13.add(r1, 0, 4);
        g13.add(r2, 1, 4);
        g13.add(r3, 2, 4);
        g13.add(cb1, 0, 5);
        g13.add(b, 2, 6);
        g13.add(backbtn5, 5, 8);
        g13.add(backbtnAA, 6, 8);
        g13.setHgap(20);
        g13.setVgap(20);
        g13.setAlignment(Pos.CENTER);

        Scene scene6 = new Scene(g13, 1000, 500);

        Alert a9 = new Alert(Alert.AlertType.CONFIRMATION, "Booked successfully your ticket number is" + Ticket.ticketNum);
        a9.setTitle("book");
        Alert a10 = new Alert(Alert.AlertType.ERROR, "No Flights matched the flight number");
        a10.setTitle("error");
        Alert a11 = new Alert(Alert.AlertType.ERROR, "you have to agree to the terms");
        a11.setTitle("error");

        bs.setOnAction((ActionEvent actinoEvent) -> {
            g13.getStyleClass().add("root");
            g13.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Book page");
            primaryStage.setScene(scene6);
            primaryStage.show();
        });

        backbtn5.setOnAction((ActionEvent actinoEvent) -> {
            primaryStage.setTitle("Book page");
            primaryStage.setScene(scene5);
            primaryStage.show();
        });

        backbtnAA.setOnAction((ActionEvent actinoEvent) -> {
            scene1.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Home");
            primaryStage.setScene(scene1);
            primaryStage.show();
        });

        b.setOnAction((ActionEvent event) -> {
            Customer.customerArrayList.add(new Customer(t1.getText(), t2.getText()));
            if (cb1.isSelected()) {
                boolean flag = false;
                try {
                    flag = t.bookATicket(conn, pst, pst1, res, t1.getText(), t2.getText(), t3.getText(), tg, r1, r2);
                } catch (SQLException ex) {
                    Logger.getLogger(Advanced2.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (flag) {
                    pr.print("Ticket number " + Ticket.ticketNum + " has been booked by " + t1.getText() + " with this phone number " + t2.getText() + " , added at: ");
                    File file = new File("log.txt");
                    // Gets the path of the file
                    Path path = file.toPath();
                    try {
                        // Gets the current date and time
                        LocalDateTime now = LocalDateTime.now();
                        // Converts the date and time to a file time object
                        FileTime fileTime = FileTime.from(now.atZone(ZoneId.systemDefault()).toInstant());
                        // Sets the last modified time of the file
                        Files.setLastModifiedTime(path, fileTime);
                        // Prints the last modified time of the file
                        //System.out.println("File last modified: " + Files.getLastModifiedTime(path));
                        pr.println(now);
                    } catch (IOException e) {// Handles the exception
                        System.out.println(e);
                    }
                    pr.close();
                }
                if (flag) {
                    a9.show();
                    Ticket.ticketNum++;
                    a9.setContentText("Booked successfully your ticket number is" + (Ticket.ticketNum - 1));
                } else {
                    a10.show();
                }
            } else {
                a11.show();
            }
        });

        Label nn = new Label("Name");
        Label tn = new Label("Ticket Number");
        TextField t4 = new TextField();
        TextField t5 = new TextField();
        Button del = new Button("Delete");
        Button backbtn6 = new Button("Back");

        GridPane g14 = new GridPane();
        g14.add(nn, 0, 0);
        g14.add(tn, 0, 1);
        g14.add(t4, 1, 0);
        g14.add(t5, 1, 1);
        g14.add(del, 1, 2);
        g14.add(backbtn6, 7, 7);
        g14.setHgap(20);
        g14.setVgap(20);
        g14.setAlignment(Pos.CENTER);

        Scene scene7 = new Scene(g14, 1000, 500);

        Alert a12 = new Alert(Alert.AlertType.CONFIRMATION, "Ticket Deleted");
        a12.setTitle("canceled");
        Alert a13 = new Alert(Alert.AlertType.ERROR, "No ticket with this info");
        a13.setTitle("error");

        backbtn6.setOnAction((ActionEvent actinoEvent) -> {
            primaryStage.setTitle("services");
            primaryStage.setScene(scene4);
            primaryStage.show();
        });

        del.setOnAction(e -> {
            t.cancelATicketReservation(conn, pst, t4.getText(), t5.getText(),a12,a13);
        });

        cbbtn.setOnAction((ActionEvent actinoEvent) -> {
            g14.getStyleClass().add("root");
            g14.getStylesheets().add((new File("src/advanced2/style.css")).toURI().toString());
            primaryStage.setTitle("Cancel Resrvation page");
            primaryStage.setScene(scene7);
            primaryStage.show();
        });

    }

    public void show() throws SQLException {

        data = FXCollections.observableArrayList();
        conn = dbConn.DBConnection();

        pst = conn.prepareStatement("select * from Flights");
        res = pst.executeQuery();

        while (res.next()) {
            data.add(new Flight(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), res.getString(6), res.getDouble(7)));
        }
        pst.close();
        conn.close();
        table.setItems(data);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
