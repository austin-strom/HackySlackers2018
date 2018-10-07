package RESTAPI;

import java.sql.*;

public class SQLQueryBuilder {
    private Connection conn;
    private Array ages;
    private Array race;
    private Array gender;
    private Array famHist;
    private Array cancer_type;
    private Array bmi;

    public Array getBmi() {
        return bmi;
    }

    public Array getAges() {
        return ages;
    }

    public Array getRace() {
        return race;
    }

    public Array getGender() {
        return gender;
    }

    public Array getFamHist() {
        return famHist;
    }

    public Array getCancer_type() {
        return cancer_type;
    }


    public SQLQueryBuilder() {
        Connection conn = null;
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        } catch (Exception ex) {
            // handle the error
            System.out.println("New Instance not working");
        }
        try {
            this.conn =  DriverManager.getConnection("jdbc:mysql://hacky-slacker.c1o9nb66eytr.us-east-2.rds.amazonaws.com:3306/acwashington?" +
                    "user=acwashington&password=T435as7ba!");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConnection() throws SQLException {

        return conn;
    }
    public void getData() throws SQLException {
        String query = "SELECT * FROM CancerData";
        Statement st = conn.createStatement();
        ResultSet results = st.executeQuery(query);

        ages = results.getArray("age");
        race = results.getArray("race");
        gender = results.getArray("gender");
        bmi = results.getArray("bmi");
        famHist = results.getArray("familyHistory");
        cancer_type = results.getArray("cancer_type");
    }
}
