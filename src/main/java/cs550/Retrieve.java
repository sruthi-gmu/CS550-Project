package cs550;

import java.sql.*;

public class Retrieve {
    private Connection con;

    public Retrieve() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "smoothat", "whoalyde");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Statement stmt = null;
        Retrieve r = new Retrieve();
        String query1 = "SELECT LNAME, SSN FROM EMPLOYEE,DEPARTMENT" +
                " WHERE DNAME ='Research' AND DNUMBER = DNO";
        try {
            stmt = r.con.createStatement();
            ResultSet rs = stmt.executeQuery(query1);
            System.out.println("Employees work in Research department");
            System.out.println("Lastname\tSSN");
            while (rs.next()) {
                String lastName = rs.getString("LNAME");
                int ssn = rs.getInt("SSN");
                System.out.println(lastName + "\t" + ssn);
            }
        } catch (SQLException e) {
        }

        String query2 = "SELECT LNAME,SSN,HOURS " +
                "FROM EMPLOYEE,DEPT_LOCATIONS,PROJECT,WORKS_ON " +
                "WHERE DLOCATION='Houston' AND PNAME = 'ProductZ' " +
                "AND DNO = DEPT_LOCATIONS.DNUMBER " +
                "AND DEPT_LOCATIONS.DNUMBER = DNUM " +
                "AND PNUMBER = PNO AND SSN = ESSN";
        try {
            stmt = r.con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            System.out.println("Employees who work in departments located in Houston and work on the project ‘ProductZ");
            System.out.println("Lastname\tSSN\t\tHours");
            while (rs.next()) {
                String lastName = rs.getString("LNAME");
                int ssn = rs.getInt("SSN");
                int hours = rs.getInt("HOURS");

                System.out.println(lastName + "\t" + ssn+"\t" + hours);
            }
        } catch (SQLException e) {
        }

    }
}
