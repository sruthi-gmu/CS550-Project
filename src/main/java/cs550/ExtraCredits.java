package cs550;

import  java.sql.*;
import java.util.Scanner;

public class ExtraCredits {
    private Connection con;

    public ExtraCredits() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "smoothat", "whoalyde");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void scan() {
        Statement stmt = null;
        ExtraCredits ex = new ExtraCredits();
        String query1 = "SELECT FNAME,LNAME FROM EMPLOYEE WHERE SSN IN (SELECT ESSN FROM WORKS_ON " +
                "GROUP BY ESSN HAVING COUNT(PNO) > 2)";
        try {
            stmt = ex.con.createStatement();
            ResultSet rs = stmt.executeQuery(query1);
            while (rs.next()) {
                String firstName = rs.getString("FNAME");
                String lastName = rs.getString("LNAME");
                System.out.println(firstName +" " + lastName + " works on more than 2 project");
            }
        }catch(SQLException e) {

        }

        String query2 = "SELECT FNAME,LNAME FROM EMPLOYEE WHERE SSN IN (SELECT ESSN FROM WORKS_ON GROUP BY ESSN HAVING COUNT(PNO) < 1)";
        try {
            stmt = ex.con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()) {
                String firstName = rs.getString("FNAME");
                String lastName = rs.getString("LNAME");
                System.out.println(firstName +" " + lastName + " is not working on any project");
            }
        }catch(SQLException e) {

        }
    }
    
    public void insert() {
        Statement stmt = null;
        Scanner in  = new Scanner(System.in);
        ExtraCredits ex = new ExtraCredits();
        System.out.println("Enter the new employee details");
        System.out.println("First name");
        String fname = in.nextLine();
        System.out.println("Middle Initials");
        String minit = in.nextLine();
        System.out.println("Last name");
        String lname = in.nextLine();
        System.out.println("SSN");
        String ssn = in.nextLine();
        System.out.println("Date of Birth: dd-mmm-yyyy");
        String bdate = in.nextLine();
        System.out.println("Address");
        String address = in.nextLine();
        System.out.println("sex: M or F");
        String sex = in.nextLine();
        System.out.println("salary");
        String salary = in.nextLine();
        System.out.println("Supervisor ssn");
        String superssn = in.nextLine();
        System.out.println("Department number");
        String dno = in.nextLine();
        String query1 = "INSERT INTO EMPLOYEE (FNAME,MINIT,LNAME,SSN,BDATE,ADDRESS,SEX,SALARY,SUPERSSN," +
                "DNO) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query1);
            preparedStmt.setString(1, fname);
            preparedStmt.setString(2, minit);
            preparedStmt.setString(3, lname);
            preparedStmt.setString(4, ssn);
            preparedStmt.setString(5, bdate);
            preparedStmt.setString(6, address);
            preparedStmt.setString(7, sex);
            preparedStmt.setString(8, salary);
            preparedStmt.setString(9, superssn);
            preparedStmt.setString(10, dno);
            preparedStmt.execute();
            System.out.println("The values are stored");
        }catch(SQLException e) {
        }

        System.out.println("Enter the projects \n 1.ProductX \n2.ProductY\n3.ProductZ\n4.Computerization\n5.Reorganization\n6.Newbenefits");
        String project = in.nextLine();
        String[] pro = project.split(",");
        if(pro.length > 2) {
            System.out.println("Cannot assign more than two project to an employee");
        }
        else if (pro.length < 1){
            System.out.println("Should assign atleast one project to an employee");
        }
        else {
            for(int i = 0; i < pro.length; i++) {
                String query2 = "INSERT INTO WORKS_ON(ESSN,PNO) VALUES (?,?)";
                try {
                    PreparedStatement preparedStmt = con.prepareStatement(query2);
                    preparedStmt.setString(1, ssn);
                    preparedStmt.setString(2, pro[i]);
                }catch(SQLException e) {
                }
            }
            System.out.println("The project values are stored");
        }
    }
    public static void main(String[] args)  {
        ExtraCredits ex = new ExtraCredits();
        ex.scan();
        ex.insert();
    }
}
