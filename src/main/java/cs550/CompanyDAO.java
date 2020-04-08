package cs550;

import java.sql.*;
import java.util.Set;

public class CompanyDAO {
    private Connection con;
    private static CompanyDAO dao;

    private CompanyDAO () {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "smoothat", "whoalyde");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static CompanyDAO getInstance() {
        if(dao == null) {
            dao = new CompanyDAO();
        }
        return  dao;

    }

    public Boolean isManager(String ssn) {
        Statement stmt = null;
        String query = "SELECT MGRSSN FROM DEPARTMENT WHERE MGRSSN ="+ssn;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next() == true) {
               return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public void saveEmployeeDetails(EmployeeBean newEmployee) {

        try {
            String query = "INSERT INTO EMPLOYEE (FNAME,MINIT,LNAME,SSN,BDATE," +
                    "ADDRESS,SEX,SALARY,SUPERSSN,DNO) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, newEmployee.getFirstName());
            preparedStmt.setString(2, newEmployee.getMiddleInitials());
            preparedStmt.setString(3, newEmployee.getLastName());
            preparedStmt.setString(4, newEmployee.getSsn());
            preparedStmt.setString(5, newEmployee.getDateOfBirth());
            preparedStmt.setString(6, newEmployee.getAddress());
            preparedStmt.setString(7, newEmployee.getSex());
            preparedStmt.setString(8, newEmployee.getSalary());
            preparedStmt.setString(9, newEmployee.getSupervisorSsn());
            preparedStmt.setString(10, newEmployee.getDepartmentNumber());
            preparedStmt.execute();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveJobDetails(ProjectBean job, String essn)  {
        try {
            String query = "INSERT INTO WORKS_ON (ESSN,PNO,HOURS) VALUES(?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            if(!job.getHr1().equals("0")) {
                preparedStmt.setString(1,essn);
                preparedStmt.setString(2,"1");
                preparedStmt.setString(3,job.getHr1());
                preparedStmt.execute();
            }
            if(!job.getHr2().equals("0")) {
                preparedStmt.setString(1,essn);
                preparedStmt.setString(2,"2");
                preparedStmt.setString(3,job.getHr2());
                preparedStmt.execute();
            }
            if(!job.getHr3().equals("0")) {
                preparedStmt.setString(1,essn);
                preparedStmt.setString(2,"3");
                preparedStmt.setString(3,job.getHr3());
                preparedStmt.execute();
            }
            if(!job.getHr10().equals("0")) {
                preparedStmt.setString(1,essn);
                preparedStmt.setString(2,"10");
                preparedStmt.setString(3,job.getHr10());
                preparedStmt.execute();
            }
            if(!job.getHr20().equals("0")) {
                preparedStmt.setString(1,essn);
                preparedStmt.setString(2,"20");
                preparedStmt.setString(3,job.getHr20());
                preparedStmt.execute();
            }
            if(!job.getHr30().equals("0")) {
                preparedStmt.setString(1,essn);
                preparedStmt.setString(2,"30");
                preparedStmt.setString(3,job.getHr30());
                preparedStmt.execute();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void saveDependentDetails(DependentBean db, String essn) {
        try {
            String query = "INSERT INTO DEPENDENT (ESSN,DEPENDENT_NAME, SEX, BDATE,RELATIONSHIP) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, essn);
            preparedStmt.setString(2, db.getName() );
            preparedStmt.setString(3, db.getSex());
            preparedStmt.setString(4, db.getDateOfBirth());
            preparedStmt.setString(5, db.getRelationship());
            preparedStmt.execute();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


}
